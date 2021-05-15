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

    //delete entire linked list

    public void deleteEntireList()
    {
        head = null;
        return;
    }

    //getNode count
    public int getNodeCount(Node node)
    {
        if(node == null)
            return 0;
        return 1+getNodeCount(node.next);
    }

    public int getCount()
    {
        return getNodeCount(head);
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

    public Node reverseLinked(Node node)
    {
        //step 1:
        Node curr = node;
        Node prev = null;
        Node next = null;
        int count = 0;
        while(curr != null)
        {
            //step 2:
            next = curr.next;
            curr.next = prev;

            //step 3:
            prev = curr;
            curr = next;

            System.out.println("reverse:"+count);
            count++;
        }

        head = prev;
        return node;
    }

    public void reverse()
    {
        reverseLinked(head);
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
        llist.reverse();
        llist.printlist();
       // System.out.println(llist.getCount());
        
    }
    
}