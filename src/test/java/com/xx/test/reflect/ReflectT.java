package com.xx.test.reflect;

import java.lang.reflect.Method;

/**
 * 
 * 通过反射调用对象的方法
 * 
 * @author Administrator
 *
 */
public class ReflectT {

	public static void main(String[] args) throws Exception {
		String str = "hello";
		Method m = str.getClass().getMethod("toUpperCase");
		
		System.out.println(m.invoke(str));
	}

}
