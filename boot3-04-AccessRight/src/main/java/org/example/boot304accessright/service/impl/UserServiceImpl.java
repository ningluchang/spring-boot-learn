package org.example.boot304accessright.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.boot304accessright.dto.LoginDTO;
import org.example.boot304accessright.dto.Result;
import org.example.boot304accessright.dto.UserRegisterDTO;
import org.example.boot304accessright.entity.User;
import org.example.boot304accessright.mapper.UserMapper;
import org.example.boot304accessright.service.UserService;
import org.example.boot304accessright.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public Result<?> register(UserRegisterDTO dto){
		if (lambdaQuery().eq(User::getUsername, dto.getUsername()).one() != null){
			return Result.error("用户名已存在");
		}
		User user = new User();
		user.setUsername(dto.getUsername());
		user.setPassword(dto.getPassword());
		user.setNickname(dto.getNickname());
		save(user);
		return Result.success(null);
	}

	@Override
	public String login(LoginDTO dto) {
		LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(User::getUsername, dto.getUsername())
				.eq(User::getPassword, dto.getPassword());
		User user = userMapper.selectOne(wrapper);
		if (user == null) {
			throw new RuntimeException("账号或密码错误");
		}
		return JwtUtils.createToken(user.getId(), user.getUsername());
	}
}
