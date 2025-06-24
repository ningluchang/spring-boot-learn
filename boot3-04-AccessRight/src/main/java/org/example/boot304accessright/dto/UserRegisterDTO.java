package org.example.boot304accessright.dto;

import lombok.Data;

@Data
public class UserRegisterDTO {
	private String username;
	private String password;
	private String nickname;
	private Integer status;
}
