package com.xx.test.hutool;

import org.junit.Test;

import cn.hutool.core.util.RuntimeUtil;

public class HuToolTest {
	
	@Test
	public void testJava8MethodRef(){
		// 调用系统命令
		String str = RuntimeUtil.execForStr("python F:\\Workspaces\\eclipse202109\\pyGrabShop\\com\\zq\\py\\BrowseShopSzlcsc.py");
		System.out.println(str);
	}
}
