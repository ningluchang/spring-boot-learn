package org.example.boot303login.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.example.boot303login.dto.Result;
import org.example.boot303login.dto.UserLoginDTO;
import org.example.boot303login.dto.UserRegisterDTO;
import org.example.boot303login.entity.User;
import org.example.boot303login.service.UserService;
import org.example.boot303login.service.impl.UserServiceImpl;
import org.example.boot303login.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.service.annotation.PostExchange;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/user")
@Tag(name = "用户接口")
public class UserController {

	@Autowired
	private UserServiceImpl userService;

	@PostMapping("/register")
	public Result<?> register(@RequestBody @Valid UserRegisterDTO dto){
		return userService.register(dto);
	}

	@PostMapping("/login")
	public Result<?> login(@RequestBody @Valid UserLoginDTO dto){
		return userService.login(dto);
	}
}
