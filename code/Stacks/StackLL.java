import java.util.*;

// implementation of a LIFO stack, LinkedList based
public class StackLL{
	LinkedList<Integer> l;
	int capacity;

	public StackLL(){
		l = new LinkedList<Integer>();
		capacity = 50;
	}

	public StackLL(int i){
		l = new LinkedList<Integer>();
		capacity = i;
	}

	public void push(int i){
		l.addFirst(new Integer(i));
	}

	public int pop(){
		Integer i = l.getFirst();
		l.removeFirst();
		return i.intValue();
	}

	public int peek(){
		return (l.getFirst()).intValue();
	}

	public int size(){
		return l.size();
	}

	public boolean isEmpty(){
		return l.peek() == null;
	}

	public boolean isFull(){
		return l.size() == capacity;
	}

	public String toString(){
		ListIterator<Integer> I = l.listIterator();
		StringBuilder builder = new StringBuilder();
		int i = 0;
		while(I.hasNext()){
			Integer m = I.next();
			System.out.println("[" + m.intValue() + "]");
		}

		return builder.toString();

	}


}
