public class LinkedList {

    Node head;
    class Node
    {
        int data;
        Node next;

        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    public void push(int new_value)
    {
        Node new_node = new Node(new_value);
        new_node.next = head;
        head = new_node;
    }

    public void insertAt(Node prev_node, int new_value)
    {
        if(prev_node == null)
        {
            System.out.println("Previous node is empty");
            return;
        }
        Node new_node = new Node(new_value);
        new_node.next = prev_node.next;
        prev_node = new_node;
    }


    public void append(int new_value)
    {
        Node new_node = new Node(new_value);
        if(head == null)
        {
            head = new Node(new_value);
            return;
        }
        
        new_node.next = null;

        Node last = head;
        while(last.next != null)
        {
            last = last.next;
        }

        last.next = new_node;
        return;
    }

    //delete the data

    public void delete(int key)
    {
        Node temp = head, prev = null;
        if(temp != null && temp.data == key)
        {
            head =temp.next;
            return;
        }


        while(temp !=  null && temp.data != key)
        {
            prev = temp;
            temp = temp.next;
        }

        if(temp == null)
            return;

        prev.next = temp.next;
    }

    public void printlist()
    {
        Node temp = head;
        while(temp !=  null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    public static void main(String[] args)
    {
        LinkedList llist = new LinkedList();
        llist.append(10);
        llist.push(20);
        llist.push(30);
        llist.push(50);
        llist.append(5);
        llist.printlist();
    }
    
}