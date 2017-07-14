package com.apr.util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.codec.binary.Base64;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Utils {

	public static Object deserialicer(String content, Class<?> clazz) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(content, clazz);
	}

	public static String getPayloadJwt(String idToken) {
		String payload = idToken.split("\\.")[1];
		byte[] bytes = Base64.decodeBase64(payload);
		return new String(bytes, StandardCharsets.UTF_8);
	}

}
