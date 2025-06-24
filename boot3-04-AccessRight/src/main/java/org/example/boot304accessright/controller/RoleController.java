package org.example.boot304accessright.controller;

import org.example.boot304accessright.common.Permission;
import org.example.boot304accessright.dto.Result;
import org.example.boot304accessright.entity.Role;
import org.example.boot304accessright.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/role")
public class RoleController {

	@Autowired
	private RoleService roleService;

	@GetMapping("/list")
	@Permission("role:list")
	public Result<List<Role>> list(){
		return Result.success(roleService.list());
	}

	@PostMapping("/add")
	@Permission("role:add")
	public Result<?> add(@RequestBody Role role){
		roleService.save(role);
		return Result.success(null);
	}
}
