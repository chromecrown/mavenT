package com.xx.test.exception;

public class ExceptionTest {

	public static void main(String[] args) {
		try{
			throw new ExampleB();
		}catch(ExampleA e){
			System.out.println("ExampleA");
		}catch(Exception e){
			System.out.println("Exception");
		}
	}

}

class ExampleA extends Exception{
	
}

class ExampleB extends ExampleA{
	
}