package com.metis.nopaper.work.security.utilities;

import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import com.google.common.hash.Hashing;

import jakarta.servlet.http.HttpServletRequest;

public class SecureUtility {

	private static final String[] HEADERS_TO_TRY = { 
			"X-Forwarded-For", 
			"Proxy-Client-IP", 
			"WL-Proxy-Client-IP",
			"HTTP_X_FORWARDED_FOR", 
			"HTTP_X_FORWARDED", 
			"HTTP_X_CLUSTER_CLIENT_IP", 
			"HTTP_CLIENT_IP",
			"HTTP_FORWARDED_FOR", 
			"HTTP_FORWARDED", 
			"HTTP_VIA", 
			"REMOTE_ADDR" };

	public static String generateUserCode(String email) {

		Instant instant = Instant.now();
		long timeStampMillis = instant.toEpochMilli();
		String characterSequence = timeStampMillis + email;

		return Hashing.murmur3_32_fixed().hashString(characterSequence, StandardCharsets.UTF_8).toString();

	}

	public static String getClientIpAddress(HttpServletRequest request) {

		for (String header : HEADERS_TO_TRY) {
			String ip = request.getHeader(header);
			if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)) {
				return ip;
			}
		}

		return request.getRemoteAddr();
	}

	public static Map<String, String> getHeaderValue(HttpServletRequest request) {

		Map<String, String> headerValue = new HashMap<>();

		Enumeration<?> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String key = (String) headerNames.nextElement();
			String value = request.getHeader(key);
			headerValue.put(key, value);
		}
		return headerValue;
	}

}
