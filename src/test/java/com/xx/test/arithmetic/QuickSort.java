package com.xx.test.arithmetic;

import java.util.Arrays;
import org.apache.commons.lang.ArrayUtils;

/**
 * 1、以第一个关键字K1为控制字，将[k1,k2,...,kn]分成两个子区，
 * 使左区所有关键字小于等于k1,右区所有关键字大于等于k1，
 * 最后控制字居两个子区中间的适当位置。在子区内数据尚处于无序状态。
 * 2、把左区作为一个整体，用1的步骤进行处理，右区进行相同的处理。（即递归）
 * 3、重复第1、2步，直到左区处理完毕。
 * @author wq
 *
 */
public class QuickSort {

	public static void main(String[] args) {
		Integer[] a = new Integer[100];
		try {
			a = RandomGen.getRandom(1, 200, 100);
			System.out.println("a==>"+Arrays.toString(a));
			int[] b = ArrayUtils.toPrimitive(a);
			quicksort(b, 0, b.length-1);
			System.out.println("b==>"+Arrays.toString(a));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static int partition(int n[],int left,int right){
		int pivot = n[left];
		while(left < right){
			while(left < right && n[right]>=pivot){
				right --;
			}
			if(left < right)
				n[left++] = n[right];
			while(left < right && n[left] <= pivot){
				left ++;
			}
			if(left < right)
				n[right--] = n[left];
		}
		n[left] = pivot;
		return left;
	}
	
	static void quicksort(int n[],int left,int right){
		int dp;
		if(left < right){
			dp = partition(n, left,right);
			quicksort(n, left, dp -1);
			quicksort(n, dp + 1, right);
		}
	}
}
