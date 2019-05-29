package com.lc.controller;

import com.lc.domain.Department;
import com.lc.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Description:
 *
 * @Date:2019/5/13
 * @Author:lc
 */
@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/getDepartmentById")
    @ResponseBody
    public Department getDepartmentById(Long id){
        Department department = departmentService.getDepartmentById(id);
        return department;
    }

    @RequestMapping("/findDepartmentForList")
    @ResponseBody
    public List<Department> findDepartmentForList(){
        return departmentService.findDepartmentForList();
    }

    @RequestMapping("/updateDepartment")
    @ResponseBody
    public Department updateDepartment(Department department){
        Department depart = departmentService.updateDepartment(department);
        return depart;
    }

    @RequestMapping("/deleteDepartmentById")
    @ResponseBody
    public Boolean deleteDepartmentById(Long id){
        return departmentService.deleteDeparmentById(id);
    }
}
