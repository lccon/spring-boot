package com.lc.util;

import com.lc.task.job.EmployerJob;
import org.quartz.*;
import org.quartz.impl.StdScheduler;
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
@Component
public class JobUtil {

    public static final Logger logger = LoggerFactory.getLogger(JobUtil.class);

    private static JobUtil jobUtil = new JobUtil();

    @Autowired
    public static Scheduler scheduler;

    private JobUtil() {
        logger.info("SchedulerMain is created");
    }

    public static JobUtil getInstance() {
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
