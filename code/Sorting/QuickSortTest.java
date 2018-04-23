/*
 * Author: Jake Lawrence
 * QuickSortTest.java
 * March 27, 2017
 */

import java.util.*;

public class QuickSortTest{
	static int qcount = 0, numcalls = 0;
	public static void main(String[] args){
		int[] a =  new int[32];
		Random gen = new Random();
		int i;
		for(i = 0; i < a.length; i++){
			a[i] = gen.nextInt(5000) + 1;
		}
		System.out.println("Initial array:");
		for (i=0; i<a.length; i++) System.out.println(a[i] + " ");

		quicksort(a,0,(a.length) - 1);

		System.out.println("Sorted array:");
		for (i=0; i<a.length; i++) System.out.println(a[i] + " ");
		System.out.println("\nQcount: "+ qcount);
		System.out.println("Numcalls: " + numcalls);

		int[] b = {17,23,48,9,14,37,13,77};
		System.out.println(Arrays.toString(b));
		partition(b,0,b.length -1);
		System.out.println(Arrays.toString(b));
	}

	/**
	 * Input: Input: array, beginning index of array, end index of array
	 * Output: None
	 * Sorts the array passed using the quick sort algorithm
	 */
	public static void quicksort(int[] a, int i, int j){
		numcalls++;
		int p;
		if(i < j){
			p = partition(a, i , j);
			quicksort(a,i,p-1);
			quicksort(a,p+1,j);
		}
	}

	/**
	 * Input: Input: array, beginning index of array, end index of array
	 * Output: The index of the partition value
	 * Identifies the partition value and edits the array around the value
	 */
	public static int partition(int[] a, int i, int j){
		int upper,lower,pivot;
		upper = i; lower = j; pivot = a[i];
		System.out.print(pivot + "->");
		while(upper != lower){
			while((upper < lower) && (pivot <= a[lower])){lower--;qcount++;}
			if(upper != lower) a[upper] = a[lower];
			while((upper < lower) && (pivot >= a[upper])){upper++;qcount++;}
			if(upper != lower) a[lower] = a[upper];
		}
		a[upper] = pivot;
		System.out.println(Arrays.toString(a));
		return upper;
	}
}