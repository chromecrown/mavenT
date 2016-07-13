package com.xx.test.date;
import java.util.Calendar;

/**
 * print yesterday date
 * 
 * @author Administrator
 *
 */
public class YesterdayTest {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		System.out.println(cal.getTime());

	}

}
