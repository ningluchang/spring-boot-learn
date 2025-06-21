package org.example.boot303login.config;

import org.example.boot303login.interceptor.JwtInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Autowired
	private JwtInterceptor jwtInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry  registry){
		registry.addInterceptor(jwtInterceptor)
				.addPathPatterns("/api/**") // 拦截的路径
				.excludePathPatterns("/api/user/**"); // 放行登录注册
	}
}
