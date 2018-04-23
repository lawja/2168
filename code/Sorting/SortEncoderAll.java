//This program requires one command line parameter f - file to be "encoded".
//It outputs two files  - the "encoded" f  
//and - the dat file containing  the "key" to decoding f. Both are binary files.
import java.io.*;
import java.util.*;

public class SortEncoderAll
{
	public static void main(String[] args)
	{
		int i, n=1; entry[] array = new entry[1000000];  
		for (int h=1; h<1000000; h++) array[h]=new entry();
		try
		{
	           DataInputStream ins=new DataInputStream(new FileInputStream(args[0]));

			try
			{
				while (true)
				{
					array[n].key=n;
					array[n].b=ins.readByte();
					n++;
				}
			}
			catch(EOFException e)
			{
				System.out.println("Done reading file.");
			}
			ins.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Cannot find file.");
		}
		catch(IOException e)
		{
			System.out.println("Input problem with file.");
		}

		int s, t, v; byte x; n--; System.out.println("n is "+n);
		try
		{
			DataOutputStream outs=new DataOutputStream(new FileOutputStream("encoded"+args[0]));
			String S=args[0].substring(0, args[0].indexOf(".")); System.out.println("S is "+S);
			DataOutputStream outskey=new DataOutputStream(new FileOutputStream("encoded"+S+"key.dat"));
			for (int j=1; j<=n; j++)
			{
				Random gen=new Random();
				s=gen.nextInt(n)+1;
				t=gen.nextInt(n)+1;
				entry temp=array[s];
				array[s]=array[t];
				array[t]=temp;
			}
                        
			for (i=1; i<=n; i++) {outs.writeByte(array[i].b); outskey.writeInt(array[i].key);}
			outs.close(); outskey.close();
                        System.out.println("The output files are "+"encoded"+args[0]+" and "+"encoded"+S+"key.dat");
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
}
