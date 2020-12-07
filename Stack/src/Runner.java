
public class Runner {

	public static void main(String[] args) {
		
		Stack stack = new Stack();
		stack.push(5);
		stack.push(15);
		stack.show();
		stack.push(25);
		stack.push(35);
		stack.show();
		stack.push(45);
		stack.show();
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		stack.show();
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		stack.show();
		System.out.println(stack.pop());
		stack.show();
		System.out.println(stack.pop());
	}

}
