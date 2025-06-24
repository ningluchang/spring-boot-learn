package org.example.boot304accessright.controller;

import org.example.boot304accessright.common.Permission;
import org.example.boot304accessright.dto.Result;
import org.example.boot304accessright.entity.Menu;
import org.example.boot304accessright.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/menu")
public class MenuController {
	@Autowired
	private MenuService menuService;

	@GetMapping("/tree")
	@Permission("menu:tree")
	public Result<List<Menu>> tree(){
		List<Menu> all = menuService.list();
		List<Menu> tree = buildTree(all, 0L);
		return Result.success(tree);
	}

	private List<Menu> buildTree(List<Menu> all,Long parentId){
		return all.stream()
				.filter(menu -> Objects.equals(menu.getParentId(), parentId))
				.peek(menu -> menu.setChildren(buildTree(all, menu.getId())))
				.collect(Collectors.toList());
	}
}
