public class Main {
    static class Node{
        int data;
        Node next;
    }

    static class LinkedList{
        Node head;
        Node tail;
        int size = 0;

        void push(int data){
            Node tmp = new Node();
            tmp.next = head;
            tmp.data = data;
            head = tmp;
            size++;
        }

        int pop(){
            Node tmp = head;
            head = head.next;
            size--;
            return tmp.data;
        }

        int size(){
            return size;
        }

        int top(){
            return head.data;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.push(10);
        list.push(20);
        System.out.println(list.pop());
        System.out.println(list.size());
        list.push(30);
        list.push(40);
        System.out.println(list.top());
        System.out.println(list.size());
    }
}