//*********************************************************************
// FILE NAME    : Intcoll5.java
// DESCRIPTION  : This file contains the class Intcoll4.
// Christopher Lawrence 1.25.17
//*********************************************************************

import java.util.*;

public class Intcoll5
{
   private LinkedList<Integer> c;

   /**
    * makes an empty collection and makes the capacity 500 integers
    */
   public Intcoll5()
   {
      c = new LinkedList<Integer>();
   }

   /**
    * makes an empty collection and makes the capacity i integers
    * Input: capacity of the collection
    */
   public Intcoll5(int i)
   {
      c = new LinkedList<Integer>();
   }

   /**
    * assigns all values within obj to the collection
    * Input: object to be copied
    */
   public void copy(Intcoll5 obj)
   {
      if (this != obj)
      {
        c = new LinkedList<Integer>();
        ListIterator<Integer> I = obj.c.listIterator();
        while(I.hasNext()){
          int m = I.next();
          c.add(m);
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
      return c.contains(new Integer(i));
   }

   /**
    * inserts i into the collection unless it is full or already in the collection
    * Input: value that is inserted into the collection
    */
   public void insert(int i)
   {
      if(!(belongs(i)))
        c.add(new Integer(i));
   }

   /**
    * removes i from the collection if it is in the collection
    * Input: the value that is removed from the collection if in the collection
    */
   public void omit(int i)
   {
      if(belongs(i))
        c.remove(new Integer(i));
   }

   /**
    * returns how many integers are in the collection
    * Output: an integer
    */
   public int get_howmany()
   {
      return c.size();
   }

   /**
    * print all values within the collection
    */
   public void print()
   {
      ListIterator<Integer> I = c.listIterator();
      while(I.hasNext()){
        Integer m = I.next();
        System.out.println(m.intValue());
      }
      
   }
   /** 
    * returns true if if the integers in the collection are exactly the same
    * as the integers in obj's collection
    * Input: object that is being compared to the called upon object
    * Output: true or false
    */
   public boolean equals(Intcoll5 obj)
   {
     ListIterator<Integer> I = c.listIterator();
     ListIterator<Integer> J = obj.c.listIterator();
     boolean result = (get_howmany() == obj.get_howmany());
     while(I.hasNext() && result){
        Integer m = I.next();
        result = obj.belongs(m.intValue());
     }
     while(J.hasNext() && result){
        Integer m = J.next();
        result = belongs(m.intValue());
     }
     return result;
   }
}

   