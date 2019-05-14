package com.lc.Service.Impl;

import com.lc.Service.TaskPloyService;
import com.lc.Service.TaskService;
import com.lc.domain.Task;
import com.lc.domain.TaskPloy;
import com.lc.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 *
 * @Date:2019/5/14
 * @Author:lc
 */
@Service("taskService")
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskMapper taskMapper;
    @Autowired
    private TaskPloyService taskPloyService;

    @Override
    public List<Task> findTaskForList() {
        try {
            List<Task> taskList = taskMapper.findTaskForList();
            for(Task task : taskList) {
                TaskPloy taskPloy = taskPloyService.getTaskPloyById(task.getTaskPloy().getId());
                task.setTaskPloy(taskPloy);
            }
            return taskList;
        } catch(Exception e) {
            throw new RuntimeException("查询任务列表出错", e);
        }
    }
    
}
