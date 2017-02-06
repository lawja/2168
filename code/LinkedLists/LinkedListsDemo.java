import java.util.*;

public class LinkedListsDemo
{
    public static void main(String[] args)
    {
        LinkedList<Integer> Integerlist=new LinkedList<Integer>();
        LinkedList<String>  Stringlist=new LinkedList<String>();
        LinkedList<String> S=new LinkedList<String>();
        int i=1;
        while (i<=10)
        {
           Integerlist.add(new Integer(i));
           i++;
        }   
        System.out.println();
	System.out.println("Integerlist has "+Integerlist.size()+" integers.");
	if (Integerlist.contains(new Integer(5)))
           System.out.println("Integerlist contains 5");
	else 
	   System.out.println("Integerlist does not contain 5");
        Integerlist.remove(new Integer(5));
	if (Integerlist.contains(new Integer(5)))
           System.out.println("Integerlist contains 5");
	else 
	   System.out.println("Integerlist does not contain 5");		
	System.out.println("Integerlist has "+Integerlist.size()+" integers.");
	System.out.println();
	Integerlist.add(new Integer(5));
        ListIterator<Integer> I=Integerlist.listIterator();
        while (I.hasNext())
        {
           Integer n = I.next();
           System.out.println(n.intValue());
        }
        I=Integerlist.listIterator();
        while (I.hasNext())
        {
           Integer m = I.next();
           Integer n = new Integer(2*m.intValue());
           I.set(n); I.add(m); 
        }
        System.out.println();
        I=Integerlist.listIterator();
        while (I.hasNext())
        {
           Integer n = I.next();
           System.out.println(n.intValue());
        }

	I=Integerlist.listIterator();
        while (I.hasNext())
        {
           Integer m = I.next();
           if (m.intValue()>10)
 	       I.remove();
        }
        System.out.println();
        I=Integerlist.listIterator();
        while (I.hasNext())
        {
           Integer n = I.next();
           System.out.println(n.intValue());
        }
        Stringlist.add("Hello"); Stringlist.add("Goodby");
        Stringlist.addFirst("ABC");
        System.out.println();
        ListIterator<String> J=Stringlist.listIterator();
        while (J.hasNext())   
        {
           String s = J.next();
           System.out.println(s);
        }
        J=Stringlist.listIterator();
        while (J.hasNext())
        {
           String s = J.next(); 
           S.add(s);           
        }
        System.out.println();
        J=S.listIterator();
        while (J.hasNext())
        {
           String s = J.next(); 
           System.out.println(s);           
        }
        System.out.println("DONE");
    }
}

