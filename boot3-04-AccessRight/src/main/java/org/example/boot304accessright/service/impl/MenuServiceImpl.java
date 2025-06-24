package org.example.boot304accessright.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.boot304accessright.entity.Menu;
import org.example.boot304accessright.mapper.MenuMapper;
import org.example.boot304accessright.service.MenuService;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
}
