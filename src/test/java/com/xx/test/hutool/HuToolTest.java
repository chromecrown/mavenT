package com.xx.test.hutool;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import cn.hutool.core.util.RuntimeUtil;

public class HuToolTest {
	
	/**
	 * - 获取【立创商城】指定页面的价格信息
	 * - 运行环境，安装python3，加入化境变量
	 * - maven依赖hutool包
	 */
	@Test
	public void testJavaCallPyGetPriceOfSzlcsc(){
		// 调用系统命令
		String str = RuntimeUtil.execForStr("python F:\\Workspaces\\eclipse202109\\pyGrabShop\\com\\zq\\py\\BrowseShopSzlcsc.py -u " + "https://item.szlcsc.com/139811.html");
		System.out.println("【立创商城】价格信息：\n" + str);
	}
	
	/**
	 * - 获取【云汉芯城】指定页面的价格信息
	 * - 没有获取成功
	 */
	@Test
	public void testJavaCallPyGetPriceOfIckey(){
		// 调用系统命令
		String str = RuntimeUtil.execForStr("python F:\\Workspaces\\eclipse202109\\pyGrabShop\\com\\zq\\py\\BrowseShopIckey.py -u " + "https://www.ickey.cn/detail/1003001428067342/PE2512FKF7W0R008Z.html");
		System.out.println("云汉芯城价格信息：" + str);
	}
	
	/**
	 * - 获取【华秋商城】指定页面的价格信息
	 */
	@Test
	public void testJavaCallPyGetPriceOfHqchips(){
		// 调用系统命令
		String str = RuntimeUtil.execForStr("python F:\\Workspaces\\eclipse202109\\pyGrabShop\\com\\zq\\py\\BrowseShopHqchips.py -u " + "https://www.hqchip.com/p/ACPL-C87AT-500E.html");
		System.out.println("华秋商城价格信息：" + str);
	}
	
	/**
	 * - 获取【硬之城】指定页面的价格信息
	 */
	@Test
	public void testJavaCallPyGetPriceOfAllChips(){
		// 调用系统命令
		String str = RuntimeUtil.execForStr("python F:\\Workspaces\\eclipse202109\\pyGrabShop\\com\\zq\\py\\BrowseShopAllChips.py -u " + "https://www.allchips.com/detail84237595");
		System.out.println("【硬之城】价格信息：" + str);
	}
	
	@Test
	public void testStringSplit(){
		// 调用系统命令
		String str = "AC1313";
		String[] strArr = str.split(" ");
		List<String> strList = Arrays.asList(strArr);
		System.out.println("strList.size():" + strList.size());
	}
}
