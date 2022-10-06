package com.cdio.dermatologroomsystem.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtUtils {

	private static final String SECRET_KEY = "1234!@#";
	private static final int TOKEN_VALIDITY = 3600 * 5;
	public String getUsernameFromToken(String token){
		return getClaimFormToken(token, Claims::getSubject);
	}

	private <T> T getClaimFormToken(String token, Function<Claims, T> claimResolve){
		final Claims claims = getAllClaimFromToken(token);
		return claimResolve.apply(claims);
	}

	private Claims getAllClaimFromToken(String token){
		return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
	}

	public boolean validateToken(String token, UserDetails userDetails){
		String username = getUsernameFromToken(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}

	public boolean isTokenExpired(String token){
		final Date expirationDate = getExpirationDateFromToken(token);
		return expirationDate.before(new Date());
	}

	private Date getExpirationDateFromToken(String token){
		return getClaimFormToken(token, Claims::getExpiration);
	}

	public String generateToken(UserDetails userDetails){
		Map<String, Object> claims = new HashMap<>();
		return Jwts.builder()
				.setClaims(claims)
				.setSubject(userDetails.getUsername())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + TOKEN_VALIDITY * 1000))
				.signWith(SignatureAlgorithm.HS512, SECRET_KEY)
				.compact();
	}
}
