package com.lc.scheduler;

import com.lc.Service.TaskContectService;
import javafx.concurrent.Task;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @Date:2019/5/13
 * @Author:lc
 */
@Component("taskContectScheduler")
public class TaskContectScheduler {

    @Autowired
    private TaskContectService taskContectService;

    public void addTaskContect() {
        taskContectService.addTaskContect("quartzName", "quartzGroup");
    }

}
