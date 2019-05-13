package com.lc.task.job;


import com.lc.Service.EmployerService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Description:
 *
 * @Date:2019/5/11
 * @Author:lc
 */
public class EmployerJob implements Job {

    @Autowired
    private EmployerService employerService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        employerService.addEmployer();
    }

}
