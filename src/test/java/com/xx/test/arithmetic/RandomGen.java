package com.xx.test.arithmetic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RandomGen {

	public static void main(String[] args){
		try {
			Integer[] a = getRandom(1, 100, 40);
			System.out.println(Arrays.toString(a));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param min 指定范围最小值
	 * @param max 指定范围最大值
	 * @param n 随机数个数
	 * @return
	 * @throws Exception
	 */
	public static Integer[] getRandom(int min,int max,int n) throws Exception{
		List<Integer> list = new ArrayList<>();
		Map<Integer, Object> map = new HashMap<Integer,Object>();
		if(n > (max - min + 1) || max < min){
			return null;
		}
		while(list.size() < n){
			int num = (int)(Math.random()*(max - min)) + min;
			if(map.containsKey(num)){
				continue;
			}
			list.add(num);
			map.put(num, -1);
		}
		Integer list2[] = new Integer[n];
		list2 = list.toArray(list2);
		return list2;
	}
}
