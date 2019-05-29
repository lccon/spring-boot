package com.lc.mapper;

import com.lc.domain.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Description:
 *
 * @Date:2019/5/13
 * @Author:lc
 */
@Mapper
@Repository
public interface DepartmentMapper {

    Department getDepartmentById(Long id);

    List<Department> findDepartmentForList();

    void updateDepartmentById(Department department);

    Integer deleteDeparmentById(Long id);
}
