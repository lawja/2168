
//**********************************************************
// FILE: NAME   : Stringcollclient.java
// DESCRIPTION  : This is a client of class Stringcoll.
// Christopher Lawrence 2.23.17
//**********************************************************

import java.util.*;

public class Stringcollclient
{
   public static final String SENTINEL = "###";

   public static void main(String[] args)
   {
      String input; Scanner keyboard=new Scanner(System.in);
      Stringcoll P=new Stringcoll(6), N=new Stringcoll(6), L= new Stringcoll(6);

      System.out.println("Enter an String to be inserted or 0 to quit:");
      input=keyboard.nextLine();
      while(!(input.equals(SENTINEL)))
      {
         if (input.charAt(0) == '+') {P.insert(input.substring(1)); L.insert(input.substring(1));}
         else if(input.charAt(0) == '-') {N.insert(input.substring(1)); L.omit(input.substring(1));}
         System.out.println("Enter next integer to be inserted or 0 to quit:");
         input=keyboard.nextLine();
      }
      System.out.println("\nThe inputs in collection P are:");
      P.print();
      System.out.println("\nThe inputs in collection N are:");
      N.print();
      System.out.println("\nThe inputs in collection L are:");
      L.print();

      if (P.equals(L)) System.out.println("\nP and L are equal.");
      else System.out.println("\nP and L are NOT equal.");
      Stringcoll A=new Stringcoll(); A.copy(L);
      System.out.println("\nThe inputs in the copy of L are:\n");
      A.print();

      String x = "test";
      if(P.belongs(x))
         System.out.println("\n" + x + " is in collection P");
      else
         System.out.println("\n" + x + " is not in collection P");
   }
}
