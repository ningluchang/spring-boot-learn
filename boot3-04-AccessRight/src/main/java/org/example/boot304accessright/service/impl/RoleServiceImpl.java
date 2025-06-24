package org.example.boot304accessright.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.boot304accessright.entity.Role;
import org.example.boot304accessright.mapper.RoleMapper;
import org.example.boot304accessright.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
}
