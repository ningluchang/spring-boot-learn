package org.example.boot304accessright.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("menu")
public class Menu {
	@TableId(type = IdType.AUTO)
	private Long id;
	private String name;
	private String permissionCode;
	private String path; // 前端路由
	private Long parentId;
	@TableField(exist = false)
	private List<Menu> children;
}
