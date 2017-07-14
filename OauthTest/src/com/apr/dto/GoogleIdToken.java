package com.apr.dto;

public class GoogleIdToken {
	private String iss;
	private String at_hash;
	private String email_verified;
	private String sub;
	private String azp;
	private String email;
	private String profile;
	private String picture;
	private String name;
	private String aud;
	private String iat;
	private String exp;
	private String hd;

	public String getIss() {
		return iss;
	}

	public void setIss(String iss) {
		this.iss = iss;
	}

	public String getAt_hash() {
		return at_hash;
	}

	public void setAt_hash(String at_hash) {
		this.at_hash = at_hash;
	}

	public String getEmail_verified() {
		return email_verified;
	}

	public void setEmail_verified(String email_verified) {
		this.email_verified = email_verified;
	}

	public String getSub() {
		return sub;
	}

	public void setSub(String sub) {
		this.sub = sub;
	}

	public String getAzp() {
		return azp;
	}

	public void setAzp(String azp) {
		this.azp = azp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAud() {
		return aud;
	}

	public void setAud(String aud) {
		this.aud = aud;
	}

	public String getIat() {
		return iat;
	}

	public void setIat(String iat) {
		this.iat = iat;
	}

	public String getExp() {
		return exp;
	}

	public void setExp(String exp) {
		this.exp = exp;
	}

	public String getHd() {
		return hd;
	}

	public void setHd(String hd) {
		this.hd = hd;
	}

	@Override
	public String toString() {
		return "GoogleIdToken [iss=" + iss + ", at_hash=" + at_hash + ", email_verified=" + email_verified + ", sub="
				+ sub + ", azp=" + azp + ", email=" + email + ", profile=" + profile + ", picture=" + picture
				+ ", name=" + name + ", aud=" + aud + ", iat=" + iat + ", exp=" + exp + ", hd=" + hd + "]";
	}

}
