
//**********************************************************
// FILE: NAME   : Intcoll6client.java
// DESCRIPTION  : This is a client of class Intcoll6.
// Christopher Lawrence 2.16.17
//**********************************************************

import java.util.*;

public class Intcoll6client
{
   public static final int SENTINEL = 0;

   public static void main(String[] args)
   {
      int value; Scanner keyboard=new Scanner(System.in);
      Intcoll6 P=new Intcoll6(5), N=new Intcoll6(5), L= new Intcoll6(5);

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
      Intcoll6 A=new Intcoll6(); A.copy(L);
      System.out.println("\nThe values in the copy of L are:\n");
      A.print();

      int x = 5;
      if(P.belongs(x))
         System.out.println("\n" + x + " is in collection P");
      else
         System.out.println("\n" + x + " is not in collection P");

      System.out.println("Sum of P -> " + P.sum());
   }
}
