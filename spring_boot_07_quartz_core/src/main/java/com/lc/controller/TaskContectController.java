package com.lc.controller;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.lc.Service.TaskPloyService;
import com.lc.Service.TaskService;
import com.lc.domain.Task;
import com.lc.util.JobUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Description:
 *
 * @Date:2019/5/13
 * @Author:lc
 */
@Controller
public class TaskContectController {

    @Autowired
    private TaskService taskService;
    @Autowired
    private TaskPloyService taskPloyService;

    @RequestMapping("/taskContect")
    public void taskContect() {
        List<Task> taskList = taskService.findTaskForList();
        for(Task task : taskList) {
            handleTask(task);
        }
    }

    private void handleTask(Task task){
        try {
            if("1".equals(task.getClosed())) {
                JobUtil.getInstance().addSchedulerTask(task,
                        taskPloyService.getTaskPloyById(task.getTaskPloy().getId()));
            } else {
                JobUtil.getInstance().taskStop(task);
            }
        } catch(Exception e) {
            throw new RuntimeException("调用定时任务出错", e);
        }
    }

}
