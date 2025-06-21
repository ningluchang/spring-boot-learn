package org.example.boot303login.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {
	private final String SECRET_KEY = "your256bitlongsecretkeyherexxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";

	private final long EXPIRATION = 1000*60*60*24; // 一天

	public String generateToken(Long userId,String username){
		return Jwts.builder()
				.claim("id", userId)
				.claim("username", username)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
				.signWith(SignatureAlgorithm.HS256, SECRET_KEY)
				.compact();
	}

	public Claims parseToken(String token) throws ExpiredJwtException{
		return Jwts.parser()
				.setSigningKey(SECRET_KEY)
				.parseClaimsJws(token)
				.getBody();
	}
}
