package com.xx.test.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import org.junit.Test;

public class MethodRefTest{

	/**
	 * java8方法引用测试
	 * 
	 */
	@Test
	public void testJava8MethodRef(){
		//静态方法的引用:它的语法是Class::static_method
		final Car car = Car.create(Car::new);
		final List<Car> cars = Arrays.asList(car);
		
		//特定类的任意对象的方法引用:语法是Class::method
		cars.forEach(Car::collide);
		
		//特定对象的方法引用,语法是instance::method
		cars.forEach(Car::repair);
		
		//构造器引用,语法是Class::new,或者更一般的Class<T>::new
		final Car police = Car.create(Car::new);
		cars.forEach(police::follow);
		
		
		List<Object> names  = new ArrayList<>();
		names.add("Google");
		names.add("Runoob");
		names.add("Taobao");
		names.add("Baidu");
		names.add("Sina");
		//将System.out::println方法作为静态方法来引用
		names.forEach(System.out::println);
	}
}

class Car{
	
	public static Car create(final Supplier<Car>supplier ){
		return supplier.get();
	}
	
	//方法定义
	public static void collide(final Car car){
		System.out.println("Collided " + car.toString());
	}
	
	//方法定义
	public void follow(final Car another){
		System.out.println("Following the " + another.toString());
	}
	
	//方法定义
	public void repair(){
		System.out.println("Repaired " + this.toString());
	}
}