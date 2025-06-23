package org.example.boot303login.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.example.boot303login.dto.Result;
import org.example.boot303login.entity.User;
import org.example.boot303login.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/file")
public class FileController {
	@Autowired
	private UserServiceImpl userService;

	@PostMapping("/upload")
	public Result<?> uploadAvatar(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
		Long userId = (Long) request.getAttribute("userId");
		return userService.uploadAvatar(userId,file);
	}

	@GetMapping("/info")
	public Result<User> getInfo(HttpServletRequest  request){
		Long userId = (Long) request.getAttribute("userId");
		User user = userService.getById(userId);
		return Result.success(user);
	}
}
