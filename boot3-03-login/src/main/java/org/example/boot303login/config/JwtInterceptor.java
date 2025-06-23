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
		String token = request.getHeader("Authorization");
		if (token == null || token.isEmpty()){
			throw new RuntimeException("无token，请登录");
		}
		try{
			Claims claims = jwtUtil.parseToken(token);
			request.setAttribute("claims", claims.get("id"));
			return true;
		}catch (Exception e){
			throw new RuntimeException("无效token");
		}

	}
}
