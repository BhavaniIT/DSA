public class SinglyLinkedList {
	Node head;
	public void add(int val)
	{
		Node node = new Node();
		node.data = val;
		node.next = null;
		if(head == null)
		{
			head = node;
		}
		else
		{
			Node temp = head;
			while(temp.next!= null)
			{
				 temp = temp.next;
			}
			temp.next = node; 
		}
	}
	
	public void show()
	{
		Node temp = head;
		while(temp!=null)
		{
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

}
