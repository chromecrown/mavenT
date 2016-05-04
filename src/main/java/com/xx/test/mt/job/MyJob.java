package com.xx.test.mt.job;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MyJob implements Job {
	private static final Log logger = LogFactory.getLog(MyJob.class);

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("Hello quzrtz  " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ").format(new Date()));

	}
}
