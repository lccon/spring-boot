package com.lc.task.job;

import com.lc.domain.Task;
import com.lc.domain.TaskPloy;
import com.lc.util.SpringUtil;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * Description:
 *
 * @Date:2019/5/14
 * @Author:lc
 */
public class TaskJob implements Job {

    private static Logger logger;
    static {
        logger = LoggerFactory.getLogger(TaskJob.class);
    }

    @Override
    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        Object taskPloyObj = arg0.getJobDetail().getJobDataMap().get("taskPloy");
        Task task = (Task)arg0.getJobDetail().getJobDataMap().get("task");
        TaskPloy taskPloy = null;
        if (taskPloyObj != null && taskPloyObj instanceof TaskPloy) {
            taskPloy = (TaskPloy) taskPloyObj;
            executePloy(task, taskPloy);
        } else {
            logger.error("策略为空");
        }
    }

    private void executePloy(Task task, TaskPloy taskPloy) {
        try {
            String type = taskPloy.getPropertyDict().getDisplayName();
            String code = taskPloy.getCode();
            if("java方法".equals(type)) {
                String domain = code.substring(0, code.lastIndexOf("."));
                String method = code.substring(code.lastIndexOf(".") + 1);
                Object clazz = SpringUtil.getBean(domain);
                Method m = clazz.getClass().getMethod(method);
                m.invoke(clazz);
            }
        } catch (Exception e) {
            logger.error("job执行错误", e);
        }
    }
}
