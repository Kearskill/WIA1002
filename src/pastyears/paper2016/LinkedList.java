package pastyears.paper2016;

import java.util.regex.Pattern;

public class LinkedList {
    private static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    private Node head = null;

    public void add(int data){
        Node newNode = new Node(data);

        if (head == null){
            head = newNode;
            System.out.println("Adding: "+ head.data);
            return;
        }

        Node current = head;
        while (current.next!=null){ // traverse
            current = current.next;
        }

        current.next = newNode;
        System.out.println("Adding: " + data);
    }

    public void addAfter(int data, int target){
        Node current = head;

        while (current!= null && current.data != target){
            current = current.next;
        }

        if (current != null){
            Node newNode = new Node(data);
            newNode.next = current.next;
            current.next = newNode;
            System.out.println("Adding "+ data + " after "+ target);
        } else{
            System.out.println("Element "+ target +" not found.");
        }

    }

    public void deleteFront(){
        if (head!= null){
            System.out.println("Deleting front: " + head.data);
            head = head.next;

        } else{
            System.out.println("LinkedList is empty.");
        }

    }

    public void deleteAfter(int target){
        Node current = head;

        System.out.println("Testing deleteAfter: ");
        while (current != null && current.data != target){
            current = current.next;
        }

        if (current != null && current.next != null){
            System.out.println("After " + target + " is " + current.next.data+". Deleting " + current.next.data);
            current.next = current.next.next;
        } else if (current == null){
            System.out.println("Element (" + target + ") not found.");
        } else{
            System.out.println("No element exists after "+ target + ".");
        }
    }

    public void traverse(){
        Node current = head;
        System.out.println("Showing content of my linked list: ");
        while (current!=null){
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList s1 = new LinkedList();

        s1.add(10);
        s1.add(20);
        s1.add(30);
        s1.add(40);
        s1.add(50);
        s1.addAfter(11, 10);
        s1.addAfter(21, 20);
        s1.addAfter(31, 30);
        s1.addAfter(41, 40);
        s1.addAfter(51, 50);
        System.out.println();
        s1.traverse();
        System.out.println();
        s1.deleteFront();
        System.out.println();
        s1.deleteFront();
        System.out.println();
        s1.traverse();
        System.out.println();
        s1.deleteAfter(40);
        System.out.println();
        s1.deleteAfter(40);
        System.out.println();
        s1.deleteAfter(31);
        System.out.println();
        s1.deleteAfter(40);
        System.out.println();
        s1.traverse();

    }
}
