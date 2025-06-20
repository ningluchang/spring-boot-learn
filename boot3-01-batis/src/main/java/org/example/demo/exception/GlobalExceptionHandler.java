package org.example.demo.exception;

import org.example.demo.dto.Result;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	// 通用异常
	@ExceptionHandler(Exception.class)
	public Result<?> handle(Exception e){
		return Result.error("系统异常: "+e.getMessage());
	}

	// 参数校验异常处理
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Result<?> handleValid(MethodArgumentNotValidException e){
		// 提取第一个字段错误提示
		String msg = e.getBindingResult().getFieldError().getDefaultMessage();
		return Result.error("参数错误: "+msg);
	}
}
