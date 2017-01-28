//*********************************************************************
// FILE NAME    : Intcoll1.java
// DESCRIPTION  : This file contains the class Intcoll1.
// Christopher Lawrence 1.25.17
//*********************************************************************

import java.util.*;

public class Intcoll1
{
   private int[] c;

   /**
    * makes an empty collection and makes the capacity 500 integers
    */
   public Intcoll1()
   {
      c = new int[500+1];
      c[0] = 0;
   }

   /**
    * makes an empty collection and makes the capacity i integers
    * Input: capacity of the collection
    */
   public Intcoll1(int i)
   {
      c = new int[i+1];
      c[0] = 0;
   }

   /**
    * assigns all values within obj to the collection
    * Input: object to be copied
    */
   public void copy(Intcoll1 obj)
   {
      if (this != obj)
      {
         c = new int[obj.c.length];
         int j = 0;
         while (obj.c[j] != 0)
         {
            c[j] = obj.c[j]; j++;
         }
         c[j] = 0;
      }
   }

   /** 
    * returns true if i is within the collection and greater than zero , otherwise returns false
    * Input: value that is being searched for
    * Output: Returns true or false
    */
   public boolean belongs(int i)
   {
      int j = 0;
      while ((c[j] != 0)&&(c[j] != i)) j++;
      return ((i>0)&&(c[j] == i));
   }

   /**
    * inserts i into the collection unless it is full or already in the collection
    * Input: value that is inserted into the collection
    */
   public void insert(int i)
   {
      if (i > 0)
      {
         int j = 0;
         while ((c[j] != 0) && (c[j] != i)) j++;
         if (c[j] == 0)
            {
            if (j == c.length - 1)
               {
                  int[] d = new int[(c.length - 1) * 2];
                  d[0] = 0;
                  int k = 0;
                  while(c[k] != 0){
                     d[k] = c[k];
                     k++;
                  }
                  c = d;
               }
               c[j] = i; c[j + 1] = 0;
         }
      }
   }

   /**
    * removes i from the collection if it is in the collection
    * Input: the value that is removed from the collection if in the collection
    */
   public void omit(int i)
   {
      if (i>0)
      {
         int j = 0;
         while ((c[j] != 0)&&(c[j] != i)) j++;
         if (c[j] == i)
         {
            int k = j+1;
            while (c[k] != 0) k++;
            c[j] = c[k-1]; c[k-1]=0;
         }
      }
   }

   /**
    * returns how many integers are in the collection
    * Output: an integer
    */
   public int get_howmany()
   {
         int j=0, howmany=0;

         while (c[j]!=0) {howmany++; j++;}
         return howmany;
   }

   /**
    * print all values within the collection
    */
   public void print()
   {
      int j = 0;
      System.out.println();
      while (c[j] != 0)
      {
         System.out.println(c[j]); j++;
      }
   }

   /** 
    * returns true if if the integers in the collection are exactly the same
    * as the integers in obj's collection
    * Input: object that is being compared to the called upon object
    * Output: true or false
    */
   public boolean equals(Intcoll1 obj)
   {
      int j = 0; boolean result = true;
      while ((c[j] != 0)&&result)
      {
         result = obj.belongs(c[j]); j++;
      }
      j = 0;
      while ((obj.c[j] != 0)&&result)
      {
         result = belongs(obj.c[j]); j++;
      }
      return result;
   }
}

   