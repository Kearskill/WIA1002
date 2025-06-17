package pastyears.paper2016;

public class Queue<E> {
    private static class Node<E>{
        E data;
        Node next;

        Node(E data){
            this.data = data;
        }
    }

    private Node<E> front, rear;
    private int size;

    public Queue(){
        front = rear = null;
        size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public E peek(){
        if (isEmpty()){
            throw new RuntimeException("Queue is empty.");
        }
        return front.data;
    }

    public void enqueue(E data){
        Node newNode = new Node(data);
        if (isEmpty()){
            front = rear = newNode;
        } else{
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public E dequeue(){
        if (isEmpty()){
            throw new RuntimeException("Queue is empty.");
        }
        E data = front.data;
        front = front.next;
        if (front == null){
            rear =null;
        }
        size--;
        return data;
    }

    public void changeOrder(int k){
        if (k>size|| k<=0){
            throw new IllegalArgumentException("Invalid value of k.");
        }

        for (int i = 1; i < k; i++) { // k - 1 elements
            // move k-1 elements from front to rear
            E temp = dequeue();
            enqueue(temp);
        }

    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node current = front;
        while(current != null){
            sb.append(current.data).append(" ");
            current = current.next;
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        /*Create a test program to fill the queue with the following values [10,20,30,40,50,60,70,80,90].
        Call the ChangeOrder method to illustrate your implementation. Print all of
        the values.*/

        Queue<Integer> queue = new Queue<>();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60);
        queue.enqueue(70);
        queue.enqueue(80);
        queue.enqueue(90);

        System.out.println(queue);

        queue.changeOrder(4);
        System.out.println("\nAfter changing order with k = 4");
        System.out.println(queue);

    }
}
