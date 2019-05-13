package com.lc.controller;

import com.lc.task.job.EmployerJob;
import com.lc.util.SpringUtil;
import org.quartz.*;
import org.quartz.impl.StdScheduler;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Description:
 *
 * @Date:2019/5/11
 * @Author:lc
 */
@Controller
public class EmployerController {

    public static final String NAME = "quartzName15";
    public static final String GROUP = "quartzGroup15";
    public static final String CONFIG = "0/50 * * * * ?";

    @Autowired
    private Scheduler scheduler;

    @RequestMapping("/quartz")
    public void quartz() {
        this.executeQuartz();
    }

    private void executeQuartz() {

        try {
            JobDetail jobDetail = JobBuilder.newJob(EmployerJob.class).withIdentity(NAME, GROUP)
                    .storeDurably(false).build();
            Trigger trigger = TriggerBuilder.newTrigger().forJob(jobDetail).withIdentity(NAME, GROUP)
                    .withSchedule(CronScheduleBuilder.cronSchedule(CONFIG)).build();
            scheduler.scheduleJob(jobDetail, trigger);
            scheduler.start();
        } catch(Exception e) {
            throw new RuntimeException("job调度错误", e);
        }

    }

}
