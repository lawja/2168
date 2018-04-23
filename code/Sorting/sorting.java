/*
 * Author: Jake Lawrence
 * Sorting.java
 * March 27, 2017
 */

import java.util.*;

public class Sorting{
	// tracking variables for various sorts
	static int m = 0, icount = 0, qcount = 0;
	// variables used for averages
	static int m_sum = 0, icount_sum = 0, qcount_sum = 0;
	// driver method
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);

		System.out.print("Amount of runs > ");
		int x = input.nextInt();

		System.out.println("INSERTION SORT");
		gen_insertion(x,2048);
		gen_insertion(x,4096);
		gen_insertion(x,8192);
		gen_insertion(x,16384);

		System.out.println("MERGE SORT");
		gen_merge(x,2048);
		gen_merge(x,4096);
		gen_merge(x,8192);
		gen_merge(x,16384);

		System.out.println("QUICK SORT");
		gen_quick(x,2048);
		gen_quick(x,4096);
		gen_quick(x,8192);
		gen_quick(x,16384);
		gen_quick(x,32768);
		
	}

	/**
	 * Input: Array to be filled
	 * Output: None
	 * Fills an array with random integers
	 */
	public static void fillArray(int[] a){
		Random gen = new Random();
		int i;
		for(i = 0; i < a.length; i++){
			a[i] = gen.nextInt(500000) + 1;
		}
	}

	public static boolean isSorted(int[] a){
		boolean result = true;
		int i;
		for(i = 0; (i < a.length - 1) && result; i++){
			result = a[i] <= a[i+1];
		}
		return result;
	}

	/**
	 * Input: number of runs, size of the array
	 * Output: None
	 * Prints a table with statistics for mergesort
	 */
	public static void gen_merge(int runs,int size){
		int[] m_track = new int[runs];
		long[] t_track = new long[runs];

		int[] array = new int[size];

		m = 0; m_sum = 0;

		long begin,end,t_sum = 0;

		boolean validated = true;

		while(runs > 0){
			fillArray(array);

			begin = System.currentTimeMillis();
			mergesort(array,0,array.length - 1);
			end = System.currentTimeMillis();

			if(validated)
				validated = isSorted(array);

			m_track[runs-1] = m;
			m_sum += m;
			m = 0;

			t_track[runs-1] = (end - begin);
			t_sum += (end - begin);
			
			runs--;
		}

		mergesort(m_track,0,m_track.length - 1);
		
		System.out.println("\tSize: " + size);
		System.out.println("\t\tm values ->\tMin: " + m_track[0] + "\tMax: " + m_track[m_track.length - 1] + 
			"\tAverage: " + (((double)m_sum)/m_track.length));
		System.out.println("\t\ttimes ->\tAverage: " + (((double)t_sum)/t_track.length) + "ms");
		System.out.println("\tvalidated -> " + validated);
	}

	/**
	 * Input: number of runs, size of the array
	 * Output: None
	 * Prints a table with statistics for insertion sort
	 */
	public static void gen_insertion(int runs,int size){
		int[] i_track = new int[runs];
		long[] t_track = new long[runs];

		int[] array = new int[size];

		icount = 0; icount_sum = 0;

		long begin,end,t_sum = 0;

		boolean validated = true;

		while(runs > 0){
			fillArray(array);

			begin = System.currentTimeMillis();
			insertionsort(array);
			end = System.currentTimeMillis();

			if(validated)
				validated = isSorted(array);

			i_track[runs-1] = icount;
			icount_sum += icount;
			icount = 0;

			t_track[runs-1] = (end - begin);
			t_sum += (end - begin);
			
			runs--;
		}

		mergesort(i_track,0,i_track.length - 1);

		System.out.println("\tSize: " + size);
		System.out.println("\t\ticount values ->\tMin: " + i_track[0] + "\tMax: " + i_track[i_track.length - 1] + 
			"\tAverage: " + (((double)icount_sum)/i_track.length));
		System.out.println("\t\ttimes ->\tAverage: " + (((double)t_sum)/t_track.length) + "ms");
		System.out.println("\tvalidated -> " + validated);
	}

	/**
	 * Input: number of runs, size of the array
	 * Output: None
	 * Prints a table with statistics for quick sort
	 */
	public static void gen_quick(int runs,int size){
		int[] q_track = new int[runs];
		long[] t_track = new long[runs];

		int[] array = new int[size];

		qcount = 0; qcount_sum = 0;

		long begin,end,t_sum = 0;

		boolean validated = true;

		while(runs > 0){
			fillArray(array);

			begin = System.currentTimeMillis();
			quicksort(array,0,array.length - 1);
			end = System.currentTimeMillis();

			if(validated)
				validated = isSorted(array);

			q_track[runs-1] = qcount;
			qcount_sum += qcount;
			qcount = 0;

			t_track[runs-1] = (end - begin);
			t_sum += (end - begin);
			
			runs--;
		}

		mergesort(q_track,0,q_track.length - 1);

		System.out.println("\tSize: " + size);
		System.out.println("\t\tqcount values ->\tMin: " + q_track[0] + "\tMax: " + q_track[q_track.length - 1] + 
			"\tAverage: " + (((double)qcount_sum)/q_track.length));
		System.out.println("\t\ttimes ->\tAverage: " + (((double)t_sum)/t_track.length) + "ms");
		System.out.println("\tvalidated -> " + validated);
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

	/**
	 * Input: array to be sorted, beginning index of array, end index of array
	 * Output: None
	 * Sorts the array passed using the merge sort algorithm
	 */
	public static void mergesort(int[] a, int top, int bottom)
    {
      if (top!=bottom)
      {
         int middle=(top+bottom)/2;
         mergesort(a, top, middle);
         mergesort(a, middle+1, bottom);
         merge(a, top, bottom);
      }
    }

    /**
	 * Input: array, beginning index of array, end index of array
	 * Output: None
	 * Merges two sorted arrays
	 */
   public static void merge(int[] a, int top, int bottom)
    {
      int t=top; int middle=(top+bottom)/2; int b=middle+1; int i=0;
      int[] s=new int[bottom-top+1];
      while ((t<=middle)&&(b<=bottom))
      {
         if (a[t]<a[b])
         {
            s[i]=a[t]; t++;
         }
         else
         {
            s[i]=a[b]; b++;
         }
         i++; m++;
      }
      int last=middle;
      if (b<=bottom) {t=b; last=bottom;}
      while (t<=last)
      {
         s[i]=a[t]; t++; i++; m++;
      }
      for (i=0; i<s.length; i++) {a[i+top]=s[i]; m++;}
   }
	
	/**
	 * Input: Input: array, beginning index of array, end index of array
	 * Output: None
	 * Sorts the array passed using the quick sort algorithm
	 */
	public static void quicksort(int[] a, int i, int j){
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
		while(upper != lower){
			while((upper < lower) && (pivot <= a[lower])){lower--;qcount++;}
			if(upper != lower) a[upper] = a[lower];
			while((upper < lower) && (pivot >= a[upper])){upper++;qcount++;}
			if(upper != lower) a[lower] = a[upper];
		}
		a[upper] = pivot;
		return upper;
	}
}