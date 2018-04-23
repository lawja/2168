import java.util.*;

public class stacks{
	public static void main(String[] args){
		int c = 20;
		Stack s = new Stack(c);

		Random r = new Random();

		long begin = System.currentTimeMillis();
		for(int i = 0; !(s.isFull()); i++){

			s.push(r.nextInt(5000)+1);
		}
		s.pop();
		s.peek();
		s.isEmpty();

		s.print();
		long end = System.currentTimeMillis();

		System.out.println("Time elapsed: " + (end - begin)  + "ms");
	}
}