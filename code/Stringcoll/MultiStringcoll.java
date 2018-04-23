//***********************************************************************
// FILE NAME    : Stringcoll.java
// DESCRIPTION  : This file contains the class Stringcoll.
//************************************************************************

import java.util.*;
import java.io.*;

public class MultiStringcoll
{
   private int howmany, total;
   private btNode c;

   /**
    * makes an empty collection and makes the capacity 500 integers
    */
   public MultiStringcoll()
   {
      c = null;
      howmany = 0;
      total = 0;
   }

   /**
    * makes an empty collection
    * Input: capacity of the collection
    * Output: none
    */
   public MultiStringcoll(int i)
   {
      c = null;
      howmany = 0;
      total = 0;
   }

   /**
    * creates a copy of a binary tree
    * Input: binary tree (tree being copied)
    * Output: binary tree (copy of tree)
    */
   private static btNode copytree(btNode t)
   {
      btNode root=null;
      if (t!=null)
      {
         root=new btNode();
         root.info=t.info; 
         root.amount=t.amount;
         root.left=copytree(t.left);
         root.right=copytree(t.right);
      }
      return root;
   }

   /**
    * assigns all values within obj to the collection
    * Input: object to be copied
    * Output: none
    */
   public void copy(MultiStringcoll obj)
   {
      if (this!=obj)
      {
          howmany=obj.howmany;
          total=obj.total;
          c=copytree(obj.c);  
      }
   }

   /**
    * inserts i into the collection unless it is full or already in the collection
    * Input: value that is inserted into the collection
    * Output: none
    */
   public void insert(String i)
   {
       btNode pred=null, p=c;

       while ((p!=null)&&(!(p.info.equals(i))))
       {
           pred=p;
    	     if ((p.info.compareTo(i)) > 0) p=p.left;
    	     else p=p.right;
       }
       total++;
       if (p == null)
       {
          howmany++; p=new btNode(i, 1, null, null);
          if (pred!=null)
          {
  	         if ((pred.info.compareTo(i)) > 0) pred.left=p;
             else pred.right=p;
          }
          else c=p;
       }else{
          p.amount++;
       }
   }

   /**
    * removes i from the collection if it is in the collection
    * Input: the value that is removed from the collection if in the collection
    * Output: none
    */
   public void omit(String i)
   {  
       btNode pred=null, p=c;

       while ((p!=null)&&(!(p.info.equals(i))))
       {
           pred=p;
           if ((p.info.compareTo(i)) > 0) p=p.left;
           else p=p.right;
       }

       if(p != null){
          total--;
          if(p.amount > 1){
            p.amount--;
          }else{
            howmany--;
            if((p.left == null) && (p.right == null)){
              if(pred == null){
                c = null;
              }else{
                if(i.compareTo(pred.info) > 0)
                  pred.right = null;
                else
                  pred.left = null;
              }
            }else if((p.left == null) && (p.right != null)){
              if(pred == null){
                c = p.right;
              }else{
                if(i.compareTo(pred.info) > 0)
                  pred.right = p.right;
                else
                  pred.left = p.right;
              }
            }else if((p.left != null) && (p.right == null)){
              if(pred == null){
                c = p.left;
              }else{
                if(i.compareTo(pred.info) > 0)
                  pred.right = p.left;
                else
                  pred.left = p.left;
              }
            }else{
                btNode q = p;
                btNode l = p;
                pred = q.left;
                q = pred.right;
                while (q != null) {
                    l = pred;
                    pred = q;
                    q = q.right;
                } 
                p.info = pred.info;
                if (l.info.equals(p.info)) 
                  l.left = pred.left;
                else 
                  l.right = pred.left;
            }
          }
         
      }

      return;    

   }

   /** 
    * returns returns the amount of instances of the string in the collection
    * Input: value that is being searched for
    * Output: Returns the amount of instances of the string, an int
    */
   public int belongs(String i)
   {
      btNode p=c;
      String a[] = new String[howmany];
      int[] b = new int[howmany];

      toarray(p,a,b,0);

      int left = 0, right = howmany - 1;
      int middle = right / 2;

      while(right >= left){
          if(a[middle].compareTo(i) == 0)
            return b[middle];
          else if(a[middle].compareTo(i) > 0)
            right = middle - 1;
          else if(a[middle].compareTo(i) < 0)
            left = middle + 1;
          middle = (left + right)/2;
      }
      return 0;
   }

   /**
    * returns how many distinct Strings are in the collection
    * Output: an integer
    */
   public int get_howmany() {return howmany;}

   /**
    * returns how many total Strings are in the collection
    * Output: an integer
    */
   public int get_total() {return total;}

   /**
    * print all values within the collection
    */
   public void print()
   {
      printtree(c);
   }

   /** 
    * returns true if if the Strings in the collection are exactly the same
    * as the Strings in obj's collection
    * Input: object that is being compared to the called upon object
    * Output: true or false
    */
   public boolean equals(MultiStringcoll obj)
   {
      boolean result = (obj.howmany == howmany)&&(obj.total == total);
      if(result && howmany != 0){
          result = (belongs(obj.c.info) > 0);
          equals(obj.c.right);
          equals(obj.c.left);
      }
      return result;
   }

   /**
    * prints out a binary tree in order
    * Input: binary tree
    * Output: none
    */
   private static void printtree(btNode t)
   {
      if (t!=null)
      {
          printtree(t.left);
          System.out.print(t.info);
          if(t.amount > 1){
            System.out.println("(" + t.amount + ")");
          }else{
            System.out.println();
          }
          printtree(t.right);
      }
   }

   /**
    * converts the contents of btNode t into a sorted array a
    * Input: the tree being copied, an array to store the tree in, an integer
    * Output: an integer
    */
   private static int toarray(btNode t, String[] a, int[] b, int i)
   {
      int num_nodes=0;
      if (t!=null)
      {
         num_nodes=toarray(t.left, a, b, i);
         a[num_nodes+i]=t.info;   
         b[num_nodes+i]=t.amount;
         num_nodes=num_nodes+1+toarray(t.right, a, b, num_nodes+i+1);
      }
      return num_nodes;
   }

   private static class btNode
   {
       String info; btNode left; btNode right;
       int amount;

       private btNode(String s, int a, btNode lt, btNode rt)
       {
          info=s; amount=a; left=lt; right=rt;  
       }

       private btNode()
       {
          info=""; amount=0;left=null; right=null;
       }
   }
}
