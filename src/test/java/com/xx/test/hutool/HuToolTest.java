package com.xx.test.hutool;

import org.junit.Test;

import cn.hutool.core.util.RuntimeUtil;

public class HuToolTest {
	
	/**
	 * - 运行环境，安装python3，加入化境变量
	 * - maven依赖hutool包
	 */
	@Test
	public void testJava8MethodRef(){
		// 调用系统命令
		String str = RuntimeUtil.execForStr("python F:\\Workspaces\\eclipse202109\\pyGrabShop\\com\\zq\\py\\BrowseShopSzlcsc.py -u " + "https://item.szlcsc.com/139811.html");
//		String str = RuntimeUtil.execForStr("python F:\\Workspaces\\eclipse202109\\pyGrabShop\\com\\zq\\py\\BrowseShopSzlcsc.py -u "
//						+ "https://item.szlcsc.com/1045745.html");
		System.out.println(str);
	}
}
