class Node{
    int data;
    Node prev;
    Node next;
    Node(int data){
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private void insert(int[] data){
        if(data.length == 0) throw new IllegalArgumentException("List is empty");
        int index = 0;
        if(head == null){
            index = 1;
            head = new Node(data[0]);
            tail = head;
        }
        Node curr = tail;
        for(int i = index; i<data.length; i++){
            Node newNode = new Node(data[i]);
            curr.next = newNode; //Link the currentNode to the new node
            newNode.prev = curr; //Link the previous node to the new node
            curr = curr.next; //Move the currentNode to the new node
        }
        tail = curr;
        System.out.println("Values are inserted successfully");
    }
    private void printList(){
        if(head == null){
            System.out.println("List is empty");
            return;
        } 
        Node curr = head;
        StringBuilder sb = new StringBuilder();
        while(curr != null){
            sb.append(curr.data);
            if(curr.next != null) sb.append("<=>");
            curr = curr.next;
        }
        System.out.println(sb.toString()); //Printing the list
        System.out.println("tail:"+tail.data);
    }

    private void reverse(){
        if(head == null || head.next == null)  throw new IllegalArgumentException("Cannot reverse the list");
        Node curr = head;
        Node temp = null;
        
        while(curr != null){
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            curr = curr.prev;
        }
        tail = head;
        head = temp.prev;
        System.out.println("List reversed successfully");
    }
    public static void main(String[] args) {
        DoublyLinkedList dl = new DoublyLinkedList();
        dl.insert(new int[]{1,2,3,4,5});
        dl.printList();
        dl.reverse();
        dl.printList();
    }
    
}