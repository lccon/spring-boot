package com.lc.service.Impl;

import com.lc.domain.Department;
import com.lc.mapper.DepartmentMapper;
import com.lc.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 *
 * @Date:2019/5/13
 * @Author:lc
 */
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    /*@Cacheable(cacheNames = "emp", key = "#root.methodName+'['+#id+']'",
            condition = "#id > 1 and #root.getMethodName() eq 'getDepartmentById'",
            unless = "#id == 2")*/
    @Cacheable(cacheNames = "emp", key = "#id")
    @Override
    public Department getDepartmentById(Long id) {
        if(id == null) {
            throw new RuntimeException("参数错误");
        }
        try {
            System.out.println(id+"号部门");
            return departmentMapper.getDepartmentById(id);
        } catch (Exception e) {
            throw new RuntimeException("查询部门出错", e);
        }
    }

    @CachePut(value = "emp", key = "#result.id")
    @Override
    public Department updateDepartment(Department department) {
        if(department == null) {
            throw new RuntimeException("参数错误");
        }
        try {
            departmentMapper.updateDepartmentById(department);
            return department;
        } catch (Exception e) {
            throw new RuntimeException("修改部门出错", e);
        }
    }

    @Override
    public List<Department> findDepartmentForList() {
        try {
            return departmentMapper.findDepartmentForList();
        } catch (Exception e) {
            throw new RuntimeException("查询所有的部门出错", e);
        }
    }

    @CacheEvict(value = "emp", /*key = "#id"*/ allEntries = true)
    @Override
    public Boolean deleteDeparmentById(Long id) {
        if(id == null) {
            throw new RuntimeException("参数错误");
        }
        try {
            Integer count = departmentMapper.deleteDeparmentById(id);
            return count > 0;
        } catch (Exception e) {
            throw new RuntimeException("删除部门出错", e);
        }
    }
}
