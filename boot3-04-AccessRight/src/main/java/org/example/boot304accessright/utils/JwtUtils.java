package org.example.boot304accessright.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtils {
	private static final String SECRET_KEY = "your256bitlongsecretkeyherexxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
	private static final long EXPIRATION_TIME = 1000*60*60*24*7;// 7天

	public static String createToken(Long userId,String username){
		return Jwts.builder()
				.claim("id", userId)
				.claim("username", username)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS256, SECRET_KEY)
				.compact();
	}

	public static Claims parseToken(String token){
		return Jwts.parser()
				.setSigningKey(SECRET_KEY)
				.parseClaimsJws(token)
				.getBody();
	}
}
