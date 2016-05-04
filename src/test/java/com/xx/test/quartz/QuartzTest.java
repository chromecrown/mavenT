package com.xx.test.quartz;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;

import com.xx.test.mt.common.test.TestBase;
import com.xx.test.mt.job.HelloJob;
import com.xx.test.mt.scheduler.ScheduleTest;

public class QuartzTest extends TestBase {

	protected Log logger = LogFactory.getLog(QuartzTest.class);

	/**
	 * test quartz
	 * 
	 * @throws InterruptedException
	 * 
	 */
	@Test
	public void test() throws InterruptedException {
		try {
			SchedulerFactory schedFact = new org.quartz.impl.StdSchedulerFactory();
			Scheduler sched = schedFact.getScheduler();
			// 开始调度器
			sched.start();
			// 创建job任务
			JobDetail job = newJob(HelloJob.class).withIdentity("myJob", Scheduler.DEFAULT_GROUP).build();
			// 创建trigger，触发器
			Trigger trigger = newTrigger().withIdentity("myTrigger", Scheduler.DEFAULT_GROUP).startNow()
					.withSchedule(simpleSchedule().withIntervalInSeconds(3).repeatForever()).build();
			// 将任务和触发器绑定到调度器
			sched.scheduleJob(job, trigger);
			System.out.println("执行了");
			Thread.sleep(1000000);// 这个一定要加上，不然不会有任何输出，原因在最后有解释
			sched.shutdown(); // 关闭调度器
		} catch (SchedulerException se) {
			se.printStackTrace();
		}
	}
	
	@Test
	public void testStartSchedule(){
		ScheduleTest schedule = new ScheduleTest();
		schedule.startSchedule();
	}
}