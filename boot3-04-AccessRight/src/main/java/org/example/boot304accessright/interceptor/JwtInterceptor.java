package org.example.boot304accessright.interceptor;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.boot304accessright.utils.JwtUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class JwtInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
		String authHeader = request.getHeader("Authorization");
		if(authHeader == null || !authHeader.startsWith("Bearer ")){
			throw new RuntimeException("无token，请登录");
		}
		try{
			Claims claims = JwtUtils.parseToken(authHeader.replace("Bearer ", ""));
			Long userId = claims.get("id", Long.class);
			String username = claims.get("username", String.class);

			request.setAttribute("userId",userId);
			request.setAttribute("username",username);

		}catch (Exception e){
			throw new RuntimeException("无效token");
		}
		return true;
	}
}
