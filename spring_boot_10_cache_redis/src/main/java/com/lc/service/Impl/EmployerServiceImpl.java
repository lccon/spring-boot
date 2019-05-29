package com.lc.service.Impl;

import com.lc.domain.Department;
import com.lc.domain.Emp;
import com.lc.mapper.EmployerMapper;
import com.lc.service.DepartmentService;
import com.lc.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 *
 * @Date:2019/5/13
 * @Author:lc
 */
@Service("employerService")
public class EmployerServiceImpl implements EmployerService {

    @Autowired
    private EmployerMapper employerMapper;

    @Autowired
    private DepartmentService departmentService;

    @Override
    public List<Emp> findEmployerForList() {
        try {
            List<Emp> empList = employerMapper.findEmployerForList();
            for(Emp emp : empList) {
                Department department = departmentService.getDepartmentById(emp.getDepartment().getId());
                emp.setDepartment(department);
            }
            return empList;
        } catch(Exception e) {
            throw new RuntimeException("获取员工列表出错", e);
        }
    }

    @Override
    public Emp addEmp(Emp emp) {
        if(emp == null) {
            throw new RuntimeException("参数有误");
        }
        try {
            employerMapper.addEmp(emp);
            return emp;
        } catch (Exception e) {
            throw new RuntimeException("添加员工信息出错", e);
        }
    }
}
