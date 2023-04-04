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

        int KthEleFromEnd(Node head, int k){
            Node slow = head;
            Node fast = head;
            int i = 0;
            while(i < k){
//                System.out.print(fast.data+" ");
                fast = fast.next;
                i++;

            }
            while(fast != null){
                slow = slow.next;
                fast = fast.next;
            }
            return slow.data;
        }

        void displayList(Node head){
            Node tmp = head;
            while(tmp != null){
                System.out.print(tmp.data+" ");
                tmp = tmp.next;
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        LinkedList list =  new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);
        list.displayList(list.head);
        System.out.println(list.KthEleFromEnd(list.head, 2));
        System.out.println(list.KthEleFromEnd(list.head, 3));
        System.out.println(list.KthEleFromEnd(list.head, 5));

    }
}