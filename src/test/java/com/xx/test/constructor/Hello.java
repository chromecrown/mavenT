package com.xx.test.constructor;


class A{
	static{
		System.out.print("1");
	}
	
	public A(){
		System.out.print("2");
	}
}

class B extends A{
	static{
		System.out.print("a");
	}
	
	public B(){
		System.out.print("b");
	}
}

public class Hello {

	public static void main(String[] args) {
//		A ab = new A();
//		A ab = new B();
		new B();
		A ab = new B();
	}

}
