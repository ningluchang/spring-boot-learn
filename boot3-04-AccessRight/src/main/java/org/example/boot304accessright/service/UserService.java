package org.example.boot304accessright.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.boot304accessright.dto.LoginDTO;
import org.example.boot304accessright.dto.Result;
import org.example.boot304accessright.dto.UserRegisterDTO;
import org.example.boot304accessright.entity.User;

public interface UserService extends IService<User> {
	String login(LoginDTO dto);
	Result<?> register(UserRegisterDTO dto);
}
