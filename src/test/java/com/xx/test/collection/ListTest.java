package com.xx.test.collection;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ListTest {

	/**
	 * - 测试java中列表删除指定值
	 */
	@Test
	public void testJavaList() {
		List<String> lst = new ArrayList<String>();
		lst.add("1");
		lst.add("2");
		lst.add("3");
		lst.add("4");
		lst.add("5");
		lst.add("6");
		lst.forEach(s ->{
			System.out.println(s);
		});
		String str = new String("6");
		lst.remove("6");
		System.out.println("---------------------");
		lst.forEach(s ->{
			System.out.println(s);
		});
	}
}
