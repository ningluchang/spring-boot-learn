package org.example.boot304accessright.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.boot304accessright.entity.Menu;

import java.util.List;

public interface MenuMapper extends BaseMapper<Menu> {

	/**
	 * 查询用户所有权限(通过用户id -> role -> menu)
	 * @param userId 用户id
	 * @return 权限列表
	 */
	List<String> finalPermissionCodesByUserId(Long userId);
}
