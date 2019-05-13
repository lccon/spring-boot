package com.lc.Service.Impl;

import com.lc.Enum.EmployerEnum;
import com.lc.Service.EmployerService;
import com.lc.mapper.EmployerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description:
 *
 * @Date:2019/5/11
 * @Author:lc
 */
@Service("employerService")
public class EmployerServiceImpl implements EmployerService {

    @Autowired
    private EmployerMapper employerMapper;

    @Override
    public void addEmployer() {
        //for (EmployerEnum employer : EmployerEnum.values()) {
            employerMapper.addEmployer("猪小明", 20);
        //}
    }

}
