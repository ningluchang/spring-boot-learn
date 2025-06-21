package org.example.boot303login.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.boot303login.dto.Result;
import org.example.boot303login.dto.UserLoginDTO;
import org.example.boot303login.dto.UserRegisterDTO;
import org.example.boot303login.entity.User;

public interface UserService extends IService<User> {
	Result<?> register(UserRegisterDTO dto);
	Result<?> login(UserLoginDTO dto);
}
