package com.lc.controller;

import com.lc.task.job.EmployerJob;
import com.lc.util.JobUtil;
import org.quartz.*;
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

    public static final String NAME = "quartzName22";
    public static final String GROUP = "quartzGroup22";
    public static final String CONFIG = "0/30 * * * * ?";

    @RequestMapping("/quartz")
    public void quartz() {
        this.executeQuartz();
    }

    private void executeQuartz() {

        try {
            JobUtil.getInstance().addSchedulerJob(NAME, GROUP, CONFIG);
        } catch(Exception e) {
            throw new RuntimeException("job调度错误", e);
        }

    }

}
