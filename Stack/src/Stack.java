
public class Stack {
	
	int capacity = 2;
	int[] stack = new int[capacity];
	int top = 0;

	public void push(int data)
	{
		stack[top] = data;
	}
	
	public void show()
	{
		System.out.println(stack[top]);
	}
}
