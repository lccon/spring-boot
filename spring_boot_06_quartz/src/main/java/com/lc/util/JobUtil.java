package com.lc.util;

import com.lc.task.job.EmployerJob;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

}
