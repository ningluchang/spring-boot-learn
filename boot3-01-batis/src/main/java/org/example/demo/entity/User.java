package org.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// @Builder：支持链式构造 User.builder().name("Tom").age(20).build()

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("student")
public class User {
	@TableId(type = IdType.AUTO)
	private Long id;

	@NotBlank(message = "姓名不能为空")
	private String name;

	@NotBlank(message = "年龄不能为空")
	@Min(value = 0, message = "年龄不能小于0")
	private Integer age;

	@NotBlank(message = "专业不能为空")
	private String major;
}
