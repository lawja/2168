import java.util.Arrays;

public class HeapSortDemo
{
    public HeapSortDemo()
    {
        int[] a = {30, 3, 7, 15, 20, 100, 25, 80, 10, 90, 17, 40, 5};
        int i; 
        for (i=0; i<a.length; i++)  System.out.println(a[i]);
        heapsort(a);
        System.out.println("Sorted:");
        for (i=0; i<a.length; i++) System.out.println(a[i]);
    }

    public static void main(String[] args)
    {
        HeapSortDemo H=new HeapSortDemo();
    }
    
    public void heapsort(int[] a)
    {
       int last=a.length; int i;
       System.out.println("MS: " + Arrays.toString(a));
       for (i=last/2; i>0; i--) maxshift(a, i, last);
       for (i=1; i<a.length; i++)
       {
          int x=a[last-1]; a[last-1]=a[0]; a[0]=x;
          last--; maxshift(a, 1, last);
       }
    }

    public static void maxshift(int[] a, int i, int last)
    {
        int j=2*i; int x=a[i-1];

        if ((j<last)&&(a[j]>a[j-1])) j++;
        while((j<=last)&&(a[j-1]>x))
        {
            a[i-1]=a[j-1]; i=j; j=2*j;
            if ((j<last)&&(a[j]>a[j-1])) j++;
        }
        a[i-1]=x; 
        System.out.println("MS: " + Arrays.toString(a));
    }
}
