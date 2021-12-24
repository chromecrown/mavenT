package com.xx.test.drools;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.chenj.entity.Order;

public class TestDrools {
	@Test
	public void testDrools_1() {
		KieServices kieServices = new KieServices.Factory().get();
		KieContainer kieContainer = kieServices.getKieClasspathContainer();
		// 会话对象，用于和规则引擎交互
		KieSession kieSession = kieContainer.newKieSession();
		// 构建订单对象，设置订单金额，由规则引擎计算获得的积分
		Order order = new Order();
		order.setAmout(600);
		
		// 将数据交给规则引擎，规则引擎会根据提供的数据进行规则匹配
		kieSession.insert(order);
		
		// 激活规则引擎，古国匹配成功则执行规则
		kieSession.fireAllRules();
		
		// 关闭会话
		kieSession.dispose();
		// 打印结果
		System.out.println("订单提交之后积分：" + order.getScore());
	}
}
