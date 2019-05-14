package com.lc.Service.Impl;

import com.lc.Service.TaskContectService;
import com.lc.mapper.TaskContectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description:
 *
 * @Date:2019/5/13
 * @Author:lc
 */
@Service("taskContectService")
public class TaskContectServiceImpl implements TaskContectService {

    @Autowired
    private TaskContectMapper taskContectMapper;

    @Override
    public void addTaskContect(String name, String group) {
        taskContectMapper.addTaskContect(name, group);
    }
}
