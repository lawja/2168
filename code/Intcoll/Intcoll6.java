//***********************************************************************
// FILE NAME    : Intcoll6.java
// DESCRIPTION  : This file contains the class Intcoll6.
//************************************************************************

import java.util.*;
import java.io.*;

public class Intcoll6
{
   private int howmany;
   private btNode c;

   public Intcoll6()
   {
      c = null;
      howmany = 0;
   }

   public Intcoll6(int i)
   {
      c = null;
      howmany = 0;
   }

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

   public void copy(Intcoll6 obj)
   {
      if (this!=obj)
      {
          howmany=obj.howmany;
          c=copytree(obj.c);  
      }
   }

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
                btNode l = p;
                l = p.left;
                btNode pred_l = null;
                while((l != null)){
                  pred_l = l;
                  l = l.right;
                }
                p.info = pred_l.info;
                pred_l = pred_l.left;
            }
         }
      }    

   }

   public boolean belongs(int i)
   {
      btNode p=c;
      while ((p!=null)&&(p.info!=i)) 
      {
         if (p.info>i) p=p.left;
         else p=p.right;
      }
      return (p!=null); 
   }

   public int get_howmany() {return howmany;}

   public void print()
   {
      printtree(c);
   }

   public boolean equals(Intcoll6 obj)
   {
      int j = 0; boolean result  = (howmany==obj.howmany);
      if (result)
      { 
 
          //Missing
         
      }
      return result;
   }

   private static void printtree(btNode t)
   {
      if (t!=null)
      {
          printtree(t.left);
          System.out.println(t.info);
          printtree(t.right);
      }
   }

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
