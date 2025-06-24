package org.example.boot304accessright.controller;

import org.example.boot304accessright.dto.LoginDTO;
import org.example.boot304accessright.dto.Result;
import org.example.boot304accessright.dto.UserRegisterDTO;
import org.example.boot304accessright.entity.Menu;
import org.example.boot304accessright.entity.User;
import org.example.boot304accessright.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/user/login")
	public Result<String> login(@RequestBody LoginDTO dto){
		String token = userService.login(dto);
		return Result.success(token);
	}

	@PostMapping("/user/register")
	public Result<?> register(@RequestBody UserRegisterDTO dto){
		return userService.register(dto);
	}

	public Result<?> add(@RequestBody User menu){
		userService.save(menu);
		return Result.success(null);
	}
}
