package org.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.demo.dto.PageRequestDTO;
import org.example.demo.dto.PageResultDTO;
import org.example.demo.entity.User;
import org.example.demo.mapper.UserMapper;
import org.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	@Qualifier("userMapper")
	private UserMapper userMapper;

	@Override
	public PageResultDTO<User> query(PageRequestDTO pageRequestDTO){
		// 构造分页参数
		Page<User> page =new Page<>(pageRequestDTO.getPageNum(), pageRequestDTO.getPageSize());

		// 构造查询条件
		LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
		if (pageRequestDTO.getName() != null && !pageRequestDTO.getName().isEmpty()){
			wrapper.like(User::getName, pageRequestDTO.getName());
		}

		// 执行发言
		Page<User> result = userMapper.selectPage(page, wrapper);
		return new PageResultDTO<>(result.getTotal(), result.getRecords());
	}

	@Override
	public List<User> findAll() {
		return userMapper.selectList(null);
	}

	@Override
	public User getById(Long id){
		return userMapper.selectById(id);
	}

	@Override
	public boolean save(User user){
		return userMapper.insert(user) > 0;
	}

	@Override
	public boolean deleteById(Long id){
		return userMapper.deleteById(id) > 0;
	}
}
