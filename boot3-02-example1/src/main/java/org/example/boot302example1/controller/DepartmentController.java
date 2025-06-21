package org.example.boot302example1.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.boot302example1.dto.Result;
import org.example.boot302example1.entity.Department;
import org.example.boot302example1.serivce.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department")
@Tag(name = "DepartmentController", description = "部门管理")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@Operation(summary = "创建部门")
	@PostMapping
	public Result<?> create(@RequestBody Department dept){
		departmentService.save(dept);
		return Result.success(null);
	}

	@Operation(summary = "查询所有部门")
	@GetMapping("/list")
	public Result<List<Department>> list(){
		return Result.success(departmentService.list());
	}


	@Operation(summary = "分页查询")
	@GetMapping("/page")
	public Result<Page<Department>> page(@RequestParam int pageNum,
	                                     @RequestParam int pageSize,
	                                     @RequestParam(required = false) String name){
		LambdaQueryWrapper<Department> wrapper = new LambdaQueryWrapper<>();
		if (name != null && !name.isEmpty()){
			wrapper.like(Department::getName, name);
		}

		Page<Department> page = new Page<>(pageNum, pageSize);
		Page<Department> result = departmentService.page(page, wrapper);
		return Result.success(result);
	}

	@Operation(summary = "删除部门")
	@GetMapping("/delete/{id}")
	public Result<?> delete(@PathVariable Long id){
		departmentService.removeById(id);
		return Result.success(null);
	}


	@Operation(summary = "更新部门")
	@PutMapping
	public Result<?> update(@RequestBody Department dept){
		departmentService.updateById(dept);
		return Result.success(null);
	}


	@Operation(summary = "查询部门详情")
	@GetMapping("/{id}")
	public Result<Department> detail(@PathVariable Long id){
		Department dept = departmentService.getById(id);
		return Result.success(dept);
	}
}
