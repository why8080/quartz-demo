package com.global.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import com.global.demo.quartz.QuartzDemo;

//@Configuration
public class QuartzConfig {
	
	/*
	 * 1.创建job对象
	 */
	@Bean
	public JobDetailFactoryBean jobDetailFactoryBean(){
		JobDetailFactoryBean factory = new JobDetailFactoryBean();
		//关联job类
		factory.setJobClass(QuartzDemo.class);
		return factory;
	}
	
//	/*
//	 * 2.创建Trigger对象
//	 */
//	@Bean
//	public SimpleTriggerFactoryBean simpleTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean){
//		SimpleTriggerFactoryBean factory = new SimpleTriggerFactoryBean();
//		// 关联job Detail对象
//		factory.setJobDetail(jobDetailFactoryBean.getObject());
//		// 该参数表示一个执行的毫秒数
//		factory.setRepeatInterval(2000);
//		// 重复次数
//		factory.setRepeatCount(5);
//		return factory;
//	}
	@Bean
	public CronTriggerFactoryBean cronTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean){
		CronTriggerFactoryBean factory = new CronTriggerFactoryBean();
		// 关联job Detail对象
		factory.setJobDetail(jobDetailFactoryBean.getObject());
		factory.setCronExpression("0/2 * * * * ?");
		return factory;
	}
	
	/*
	 * 3.创建Scheduler对象
	 */
	@Bean
	public SchedulerFactoryBean schedulerFactoryBean(CronTriggerFactoryBean cronTriggerFactoryBean){
		SchedulerFactoryBean factory = new  SchedulerFactoryBean();
		//关联trigger对象
		factory.setTriggers(cronTriggerFactoryBean.getObject());
		return factory;
	}
}
