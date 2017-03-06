
//**********************************************************
// FILE: NAME   : intcoll3client.java
// DESCRIPTION  : This is a client of class Intcoll3.
// Christopher Lawrence 1.25.17
//**********************************************************

import java.util.*;

public class Intcoll3client
{
   public static final int SENTINEL = 0;

   public static void main(String[] args)
   {
      int value; Scanner keyboard=new Scanner(System.in);
      Intcoll3 P=new Intcoll3(5), N=new Intcoll3(5), L= new Intcoll3(5);

      System.out.println("Enter an integer to be inserted or 0 to quit:");
      value=keyboard.nextInt();
      while(value != SENTINEL)
      {
         if (value > 0) {P.insert(value); L.insert(value);}
         else {N.insert(-value); L.omit(-value);}
         System.out.println("Enter next integer to be inserted or 0 to quit:");
         value=keyboard.nextInt();
      }
      System.out.println("\nThe values in collection P are:");
      P.print();
      System.out.println("\nThe values in collection N are:");
      N.print();
      System.out.println("\nThe values in collection L are:");
      L.print();

      if (P.equals(L)) System.out.println("\nP and L are equal.");
      else System.out.println("\nP and L are NOT equal.");
      Intcoll3 A=new Intcoll3(); A.copy(L);
      System.out.println("\nThe values in the copy of L are:\n");
      A.print();
      int x = 4;
      if(P.belongs(x))
         System.out.println("\n" + x + " is in collection P");
      else
         System.out.println("\n" + x + " is not in collection P");
      System.out.println("Sum of P: " + sum(P));
   }

   public static int sum(Intcoll3 obj){
      int i = 0, j = 0, hm = obj.get_howmany();
      int sum = 0;

      while(j != hm){
         if(obj.belongs(i)){
            sum += i;
            j++;
         }
         i++;
      }
      return sum;
   }
}



















