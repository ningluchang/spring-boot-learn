package org.example.boot304accessright.controller;

import org.example.boot304accessright.common.Permission;
import org.example.boot304accessright.dto.Result;
import org.example.boot304accessright.entity.RoleMenu;
import org.example.boot304accessright.mapper.RoleMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/roleMenu")
public class RoleMenuController {

	@Autowired
	private RoleMenuMapper roleMenuMapper;

	@PostMapping("/bind")
	@Permission("menu:bind")
	public Result<?> bind(@RequestParam Long roleId, @RequestParam Long menuId){
		roleMenuMapper.insert(new RoleMenu(roleId, menuId));
		return Result.success(null);
	}
}
