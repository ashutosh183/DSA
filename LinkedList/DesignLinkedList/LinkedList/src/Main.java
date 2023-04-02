public class Main {
    static class Node {
        int data;
        Node next;
    }

    static class LinkedList {
        Node head;
        Node tail;
        int size = 0;


        void addLast(int data){
            Node tmp = new Node();
            tmp.data = data;
            tmp.next = null;
            if(head == null){
                head = tail = tmp;
            }else {
                tail.next = tmp;
                tail = tmp;
            }
             size++;
        }

        void displayList(Node head){
            Node tmp = head;
            while(tmp != null){
                if (tmp.next != null) {
                    System.out.print(tmp.data + " ---> ");
                }else{
                    System.out.print(tmp.data);
                }
                tmp = tmp.next;
            }
        }

        int size(){
            return size;
        }

    }
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.size();
        list.displayList(list.head);
    }
}