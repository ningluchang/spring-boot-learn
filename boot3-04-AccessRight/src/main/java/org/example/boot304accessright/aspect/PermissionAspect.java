package org.example.boot304accessright.aspect;

import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.example.boot304accessright.common.Permission;
import org.example.boot304accessright.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.List;

@Aspect
@Component
public class PermissionAspect {
	@Autowired
	private MenuMapper menuMapper;

	@Around("@annotation(permission)")
	public Object checkPermission(ProceedingJoinPoint joinPoint, Permission permission)throws Throwable{
		// 获取当前请求
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		// 从request 中获取userId
		Long userId = (Long) request.getAttribute("userId");
		if (userId == null){
			throw new RuntimeException("用户未登录");
		}
		// 获取用户权限
		List<String> codes = menuMapper.finalPermissionCodesByUserId(userId);

		// 判断是否包含该权限
		if (!codes.contains(permission.value())){
			throw new RuntimeException("无权限: "+permission.value());
		}
		// 放行
		return joinPoint.proceed();
	}
}
