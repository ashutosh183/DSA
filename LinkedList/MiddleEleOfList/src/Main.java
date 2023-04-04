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

        int middleOfTheList(Node head){
            Node slow = head;
            Node fast = head;
            while(fast.next != null && fast.next.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow != null ? slow.data : -1;
        }
    }
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);
        list.addLast(60);
        int x = list.middleOfTheList(list.head);
        System.out.println(x);
    }
}