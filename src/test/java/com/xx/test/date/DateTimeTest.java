package com.xx.test.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class DateTimeTest {

	@Test
	public void testJavaDateTimeBefore1970() {
		// DateTimeUtil.getNowtimeByFmt("yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX");
		String time = "1900-01-01 10:05:39.597";
//		String time = "2020-02-13 16:01:30";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date date = null;
		try {
			date = sdf.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(date);
		Long timestamp = date.getTime();
		String hexStr = Long.toHexString(timestamp);
		System.out.println("hex string:" + hexStr);
	}
}
