import java.util.*;

public class stacks{
	public static void main(String[] args){
		Stack s = new Stack(50);

		s.push(4);
		s.push(82);
		s.push(93);
		System.out.println(s.size());
		System.out.println(s.empty());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.size());
		System.out.println(s.empty());
	}
}