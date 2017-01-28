//*********************************************************************
// FILE NAME    : Intcoll4.java
// DESCRIPTION  : This file contains the class Intcoll4.
// Christopher Lawrence 1.25.17
//*********************************************************************

import java.util.*;

public class Intcoll4
{
   private ListNode c;
   private int howmany;

   /**
    * makes an empty collection and makes the capacity 500 integers
    */
   public Intcoll4()
   {
      c = null;
      howmany = 0;
   }

   /**
    * makes an empty collection and makes the capacity i integers
    * Input: capacity of the collection
    */
   public Intcoll4(int i)
   {
      c = null;
      howmany = 0;
   }

   /*

   /**
    * assigns all values within obj to the collection
    * Input: object to be copied
    */
   /*
   public void copy(Intcoll4 obj)
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
   */
   

   /** 
    * returns true if i is within the collection and greater than zero , otherwise returns false
    * Input: value that is being searched for
    * Output: Returns true or false
    */
   public boolean belongs(int i)
   {
      ListNode p = c;
      while((p != null) && (p.info != i)){
        p = p.link;
      }
      return ((p != null));
   }

   /**
    * inserts i into the collection unless it is full or already in the collection
    * Input: value that is inserted into the collection
    */
   public void insert(int i)
   {
      ListNode p = c;
      while((p != null) && (p.info != i)){
        p = p.link;
      }
      if(p == null){
        howmany++;
        p = new ListNode(i,c);
        System.out.println("flag");
        c = p;
      }
   }

   /**
    * removes i from the collection if it is in the collection
    * Input: the value that is removed from the collection if in the collection
    */
   public void omit(int i)
   {

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
      ListNode p = c;
      while((p != null)){
        System.out.println(p.info);
        p = p.link;
      }
   }
   /** 
    * returns true if if the integers in the collection are exactly the same
    * as the integers in obj's collection
    * Input: object that is being compared to the called upon object
    * Output: true or false
    */
   /*
   public boolean equals(Intcoll4 obj)
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
    */
   private class ListNode
   {
      private int info;
      private ListNode link;

      public ListNode(){
        info = 0;
        link = null;
      }

      public ListNode(int i, ListNode l){
        info = i;
        link = l;
      }
   }
}

   