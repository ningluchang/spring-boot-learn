package org.example.boot303login.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.example.boot303login.dto.Result;
import org.example.boot303login.dto.UserLoginDTO;
import org.example.boot303login.dto.UserRegisterDTO;
import org.example.boot303login.service.UserService;
import org.example.boot303login.service.impl.UserServiceImpl;
import org.example.boot303login.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PostExchange;

@RestController
@RequestMapping("/user")
@Tag(name = "用户接口")
public class UserController {

	@Autowired
	private UserServiceImpl userService;

	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping("/register")
	public Result<?> register(@RequestBody @Valid UserRegisterDTO dto){
		return userService.register(dto);
	}

	@PostMapping("/login")
	public Result<?> login(@RequestBody @Valid UserLoginDTO dto){
		return userService.login(dto);
	}
}
