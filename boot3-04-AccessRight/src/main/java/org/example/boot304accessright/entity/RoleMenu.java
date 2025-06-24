package org.example.boot304accessright.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("role_menu")
public class RoleMenu {
	private Long roleId;
	private Long menuId;
}
