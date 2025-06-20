package org.example.demo.controller;

import org.example.demo.dto.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

	@GetMapping( "hi")
	public Result<String> hello(@RequestParam String name){
		return Result.success("hello" + name);
	}
}
