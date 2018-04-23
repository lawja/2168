import java.util.*;

public class HashTableTest{
	public static void main(String[] args){
		HashTable h = new HashTable(997);
		Random r = new Random();
		int x = 1000000;
		System.out.println("Inserting " + x + " integers to the hash table.");
		long begin = System.currentTimeMillis();
		for(int i = 0; i < x; i++){
			h.add(r.nextInt(10000000) + 1);
		}
		long end = System.currentTimeMillis();
		System.out.println("Time elapsed: " + (end - begin) + "ms");
	}
}