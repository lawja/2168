import java.util.*;
import java.lang.Math;

public class HashTable{
	private LinkedList<Integer>[] table;

	public HashTable(int capacity){
		table = new LinkedList[capacity];
		for(int i = 0; i < capacity; i++){
			table[i] = new LinkedList();
		}
	}

	public void add(int i){
		int index = getHash(i);
		table[index].addFirst(new Integer(i));
	}

	public void remove(int i){
		if(contains(i)){
			table[getHash(i)].remove(new Integer(i));
		}
	}

	public void print(){
		for(int i = 0; i < table.length; i++){
			ListIterator<Integer> I = table[i].listIterator();
			while(I.hasNext()){
				Integer m = I.next();
				System.out.print("[" + i + "]:" + m.intValue());
				System.out.print(", ");
			}
		}
		System.out.println();
	}

	public boolean contains(int i){
		return table[getHash(i)].contains(i);
	}

	public int search(int i){
		if(contains(i)){
			return getHash(i);
		}else{
			return -1;
		}
	}

	public int key(int i){
		return getHash(i);
	}

	private int getHash(int i){
		return i % table.length;
	}
}