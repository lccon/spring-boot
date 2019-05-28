package com.lc.service;

import com.lc.domain.Department;

import java.util.List;

/**
 * Description:
 *
 * @Date:2019/5/13
 * @Author:lc
 */
public interface DepartmentService {

    Department getDepartmentById(Long id);

    Department updateDepartment(Department department);

    List<Department> findDepartmentForList();

    Boolean deleteDeparmentById(Long id);
}
