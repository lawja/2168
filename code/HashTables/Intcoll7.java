public class Intcoll7
{
   private int howmany;
   private int[] c;

   public Intcoll7()
   {
      c = new int[997];
      howmany = 0;
   }

   public Intcoll7(int i)
   {
      double t = (i/.7)+1;
      int k=(int) t;
      while(!isprime(k)) k--;
      c = new int[k];
      howmany = 0;
   }

   public void insert(int i)
   {
      int h=i%c.length; int H=h;
   
      if (c[h]==0) {c[h]=i; howmany++;}
      else if (c[h]==i) ;      
      else
      {
         if (h<c.length-1) h++; else h=0;         
         while ((h!=H)&&(c[h]!=0)&&(c[h]!=i)) 
         {
             if (h<c.length-1) h++; else h=0;
         } 
         if (h!=H) {if (c[h]==0) {c[h]=i; howmany++;}} 
         else {System.out.println("Table Full"); System.exit(1);}
      }
   }

   public int get_howmany(){
      return howmany;
   }

   private static boolean isprime(int num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i += 2)
            if (num % i == 0) return false;
        return true;
}

}
