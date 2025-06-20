package org.example.demo.service;

import org.example.demo.dto.PageRequestDTO;
import org.example.demo.dto.PageResultDTO;
import org.example.demo.entity.User;

import java.util.List;

public interface UserService {
	List<User> findAll();
	User getById(Long id);
	boolean save(User user);
	boolean deleteById(Long id);
	PageResultDTO<User> query(PageRequestDTO pageRequestDTO);
}
