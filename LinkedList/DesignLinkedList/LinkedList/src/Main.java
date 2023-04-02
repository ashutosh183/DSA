public class Main {
    static class Node {
        int data;
        Node next;
    }

    static class LinkedList {
        Node head;
        Node tail;
        int size = 0;

        void addFirst(int data){
            Node tmp = new Node();
            if(head == null){
                tmp.data = data;
                tmp.next = null;
                head = tail = tmp;
            }else{
                tmp.data = data;
                tmp.next = head;
                head = tmp;
            }
            size++;
        }
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

        void addAtIndex(int idx, int data){
            if(idx < 0 || idx > size){
                System.out.println("Give a proper index");
            }else if(idx == 0){
                addFirst(data);
            }else if(idx == size){
                addLast(data);
            }else{
                Node node = new Node();
                node.data = data;
                Node tmp = head;
                for(int i=0; i<idx-1; i++){
                    tmp = tmp.next;
                }
                node.next = tmp.next;
                tmp.next = node;
                size++;
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
        list.addFirst(100);
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addFirst(3);
        list.addFirst(2);
        list.addLast(40);
        list.addLast(50);
        list.addFirst(1);
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

        list.addAtIndex(0, 17);
        list.addAtIndex(2, 19);
        list.addAtIndex(10, 110);
        System.out.println(list.size());
        list.displayList(list.head);
    }
}