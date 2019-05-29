package com.lc.service;

import com.lc.domain.Emp;

import java.util.List;

/**
 * Description:
 *
 * @Date:2019/5/13
 * @Author:lc
 */
public interface EmployerService {

    List<Emp> findEmployerForList();

    Emp addEmp(Emp emp);
}
