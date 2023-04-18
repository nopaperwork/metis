package com.metis.nopaper.work.security.jwt;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class JWTService {

	private static final Logger LOGGER = LoggerFactory.getLogger(JWTService.class);
	
	@Value("${spring.jwt.secret}")
	private String JWT_SECRET;

	@Value("${spring.jwt.jwtExpirationInMs}")
	private int JWT_EXPIRATION_TIME_IN_MILLISECONDS;
	
	public String generateToken(String userName) {
		Map<String, Object> claims = new HashMap<>();
		return tokenCreator(claims, userName);
	}

	public String tokenCreator(Map<String, Object> claims, String userName) {
		return Jwts
				.builder()
				.setClaims(claims)
				.setSubject(userName)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_EXPIRATION_TIME_IN_MILLISECONDS))
				.signWith(getSignedKey(), 
						SignatureAlgorithm.HS256).compact();
	}

	public String extractUsernameFromToken(String theToken) {
		return extractClaim(theToken, Claims::getSubject);
	}

	public Date extractExpirationTimeFromToken(String theToken) {
		return extractClaim(theToken, Claims::getExpiration);
	}

	public Boolean validateToken(String theToken, UserDetails userDetails) {

		try {
			final String userName = extractUsernameFromToken(theToken);
			return (userName.equals(userDetails.getUsername()) && !isTokenExpired(theToken));
		} catch (SignatureException e) {
			LOGGER.error("Invalid JWT signature: {}", e.getMessage());
		} catch (MalformedJwtException e) {
			LOGGER.error("Invalid JWT token: {}", e.getMessage());
		} catch (ExpiredJwtException e) {
			LOGGER.error("JWT token is expired: {}", e.getMessage());
		} catch (UnsupportedJwtException e) {
			LOGGER.error("JWT token is unsupported: {}", e.getMessage());
		} catch (IllegalArgumentException e) {
			LOGGER.error("JWT claims string is empty: {}", e.getMessage());
		}
		return false;
	}

	private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}

	private Claims extractAllClaims(String token) {
		return Jwts.parserBuilder().setSigningKey(getSignedKey()).build().parseClaimsJws(token).getBody();

	}

	private boolean isTokenExpired(String theToken) {
		return extractExpirationTimeFromToken(theToken).before(new Date());
	}

	private Key getSignedKey() {
		byte[] keyByte = Decoders.BASE64.decode(JWT_SECRET);
		return Keys.hmacShaKeyFor(keyByte);
	}
	
}