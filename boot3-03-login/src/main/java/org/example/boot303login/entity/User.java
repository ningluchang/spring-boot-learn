package org.example.boot303login.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("user_two")
public class User {
	@TableId(type = IdType.AUTO)
	private Long id;

	private String username;

	private String password;

	private String nickname;

	private Integer status;

	private LocalDateTime createTime;

	private LocalDateTime updateTime;

	private String avatar;// 头像访问地址
}
