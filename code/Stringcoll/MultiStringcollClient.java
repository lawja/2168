//**********************************************************
// FILE: NAME   : Stringcollclient.java
// DESCRIPTION  : This is a client of class Stringcoll.
// Christopher Lawrence 2.23.17
//**********************************************************

import java.util.*;

public class MultiStringcollClient
{
   public static final String SENTINEL = "###";

   public static void main(String[] args)
   {
      String input; Scanner keyboard=new Scanner(System.in);
      MultiStringcoll P=new MultiStringcoll(6), N=new MultiStringcoll(6), L= new MultiStringcoll(6);

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

      String temp = "hello";

      System.out.println("\n\"" + temp + "\" occurs " + P.belongs(temp) + " times in P");
      System.out.println("There are " + P.get_howmany() + " distinct strings in P");
      System.out.println("There are " + P.get_total() + " total strings in P");

      if (P.equals(L)) System.out.println("\nP and L are equal.");
      else System.out.println("\nP and L are NOT equal.");

      MultiStringcoll A=new MultiStringcoll(); A.copy(L);
      System.out.println("\nThe inputs in the copy of L are:\n");
      A.print();
   }
}
