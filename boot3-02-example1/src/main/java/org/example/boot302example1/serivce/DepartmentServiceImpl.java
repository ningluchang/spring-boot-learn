package org.example.boot302example1.serivce;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.boot302example1.entity.Department;
import org.example.boot302example1.mapper.DepartmentMapper;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentService {
}
