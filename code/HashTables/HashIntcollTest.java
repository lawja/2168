//******************************************************************************
// FILE NAME    : HashIntcollTest.java
// DESCRIPTION  : This file tests Intcoll7 - the hash table version of Intcoll.
//******************************************************************************

import java.util.*;
import java.io.*;

public class HashIntcollTest
{
   public static void main(String[] args)
   {
      System.out.println("Enter # of random integers to be generated");
      Scanner blackboard=new Scanner(System.in);
      int n=blackboard.nextInt(); 
      Intcoll7 Hash=new Intcoll7(n);  
      Random gen=new Random(); long lapse=0, begin, end; int k=0;
      while (k<n) 
      {
         int i=5*(gen.nextInt(n)+1); 
         begin=System.currentTimeMillis();
         Hash.insert(i);
         end=System.currentTimeMillis();
         lapse=lapse+(end-begin);
         k++;
      }
      System.out.println("The # of integers in Hash is "+Hash.get_howmany());
      System.out.println("Time in milliseconds "+lapse);
   }
}