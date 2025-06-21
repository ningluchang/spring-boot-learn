package org.example.boot303login.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.boot303login.dto.Result;
import org.example.boot303login.dto.UserLoginDTO;
import org.example.boot303login.dto.UserRegisterDTO;
import org.example.boot303login.entity.User;
import org.example.boot303login.mapper.UserMapper;
import org.example.boot303login.service.UserService;
import org.example.boot303login.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

	@Autowired
	private JwtUtil jwtUtil;

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
	public Result<?> login(UserLoginDTO dto){
		User user = lambdaQuery()
				.eq(User::getUsername, dto.getUsername())
				.eq(User::getPassword, dto.getPassword())
				.one();
		if (user == null){
			return Result.error("用户名或密码错误");
		}
		String token = jwtUtil.generateToken(user.getId(), user.getUsername());
		return Result.success(token);
	}
}
