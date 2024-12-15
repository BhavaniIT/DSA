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
    private void insert(int[] data){
        int index = 0; 
        if(data.length == 0) {
            System.out.println("Provided data are empty");
            return;
        }
        if(head == null){
            index = 1; //If head is null update index
            head = new Node(data[0]);
        }
        Node curr = head;
        while(curr.next != null) curr = curr.next;
        for(int i=index; i<data.length; i++){
            curr.next = new Node(data[i]);
            curr = curr.next;
        }
        System.out.println("Value inserted");
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
    public static void main(String[] args) {
        SinglyLinkedList sl = new SinglyLinkedList();
        sl.insert(new int[]{5,6,7,8});
        System.out.println(sl.printList());
        sl.insert(new int[]{2,1,-9, -8});
        System.out.println(sl.printList());
    }
}
