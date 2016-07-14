package com.xx.test.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Collections 的sort方法
 * 通过sort方法的第二个参数传入一个Comprator接口对象
 * 相当于是传入一个比较对象大小的算法到sort方法中
 * 
 * @author Administrator
 *
 */


public class CollectionsSortTest {

	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();
		list.add(new Student("Hao LUO", 33));
		list.add(new Student("XJ WANG", 32));
		list.add(new Student("Bruce LEE", 60));
		list.add(new Student("Bob YANG", 22));
		
		Collections.sort(list,new Comparator<Student>(){
			@Override
			public int compare(Student o1,Student o2){
				return o1.getName().compareTo(o2.getName());
			}
		});
		
		for(Student stu:list){
			System.out.println(stu);
		}
	}

}