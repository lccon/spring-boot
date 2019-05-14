package com.lc.util;

import com.lc.domain.Task;
import com.lc.domain.TaskPloy;
import com.lc.task.job.EmployerJob;
import com.lc.task.job.TaskJob;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Description:
 *
 * @Date:2019/5/12
 * @Author:lc
 */

public class JobUtil {

    public static final Logger logger = LoggerFactory.getLogger(JobUtil.class);

    private static JobUtil jobUtil = new JobUtil();

    public static Scheduler scheduler = null;

    private JobUtil() {
        logger.info("SchedulerMain is created");
    }

    public static JobUtil getInstance() {
        if (scheduler == null){
            synchronized (JobUtil.class){
                if (scheduler == null){
                    scheduler = SpringUtil.getBean(Scheduler.class);
                }
            }
        }
        return jobUtil;
    }

    public void addSchedulerJob(String quartzName,
                                String quartzGroup, String cronExpression) throws Exception {

        JobDetail jobDetail = JobBuilder.newJob(EmployerJob.class).withIdentity(quartzName, quartzGroup)
                .storeDurably(false).build();

        Trigger trigger = TriggerBuilder.newTrigger().forJob(jobDetail).withIdentity(quartzName, quartzGroup)
                .withSchedule(CronScheduleBuilder.cronSchedule(cronExpression)).build();

        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();
    }

    public void addSchedulerTask(Task task, TaskPloy taskPloy) throws Exception{

        String name = task.getName();
        String group = task.getTaskGroup();

        // 先停止删除定时任务
        scheduler.unscheduleJob(TriggerKey.triggerKey(name, group));
        scheduler.deleteJob(JobKey.jobKey(name, group));

        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("task", task);
        jobDataMap.put("taskPloy", taskPloy);

        JobDetail jobDetail = JobBuilder.newJob(TaskJob.class).withIdentity(name, group).storeDurably(false)
                .requestRecovery().setJobData(jobDataMap).build();

        Trigger trigger = TriggerBuilder.newTrigger().forJob(jobDetail).withIdentity(name, group)
                .withSchedule(CronScheduleBuilder.cronSchedule(task.getConfig())).build();

        // 再开启定时任务
        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();
    }

    public void taskStop(Task task) throws SchedulerException {
        String name = task.getName();
        String group = task.getTaskGroup();
        scheduler.unscheduleJob(TriggerKey.triggerKey(name, group));
    }

}
