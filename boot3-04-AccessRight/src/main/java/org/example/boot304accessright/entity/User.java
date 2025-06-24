package org.example.boot304accessright.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("user3")
public class User {
	@TableId(type = IdType.AUTO)
	private Long id;

	private String username;
	private String password;
	private String nickname;
	private String avatar;
	private Integer status;
	private LocalDateTime createTime;
	private LocalDateTime updateTime;
}
