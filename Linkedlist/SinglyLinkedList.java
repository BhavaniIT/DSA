class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}
public class SinglyLinkedList {
    private Node head;
    private Node tail;
    private int length;
    private void insert(int[] data){
        int index = 0; 
        if(data.length == 0) {
            System.out.println("Provided data are empty");
            return;
        }
        if(tail == null){
            index = 1; //Tail is null -> Head is empty
            head = new Node(data[0]);
            tail = head;
            length++;
        }
        Node curr = tail; //Start inserting from last node
        for(int i=index; i<data.length; i++){
            curr.next = new Node(data[i]);
            curr = curr.next;
            length++;
        }
        //Update tail to keep track of last node
        tail = curr;
        System.out.println("Value inserted");
    }

    private void delete(int data){
        if(head == null) return;
        if(head.data == data){
            head = head.next;
            length-- ;
            return; //If head has the data change head to next
        }
        Node curr = head;
        while(curr.next != null){
            if(curr.next.data == data){
                System.out.println("Found:" + curr.next.data);
                curr.next = curr.next.next;
                length-- ;
                System.out.println("Replaced:"+curr.data);
                return;
            }
            curr = curr.next;
        } 
        System.out.println("Data not found");
    }

    private String printList(){
        StringBuilder list = new StringBuilder();
        if(head == null) return "The list is empty";
        Node curr = head;
        while(curr != null){
            list.append(curr.data);
            if(curr.next != null) list.append("->");
            curr = curr.next;
        }
        return list.toString();
    }

    private boolean search(int data){
        if(head == null) return false;
        Node curr = head;
        while(curr != null){
            if(curr.data == data) return true;
            curr = curr.next;
        }
        return false;
    }

    private boolean hasLoop(){
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }

    private String findMiddle(){
        if(head == null) return "List is empty";
        if(hasLoop())  return "Loop in the list, can't find middle";
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return "Middle element is:"+slow.data;
    }
    private void reverse(){
        if(head == null || head.next == null){
            System.out.println("List is empty or List has only one element");
            return;
        }
        Node curr = head;
        Node prev = null,next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }
        head = prev;
    }

    private int getLength(){
        return length;
    }
    public static void main(String[] args) {
        SinglyLinkedList sl = new SinglyLinkedList();
        sl.insert(new int[]{5,6,7,8});
        System.out.println(sl.printList());
        sl.insert(new int[]{2,1,-9, -8});
        System.out.println(sl.printList());
        System.out.println(sl.getLength());
        System.out.println("Searching 1: "+sl.search(1));
        System.out.println("Searching -1: "+sl.search(-1));
        sl.delete(5); //deleting head
        sl.delete(8);
        sl.delete(8);
        System.out.println(sl.printList());
        System.out.println(sl.findMiddle());
        sl.reverse();
        System.out.println(sl.printList());
        
    }
}
