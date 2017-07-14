package com.apr.controller;

import java.io.IOException;
import java.math.BigInteger;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.apr.dto.GoogleIdToken;
import com.apr.dto.TokenResponse;
import com.apr.util.ClientHttp;
import com.apr.util.Utils;

/**
 * 
 * https://developers.google.com/identity/protocols/OpenIDConnect
 * https://developers.google.com/identity/protocols/OAuth2
 * https://developers.google.com/identity/protocols/OAuth2WebServe
 * https://console.cloud.google.com/home/dashboard
 * 
 * @author Antonio
 *
 */
@Stateless
@Path("oauth2")
@Produces({ MediaType.APPLICATION_JSON })
public class ApiController {

	private static String client_id = "216216470128-lur0apaf5kn81s5j46867tb6s06hcuod.apps.googleusercontent.com";
	private static String client_secret = "zWmr2Im939hEmcJ3AM9ZuOpP";
	private static String redirect_uri = "http://localhost:8080/OauthTest/api/oauth2/code";
	private String state;
	private GoogleIdToken googleIdToken;
	private TokenResponse tokenResponse;

	// Server flow

	// 1. Create an anti-forgery state token
	// 2. Send an authentication request to Google
	// http://localhost:8080/OauthTest/api/oauth2/init
	@GET
	@Path("init")
	public Response messageGet() throws URISyntaxException {

		// Create a state token to prevent request forgery.
		// Store it in the session for later validation.
		state = new BigInteger(130, new SecureRandom()).toString(32);
		System.out.println("state create: " + state);
		// Send an authentication request to Google
		StringBuilder sb = new StringBuilder();
		sb.append("https://accounts.google.com/o/oauth2/v2/auth?");
		sb.append("client_id=" + ApiController.client_id);
		sb.append("&response_type=code");
		sb.append("&scope=openid%20email%20https://www.googleapis.com/auth/calendar.readonly");
		sb.append("&redirect_uri=" + ApiController.redirect_uri);
		sb.append("&state=security_token%3D");
		sb.append(state);
		sb.append("&url%3Dhttp://localhost:8080/");

		URI uri = new URI(sb.toString());
		return Response.temporaryRedirect(uri).build();

	}

	@GET
	@Path("code")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response verifyCode(@QueryParam("state") String state, @QueryParam("code") String code,
			@QueryParam("authuser") String authuser, @QueryParam("session_state") String session_state,
			@QueryParam("prompt") String prompt) throws IOException {

		// 3. Confirm anti-forgery state token
		// Ensure that there is no request forgery going on, and that the user
		// sending us this connect request is the user that was supposed to.
		Status response;
		if (!this.state.equals(state.split("=")[1])) {
			response = Response.Status.UNAUTHORIZED;
		} else {
			// 4. Exchange code for access token and ID token
			String grant_type = "authorization_code";

			List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
			urlParameters.add(new BasicNameValuePair("code", code));
			urlParameters.add(new BasicNameValuePair("client_id", client_id));
			urlParameters.add(new BasicNameValuePair("client_secret", client_secret));
			urlParameters.add(new BasicNameValuePair("redirect_uri", redirect_uri));
			urlParameters.add(new BasicNameValuePair("grant_type", grant_type));

			// TODO - recuperar url de forma dinamica
			// https://accounts.google.com/.well-known/openid-configuration
			String responseOauth = ClientHttp.sendRequestPost("https://www.googleapis.com/oauth2/v4/token",
					urlParameters);
			this.tokenResponse = (TokenResponse) Utils.deserialicer(responseOauth, TokenResponse.class);
			String payload = Utils.getPayloadJwt(tokenResponse.getId_token());

			this.googleIdToken = (GoogleIdToken) Utils.deserialicer(payload, GoogleIdToken.class);
			System.out.println(googleIdToken.toString());

			response = Response.Status.OK;
		}
		return Response.status(response).entity(new String(tokenResponse.toString())).build();

	}

	// http://localhost:8080/OauthTest/api/oauth2/calendar_list
	@GET
	@Path("calendar_list")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getCalendar() throws IOException {
		// Get calendar list whit access_token
		StringBuilder parameters = new StringBuilder();
		parameters.append("key=" + client_id);
		parameters.append("&access_token=" + this.tokenResponse.getAccess_token());

		String responseCalendarList = ClientHttp
				.sendRequestGet("https://www.googleapis.com/calendar/v3/users/me/calendarList?", parameters.toString());

		return Response.status(Response.Status.OK).entity(new String(responseCalendarList)).build();

	}

	// http://localhost:8080/OauthTest/api/oauth2/refresh_token

	@GET
	@Path("refresh_token")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response refreshToken() throws IOException {

		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		urlParameters.add(new BasicNameValuePair("refresh_token", this.tokenResponse.getRefresh_token()));
		urlParameters.add(new BasicNameValuePair("client_id", client_id));
		urlParameters.add(new BasicNameValuePair("client_secret", client_secret));
		urlParameters.add(new BasicNameValuePair("grant_type", "refresh_token"));

		String responseOauth = ClientHttp.sendRequestPost("https://www.googleapis.com/oauth2/v4/token", urlParameters);
		this.tokenResponse = (TokenResponse) Utils.deserialicer(responseOauth, TokenResponse.class);
		String payload = Utils.getPayloadJwt(tokenResponse.getId_token());

		this.googleIdToken = (GoogleIdToken) Utils.deserialicer(payload, GoogleIdToken.class);
		System.out.println(googleIdToken.toString());

		return Response.status(Response.Status.OK).entity(new String(tokenResponse.toString())).build();

	}

}
