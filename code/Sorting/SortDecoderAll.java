//This program requires two command line parameters f - the "encoded" file
//and fkey - the dat file with the "key" to decoding f. Both are binary files.
//It ouputs the "decoded" version of f.
import java.io.*;
import java.util.*;

public class SortDecoderAll
{
	public static void main(String[] args)
	{
		int i, n=1; entry[] array = new entry[1000000];  
		for (int h=1; h<1000000; h++) array[h]=new entry();
		try
		{
	        DataInputStream ins=new DataInputStream(new FileInputStream(args[0]));
	        DataInputStream inskey=new DataInputStream(new FileInputStream(args[1]));
			try
			{
				while (true)
				{
					array[n].key=inskey.readInt();;
					array[n].b=ins.readByte();
					n++;
				}
			}
			catch(EOFException e)
			{
				System.out.println("Done reading file.");
			}
			ins.close(); inskey.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Cannot find file.");
		}
		catch(IOException e)
		{
			System.out.println("Input problem with file.");
		}
		n--; System.out.println("n is "+n);
		insertionsort(array,n);
		try
		{
			DataOutputStream outs=new DataOutputStream(new FileOutputStream("decoded"+args[0]));
			for (i=1; i<=n; i++) outs.writeByte(array[i].b);
			outs.close();
                        System.out.println("The output file is "+"decoded"+args[0]);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Cannot find file.");
		}
		catch(IOException e)
		{
			System.out.println("Input problem with file.");
		}
	}

	public static void insertionsort(entry[] a,int n){
		int i;
		for(i = 2; i <= n; i++){
			int k = i;
			while((k > 1) && (a[k].key < a[k - 1].key)){
				entry temp = a[k];
				a[k] = a[k-1];
				a[k-1] = temp;
				k--;
			}
		}
	}

	public static void quicksort(entry[] a, int i, int j){
		int p;
		if(i < j){
			p = partition(a, i , j);
			quicksort(a,i,p-1);
			quicksort(a,p+1,j);
		}
	}

	public static int partition(entry[] a, int i, int j){
		int upper,lower;
		entry pivot;
		upper = i; lower = j; pivot = a[i];
		while(upper != lower){
			while((upper < lower) && (pivot.key <= a[lower].key)){lower--;}
			if(upper != lower) a[upper] = a[lower];
			while((upper < lower) && (pivot.key >= a[upper].key)){upper++;}
			if(upper != lower) a[lower] = a[upper];
		}
		a[upper] = pivot;
		return upper;
	}

	public static void mergesort(entry[] a, int top, int bottom)
	{
		if (top!=bottom)
		{
		  	int middle=(top+bottom)/2;
		   	mergesort(a, top, middle);
		   	mergesort(a, middle+1, bottom);
		   	merge(a, top, bottom);
		}
	}

	public static void merge(entry[] a, int top, int bottom)
	{
		int t=top; int middle=(top+bottom)/2; int b=middle+1; int i=0;
		entry[] s=new entry[bottom-top+1];
		while ((t<=middle)&&(b<=bottom))
		{
		   	if (a[t].key < a[b].key) {s[i]=a[t]; t++;}
		 	else {s[i]=a[b]; b++;}
		   	i++;
		}
		int last=middle;
		if (b<=bottom) {t=b; last=bottom;}
		while (t<=last) {s[i]=a[t]; t++; i++;}
		for (i=0; i<s.length; i++) {a[i+top]=s[i];}
	}
}
