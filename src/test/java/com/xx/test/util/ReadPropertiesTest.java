package com.xx.test.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.junit.Test;

public class ReadPropertiesTest{

	public static Properties prop = new Properties();
	/**
	 * test read properties file
	 * 
	 * @throws  
	 * 
	 */
	@Test
	public void testReadProperties(){
		try {
			FileInputStream fis = new FileInputStream("src/main/resources/data.properties");
			prop.load(fis);
			String  val = getPropertyVal("note");
			System.out.println("geted property value is " + val);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * get current file's base path
	 * 
	 */
	@Test
	public void testGetCurrentFilePath(){
		String ss = System.getProperty("user.dir");
		System.out.println("current file path is :"+ss);
		
		File dir = new File("");//assume the current directory
		try{
			String path = dir.getCanonicalPath();
			String absPath = dir.getAbsolutePath();
			System.out.println(path);
			System.out.println(absPath);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * read property value by the given key 
	 * 
	 * @param key
	 * @return
	 */
	public static String getPropertyVal(String key){
		String valStr = prop.getProperty(key);
		return valStr;
	}
}