package com.xx.test.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsTest {

	public static void main(String[] args) {
		List<String> lst = new ArrayList<String>();
		
		lst.add("1");
		lst.add("2");
		lst.add("3");
		lst.add("4");
		lst.add("5");
		lst.add("6");

		//create a synchronized list
		List<String> synLst = Collections.synchronizedList(lst);
		
		System.out.println("before synchronized list is:"+lst);
		System.out.println("synchronized list is:"+synLst);
	}

}
