import java.util.*;

// implementation of a FIFO queue
public class Queue{
	LinkedList<Integer> l;

	public Queue(){
		l = new LinkedList();
	}

	public int dequeue(){
		int temp = l.getFirst();
		l.removeFirst();
		return temp;
	}

	public void enqueue(int i){
		l.addLast(new Integer(i));
	}

	public int peek(){
		return l.getFirst().intValue();
	}

	public boolean isEmpty(){
		return (l.isEmpty());
	}

	public String toString(){
		StringBuilder s = new StringBuilder();
		for(int i:l){
			s.append(i);
			s.append(' ');
		}
		return s.toString();
	}

}