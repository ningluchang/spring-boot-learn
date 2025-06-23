package org.example.boot303login.config;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.boot303login.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class JwtInterceptor implements HandlerInterceptor {

	@Autowired
	private JwtUtil jwtUtil;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String authHeader = request.getHeader("Authorization");
		if (authHeader == null || authHeader.isEmpty()){
			throw new RuntimeException("无token，请登录");
		}
		String token = authHeader.substring(7);
		try{
			Claims claims = jwtUtil.parseToken(token);
			Long userId = Long.valueOf(claims.get("id").toString());
			request.setAttribute("userId", userId);
			return true;
		}catch (Exception e){
			throw new RuntimeException("无效token");
		}

	}
}
