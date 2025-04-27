package week5;
public class Node<T> {
    // Components of the Node
    public T element;
    public Node<T> next;

    // Default constructor
    public Node() {
        this.element = null;
        this.next = null;
    }

    // Constructor that accepts an item
    public Node(T element) {
        this.element = element;
        this.next = null;
    }
}
