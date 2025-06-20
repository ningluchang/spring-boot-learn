package org.example.demo.dto;

import lombok.Data;

@Data
public class PageRequestDTO {
	private Integer pageNum;
	private Integer pageSize;
	// 可选的模糊查询字段
	private String name;
}
