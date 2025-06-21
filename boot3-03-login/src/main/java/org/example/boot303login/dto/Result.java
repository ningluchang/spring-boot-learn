package org.example.boot303login.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.boot303login.enums.ResultCode;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {

	private Integer code;
	private String message;
	private T data;

	public static <T> Result<T> success(T data){
		return new Result<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
	}

	public static Result<?> error(ResultCode codeEnum){
		return new Result<>(codeEnum.getCode(), codeEnum.getMessage(), null);
	}

	public static Result<?> error(String message){
		return new Result<>(ResultCode.BAD_REQUEST.getCode(), message, null);
	}
}
