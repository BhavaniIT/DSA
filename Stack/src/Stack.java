
public class Stack {
	
	int capacity = 2;
	int[] stack = new int[capacity];
	int top = 0;

	public void push(int data)
	{
		if(size() == capacity)
			expand();
		stack[top++] = data;
	}
	
	public int pop()
	{
		int data = 0;
		if(isEmpty())
		{
			System.out.println("Stack is Empty");
		}
		else
		{
			if(size() <= (capacity/2)/2)
				shrink();
			data = stack[--top];
		}
		return data;
		
	}
	
	public void show()
	{
		if(isEmpty())
			System.out.println("No data");
		else
		{
			for(int i=size()-1; i>=0; i--)
				System.out.print(stack[i]+ " ");
			System.out.println();
		}
		
		
	}
	
	public boolean isEmpty()
	{
		return size() == 0;
	}

	
	public void expand()
	{
		int[] newStack = new int[capacity*2];
		int length = size();
		System.arraycopy(stack, 0, newStack, 0, length);
		capacity = capacity*2;
		stack = newStack;
	}
	
	
	
	public int peek()
	{
		return stack[top-1];
	}
	
	public int size()
	{
		return top;
	}
	
	public void shrink()
	{
		int[] newStack = new int[capacity/2];
		int length = size();
		System.arraycopy(stack, 0, newStack, 0, length);
		capacity = capacity/2;
		stack = newStack;
		
	}
}
