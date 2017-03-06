import java.util.*;

public class StackLL{
	LinkedList<Integer> l;
	int size, top;

	public StackLL(){
		l = new LinkedList<Integer>();
	}

	public StackLL(int i){
		l = new LinkedList<Integer>();
	}

	public void push(int i){
		l.addFirst(i);

	}

	public int pop(){
		if(top != size){
			int i = top;
			top++;
			return a[i];
		}else{
			System.out.println("Overflow");
			return -1;
		}
	}

	public int peek(){
		if(top != size){
			return a[top];
		}else{
			return -1;
		}
	}

	public int size(){
		return (size - top);
	}

	public boolean empty(){
		return (top == size);
	}


}