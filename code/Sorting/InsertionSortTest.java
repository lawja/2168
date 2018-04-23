/*
 * Author: Jake Lawrence
 * InsertionSortTest.java
 * March 27, 2017
 */

import java.util.*;

public class InsertionSortTest{
	static int icount = 0;
	public static void main(String[] args){
		int[] a = new int[32];
		Random gen = new Random();
		int i;
		for(i = 0;i < a.length; i++){
			a[i] = gen.nextInt(500000) + 1;
		}
		System.out.println("Initial array:");
		for(i = 0; i < a.length; i++){
			System.out.println(a[i]);
		}

		insertionsort(a);

		System.out.println("Sorted array:");
		for(i = 0; i < a.length; i++){
			System.out.println(a[i]);
		}

		System.out.println("icount: " + icount);
	}

	/**
	 * Input: array to be sorted
	 * Output: None
	 * Sorts the array passed using the insertion sort algorithm
	 */
	public static void insertionsort(int[] a){
		int i;
		for(i = 1; i < a.length; i++){
			int k = i;
			while((k > 0) && (a[k] <= a[k - 1])){
				icount++;
				int temp = a[k];
				a[k] = a[k-1];
				a[k-1] = temp;
				k--;
			}
		}
	}
}