import java.util.*;

public class QueueTester{
	public static void main(String[] args){
		Queue q = new Queue();

		/*
		Random r = new Random();
		for(int i = 0;i < 10;i++){
			q.enqueue(r.nextInt(100)+1);
		}*/
		System.out.println(q.isEmpty());
		q.enqueue(6);
		q.enqueue(9);
		q.enqueue(2);
		q.enqueue(11);
		System.out.println(q);
		System.out.println(q.isEmpty());
	}
}