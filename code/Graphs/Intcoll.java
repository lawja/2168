//***********************************************************************
// FILE NAME    : Intcoll.java
// DESCRIPTION  : This file contains the class Intcoll.
//************************************************************************

import java.util.*;
import java.io.*;

public class Intcoll
{
   private int howmany;
   private btNode c;

   /**
    * makes an empty collection
    */
   public Intcoll()
   {
      c = null;
      howmany = 0;
   }

   /**
    * makes an empty collection
    * Input: capacity of the collection
    * Output: none
    */
   public Intcoll(int i)
   {
      c = null;
      howmany = 0;
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
   public void copy(Intcoll obj)
   {
      if (this!=obj)
      {
          howmany=obj.howmany;
          c=copytree(obj.c);  
      }
   }

   /**
    * inserts i into the collection unless it is full or already in the collection
    * Input: value that is inserted into the collection
    * Output: none
    */
   public void insert(int i)
   {
      if (i>0)
      {
         btNode pred=null, p=c;

         while ((p!=null)&&(p.info!=i))
         {
             pred=p;
      	     if (p.info>i) p=p.left;
      	     else p=p.right;
         }
         if (p==null)
         {
            howmany++; p=new btNode(i, null, null);
            if (pred!=null)
            {
    	       if (pred.info>i) pred.left=p;
                   else pred.right=p;
	          }
	          else c=p;
         }
      }
   }

   /**
    * removes i from the collection if it is in the collection
    * Input: the value that is removed from the collection if in the collection
    * Output: none
    */
   public void omit(int i)
   {
      if (i>0)
      {
         btNode pred=null, p=c;

         while ((p!=null)&&(p.info!=i))
         {
             pred=p;
             if (p.info>i) p=p.left;
             else p=p.right;
         }

         if(p != null){
            howmany--;
            if((p.left == null) && (p.right == null)){
              if(pred == null){
                c = null;
              }else{
                if(i > pred.info)
                  pred.right = null;
                else
                  pred.left = null;
              }
            }else if((p.left == null) && (p.right != null)){
              if(pred == null){
                c = p.right;
              }else{
                if(i > pred.info)
                  pred.right = p.right;
                else
                  pred.left = p.right;
              }
            }else if((p.left != null) && (p.right == null)){
              if(pred == null){
                c = p.left;
              }else{
                if(i > pred.info)
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
                if (l.info == p.info) 
                  l.left = pred.left;
                else 
                  l.right = pred.left;
            }
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
      btNode p=c;
      int a[] = new int[howmany];
      toarray(p,a,0);
      int left = 0, right = howmany - 1;
      int middle = right / 2;
      while(right >= left){
          if(a[middle] == i)
            return true;
          else if(a[middle] > i)
            right = middle - 1;
          else if(a[middle] < i)
            left = middle + 1;
          middle = (left + right)/2;
      }
      return false;
   }

   /**
    * returns how many integers are in the collection
    * Output: an integer
    */
   public int get_howmany() {return howmany;}

   /**
    * print all values within the collection
    */
   public void print()
   {
      printtree(c);
   }

   /** 
    * returns true if if the integers in the collection are exactly the same
    * as the integers in obj's collection
    * Input: object that is being compared to the called upon object
    * Output: true or false
    */
   public boolean equals(Intcoll obj)
   {
      int j = 0; boolean result  = (howmany==obj.howmany);
      if (result)
      { 
        result = belongs(obj.c.info);
        equals(obj.c.left);
        equals(obj.c.right);        
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
          System.out.println(t.info);
          printtree(t.right);
      }
   }

   private static int sumtree(btNode t){
      if(t == null)
        return 0;
      int right = sumtree(t.right);
      int left = sumtree(t.left);
      return t.info + right + left;
   }

   public int sum(){
      return sumtree(c);
   }

   /**
    * converts the contents of btNode t into a sorted array a
    * Input: the tree being copied, an array to store the tree in, an integer
    * Output: an integer
    */
   private static int toarray(btNode t, int[] a, int i)
   {
      int num_nodes=0;
      if (t!=null)
      {
         num_nodes=toarray(t.left, a, i);
         a[num_nodes+i]=t.info;   
         num_nodes=num_nodes+1+toarray(t.right, a, num_nodes+i+1);
      }
      return num_nodes;
   }

   private static int depth(btNode t){
      if(t == null)
        return 0;
      int left = depth(t.left);
      int right = depth(t.right);
      int max;
      if(left > right)
        max = left;
      else
        max = right;
      return 1 + max;
   }

   public int coll_depth(){
      return depth(c);
   }

   private static class btNode
   {
       int info; btNode left; btNode right;

       private btNode(int s, btNode lt, btNode rt)
       {
          info=s; left=lt; right=rt;  
       }

       private btNode()
       {
          info=0; left=null; right=null;
       }
   }
}
