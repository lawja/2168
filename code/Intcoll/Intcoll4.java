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

   /**
    * assigns all values within obj to the collection
    * Input: object to be copied
    */
   public void copy(Intcoll4 obj)
   {
      if (this != obj)
      {
        ListNode temp;
        if(obj.howmany == 0){
          temp = null;
        }else{
          ListNode cur = obj.c;

          temp = new ListNode();
          temp.info = cur.info;
          ListNode p = temp;

          cur = cur.link;

          while(cur != null){
            p.link = new ListNode();
            p = p.link;
            p.info = cur.info;
            cur = cur.link;
          }
        }
        c = temp;
        howmany = obj.howmany;
      }
   }
   

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
      return (p != null);
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
        c = p;
      }
   }

   /**
    * removes i from the collection if it is in the collection
    * Input: the value that is removed from the collection if in the collection
    */
   public void omit(int i)
   {
      if(belongs(i)){
        ListNode p = c;
        ListNode prev = null;
        while((p != null) && (p.info != i)){
          prev = p;
          p = p.link;
        }
        if(p != null){
          if(prev == null){ // if i is in the first node
            c = c.link;
          }else{
            prev.link = p.link; // link the two together (skip)
          }
          howmany--;
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
   public boolean equals(Intcoll4 obj)
   {
      boolean result = (howmany == obj.get_howmany());
      if(result){
         ListNode p = c;
         while ((p != null)&&result)
         {
            result = (obj.belongs(p.info));
            p = p.link;
         }
      }

      return result;
   }

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

   