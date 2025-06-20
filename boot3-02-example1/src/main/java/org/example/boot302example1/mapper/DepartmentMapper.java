package org.example.boot302example1.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.boot302example1.entity.Department;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentMapper extends BaseMapper<Department> {
}
