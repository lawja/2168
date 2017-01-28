//*********************************************************************
// FILE NAME    : Intcoll2.java
// DESCRIPTION  : This file contains the class Intcoll2.
// Christopher Lawrence 1.25.17
//*********************************************************************

import java.util.*;

public class Intcoll2
{
   private int[] c;
   private int howmany;

   /**
    * makes an empty collection and makes the capacity 500 integers
    */
   public Intcoll2()
   {
      c = new int[500];
      howmany = 0;
   }

   /**
    * makes an empty collection and makes the capacity i integers
    * Input: capacity of the collection
    */
   public Intcoll2(int i)
   {
      c = new int[i];
      howmany = 0;
   }

   /**
    * assigns all values within obj to the collection
    * Input: object to be copied
    */
   public void copy(Intcoll2 obj)
   {
      if (this != obj)
      {
         c = new int[obj.c.length];

         int j = 0;
         while (obj.get_howmany() != j)
         {
            c[j] = obj.c[j]; j++;
            howmany++;
         }
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
      while ((j != howmany)&&(c[j] != i)) j++;
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
         while ((j != howmany) && (c[j] != i)) j++;
         if (j == howmany)
            {
            if (j == c.length - 1)
               {
                  int[] d = new int[(c.length * 2)];
                  int k = 0;
                  while(k != howmany){
                     d[k] = c[k];
                     k++;
                  }
                  c = d;
               }
               c[j] = i;
               howmany++;
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
         while ((j != howmany) && (c[j] != i)) j++;
         if ((c[j] == i))
         {
            howmany--;
            c[j] = c[howmany];
         }
      }
   }

   /**
    * returns how many integers are in the collection
    * Output: an integer
    */
   public int get_howmany()
   {
      return howmany;
   }

   /**
    * print all values within the collection
    */
   public void print()
   {
      int j = 0;
      System.out.println();
      while (j != howmany)
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
   public boolean equals(Intcoll2 obj)
   {
      boolean result = (howmany == obj.get_howmany());
      if(result){
         int j = 0;
         while ((j != howmany)&&result)
         {
            result = obj.belongs(c[j]); j++;
         }
      }

      return result;
   }
}

   