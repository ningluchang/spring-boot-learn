package org.example.boot302example1.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("department")
public class Department {
	@TableId(type = IdType.AUTO)
	private Long id;

	@NotBlank(message = "姓名不能为空")
	private String name;

	private Integer status; // 1启用 0禁用

	private LocalDateTime createTime;

	private LocalDateTime updateTime;
}
