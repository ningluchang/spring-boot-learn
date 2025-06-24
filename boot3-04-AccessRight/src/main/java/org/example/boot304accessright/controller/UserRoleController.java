package org.example.boot304accessright.controller;

import org.example.boot304accessright.common.Permission;
import org.example.boot304accessright.dto.Result;
import org.example.boot304accessright.entity.UserRole;
import org.example.boot304accessright.mapper.UserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/userRole")
public class UserRoleController {

	@Autowired
	private UserRoleMapper userRoleMapper;

	@PostMapping("/bind")
	@Permission("user:bind")
	public Result<?> bind(@RequestParam Long userId,@RequestParam Long roleId){
		userRoleMapper.insert(new UserRole(userId, roleId));
		return Result.success(null);
	}
}
