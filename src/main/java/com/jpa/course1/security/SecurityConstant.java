package com.jpa.course1.security;

import com.jpa.course1.SpringApplicationContext;

public class SecurityConstant {

	public static final long EXPIRATION_TIME = 864000000;
	public static final String TOKEN_PREFIX = "Bearer";
	public static final String HEADER_STRING = "Authorization";
	public static final String SIGN_UP_URL = "/users";
	
	public static String getTokenSecret() {
		AppProperties appProperties = (AppProperties) SpringApplicationContext.getBean("ApplicationProperties");
		return appProperties.getTokenSecret();
	}
}
