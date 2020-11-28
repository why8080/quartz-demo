package com.global.demo.quartz;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class QuartzDemo implements Job {
/*
 * Job 类
 * @see org.quartz.Job#execute(org.quartz.JobExecutionContext)
 */
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("Exect: " + new Date());
	}

}
