package week5;
public class testNode {
    public static void main(String[] args) {
        Node<Character> firstNode = new Node<>('A');
        Node<Character> secondNode = new Node<>('b');
        firstNode.next = secondNode;
    }
}
