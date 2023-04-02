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
            System.out.println();
        }

        int size(){
            return size;
        }

        void deleteFirst(){
            if(size == 0){
                System.out.println("List is empty");
            }else if(size == 1){
                head = tail = null;
                size--;
            }else{
                head = head.next;
                size--;
            }
        }

        int getValue(int idx){
            Node tmp = head;
            if(size == 0 || idx < 0 || idx > size){
                return -1;
            }else{
                int i = 0;
                while(i < idx && tmp != null){
                    i++;
                    tmp = tmp.next;
                }
                return tmp.data;
            }
        }

    }
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);
        list.size();
        list.displayList(list.head);
        list.deleteFirst();
        list.displayList(list.head);

        //sending index > size
        System.out.println(list.getValue(5));
        //sending negative index
        System.out.println(list.getValue(-1));
        //sending index with value
        System.out.println(list.getValue(2));
    }
}