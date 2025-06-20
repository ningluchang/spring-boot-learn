package org.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResultDTO<T> {
	// 总条数
	private long total;
	// 当前页记录
	private List<T> records;
}
