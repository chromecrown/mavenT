package com.xx.test.collection;

import java.util.Set;
import java.util.TreeSet;

/**
 * TreeSet要求存放的对象所属的类必须实现Comparable接口，
 * 该接口提供了比较元素的compareTo方法，
 * 当插入元素时会回调该方法比较元素大小
 * 
 * @author Administrator
 *
 */
public class Student implements Comparable<Student>{

	private String name;
	private int age;
	
	public Student(String name,int age){
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString(){
		return "Student [name="+name + ",age="+age+"]";
	}
	
	@Override 
	public int compareTo(Student o){
		return this.age - o.age;
	}
	
	public static void main(String[] args) {
		Set<Student> set = new TreeSet<>();
		set.add(new Student("Hao LUO", 33));
		set.add(new Student("XJ WANG", 32));
		set.add(new Student("Bruce LEE", 60));
		set.add(new Student("Bob YANG", 22));
		
		for(Student stu:set){
			System.out.println(stu);
		}
	}

}
