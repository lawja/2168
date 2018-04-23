// implementation of a LIFO stack, array based
public class Stack{
	int top, size;
	int[] a;
	public Stack(){
		size = 5;
		top = size;
		a = new int[size];
	}

	public Stack(int i){
		size = i;
		top = size;
		a = new int[size];
	}

	public void push(int i){
		if(top != 0){
			top--;
			a[top] = i;
		}else{
			System.out.println("Overflow");
		}
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

	public boolean isEmpty(){
		return (top == size);
	}

	public boolean isFull(){
		return top == size;
	}

	public void print(){
		for(int i = 0; i <)
	}
}