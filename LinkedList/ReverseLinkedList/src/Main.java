public class Main {
    static class Node{
        int data;
        Node next;
    }

    static class LinkedList{
        Node head;
        Node tail;
        int size = 0;

        void addToList(int data){
            Node tmp = new Node();
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
            System.out.println();
        }

        Node reverseListIterative(Node head){
            Node curr = head;
            Node tmp = head;
            Node prev = null;

            while(curr != null){
                tmp = tmp.next;
                curr.next = prev;
                prev = curr;
                curr = tmp;
            }
            head = prev;
            return head;
        }
    }
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addToList(10);
        list.addToList(20);
        list.addToList(30);
        list.addToList(40);
        list.addToList(50);
        list.addToList(60);

        System.out.print("Before reversing the linked list: ");
        list.displayList(list.head);

        System.out.print("After the linked list is reversed: ");
        list.head = list.reverseListIterative(list.head);
        list.displayList(list.head);
    }
}