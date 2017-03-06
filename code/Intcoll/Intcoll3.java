//*********************************************************************
// FILE NAME    : Intcoll3.java
// DESCRIPTION  : This file contains the class Intcoll3.
// Christopher Lawrence 1.25.17
//*********************************************************************

import java.util.*;

public class Intcoll3
{
   private boolean[] c;
   private int howmany;

   /**
    * makes an empty collection and makes the capacity 500 integers
    */
   public Intcoll3()
   {
      c = new boolean[500];
      howmany = 0;
   }

   /**
    * makes an empty collection and makes the capacity i integers
    * Input: capacity of the collection
    */
   public Intcoll3(int i)
   {
      c = new boolean[i];
      howmany = 0;
   }

   /**
    * assigns all values within obj to the collection
    * Input: object to be copied
    */
   public void copy(Intcoll3 obj)
   {
      if (this != obj)
      {
         c = new boolean[obj.c.length];

         int j = 0;
         while ((j < c.length))
         {
            c[j] = obj.c[j];
            j++;
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
      return((i < c.length) && (c[i]));
   }

   /**
    * inserts i into the collection unless it is full or already in the collection
    * Input: value that is inserted into the collection
    */
   public void insert(int i)
   {
      if (i > 0)
      {
         if(i > c.length - 1)
         {
            boolean[] d = new boolean[((i * 2) + 1)];
            int k = 0;
            while(k < c.length){
               d[k] = c[k];
               k++;
            }
            k = c.length;
            while(k < d.length){
               d[k] = false;
               k++;
            }
            c = d;
            c[i] = true;
            howmany++;
         }
         else if(!(c[i])){
            c[i] = true;
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
         if(belongs(i)){
            c[i] = false;
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
      int j = 0, i = 0;
      System.out.println();
      while ((j != howmany) && (i != c.length))
      {
         if(c[i]){
            System.out.println(i);
            j++;
         }
         i++;
      }
   }


   /** 
    * returns true if if the integers in the collection are exactly the same
    * as the integers in obj's collection
    * Input: object that is being compared to the called upon object
    * Output: true or false
    */
   public boolean equals(Intcoll3 obj)
   {
      boolean result = (howmany == obj.get_howmany());
      if(result){
         int j = 0;
         while ((j != howmany)&&result)
         {
            result = (obj.belongs(j) == c[j]); j++;
         }

      }

      return result;
   }
}

   