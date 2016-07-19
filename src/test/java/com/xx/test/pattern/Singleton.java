package com.xx.test.pattern;

/**
 * 恶汉式单例
 * 
 * @author Administrator
 *
 */
public class Singleton {
	private Singleton() {
	}

	private static Singleton instance = new Singleton();

	public static Singleton getInstance() {
		return instance;
	}
}

/**
 * 懒汉式单例
 * 
 * @author Administrator
 *
 */
class Singleton2 {
	private static Singleton2 instance = null;

	private Singleton2() {
	}

	public static synchronized Singleton2 getInstance() {
		if (instance == null) {
			instance = new Singleton2();
		}
		return instance;
	}
}