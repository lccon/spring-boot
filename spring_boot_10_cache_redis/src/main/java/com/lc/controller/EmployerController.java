package com.lc.controller;

import com.lc.domain.Department;
import com.lc.domain.Emp;
import com.lc.service.DepartmentService;
import com.lc.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Description:
 *
 * @Date:2019/5/13
 * @Author:lc
 */
@Controller
public class EmployerController {

    @Autowired
    private EmployerService employerService;
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "/emp", method = RequestMethod.GET)
    @ResponseBody
    public List<Emp> findEmpForList() {
        List<Emp> employerList = employerService.findEmployerForList();
        return employerList;
    }

    @PostMapping("/emp")
    @ResponseBody
    public Emp addEmp(Emp emp) {
        Emp empData = employerService.addEmp(emp);
        return empData;
    }

}
