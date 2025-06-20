package org.example.demo.controller;


import jakarta.validation.Valid;
import org.example.demo.dto.PageRequestDTO;
import org.example.demo.dto.PageResultDTO;
import org.example.demo.dto.Result;
import org.example.demo.entity.User;
import org.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public Result<List<User>> list(){
		return Result.success(userService.findAll());
	}

	/**
	 * @PathVariable Long id 路径参数
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public Result<User> get(@PathVariable Long id){
		return Result.success(userService.getById(id));
	}

	@PostMapping
	public Result<?> create(@Valid @RequestBody User user){
		return userService.save(user)
				? Result.success(null)
				: Result.error("新增识别");
	}

	@PostMapping("/{id}")
	public Result<?> delete(@PathVariable Long id){
		return userService.deleteById(id)
				? Result.success(null)
				: Result.error("删除失败");
	}

	@PostMapping("/page")
	public Result<PageResultDTO<User>> getPage(@RequestBody PageRequestDTO pageRequestDTO){
		return Result.success(userService.query(pageRequestDTO));
	}
}
