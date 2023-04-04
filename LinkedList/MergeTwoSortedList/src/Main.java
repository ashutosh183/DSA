public class Main {
    static class Node{
        int data;
        Node next;
    }
    static class LinkedList{
        Node head;
        Node tail;
        int size = 0;
        void addLast(int data){
            Node tmp = new  Node();
            tmp.data = data;
            tmp.next = null;
            if(head == null){
                head = tail = tmp;
            }else{
                tail.next = tmp;
                tail = tmp;
            }
            size++;
        }

        void displayList(Node head){
            Node tmp = head;
            while(tmp != null){
                System.out.print(tmp.data+" ");
                tmp = tmp.next;
            }
        }
    }
    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.addLast(10);
        list1.addLast(20);
        list1.addLast(30);

        LinkedList list2 = new LinkedList();
        list2.addLast(11);
        list2.addLast(19);
        list2.addLast(31);

        list1.head = MergeSortedList(list1.head, list2.head);

        System.out.println("Display the merge sorted list: ");
        list1.displayList(list1.head);

    }
    public static Node MergeSortedList(Node head1, Node head2){
        Node dummy = new Node();
        dummy.data = -1;
        dummy.next = null;
        Node tailPtr = dummy;

        while(head1 != null && head2 != null){
            if(head1.data <= head2.data){
                tailPtr.next = head1;
                head1 = head1.next;
            }else{
                tailPtr.next = head2;
                head2 = head2.next;
            }
            tailPtr = tailPtr.next;
            
        }
        if(head1 == null){
            tailPtr.next = head1;
        }
        if(head2 == null){
            tailPtr.next = head2;
        }
        return dummy.next;
    }

}