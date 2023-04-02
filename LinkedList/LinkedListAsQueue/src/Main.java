public class Main {
    static class Node{
        int data;
        Node next;
    }
    static class LinkedList{
        Node head;
        Node tail;
        int size;

        void add(int data){
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

        int remove(){
            Node tmp = head;
            head = head.next;
            size--;
            return tmp.data;
        }

        int size(){
            return size;
        }

        int peek(){
            return head == null ? -1 : head.data;
        }

        void displayList(Node head){
            System.out.print("Queue after all the operations: ");
            Node tmp = head;
            while(tmp != null){
                System.out.print(tmp.data+" ");
                tmp = tmp.next;
            }
        }
    }
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(10);
        list.add(20);
        System.out.println(list.remove());
        list.add(100);
        System.out.println(list.size());
        System.out.println(list.peek());
        list.displayList(list.head);
    }
}