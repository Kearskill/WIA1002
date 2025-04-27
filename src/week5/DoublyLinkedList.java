package week5;

public class DoublyLinkedList<E> {
    private class Node {
        E data;
        Node prev, next;

        Node(E data) {
            this.data = data;
        }
    }

    private Node head, tail;
    private int size;

    public DoublyLinkedList() {
        head = tail = null;
        size = 0;
    }

    // 1) Add to front
    public void addFirst(E data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    // 2) Add to end
    public void addLast(E data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    // 3) Add at index (1-based index)
    public void addAtIndex(int index, E data) {
        if (index < 1 || index > size + 1) {
            System.out.println("Invalid index.");
            return;
        }

        if (index == 1) {
            addFirst(data);
        } else if (index == size + 1) {
            addLast(data);
        } else {
            Node newNode = new Node(data);
            Node current = head;
            for (int i = 1; i < index - 1; i++) {
                current = current.next;
            }

            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;

            size++;
        }
    }

    // 4) Remove at index (1-based index)
    public void removeAtIndex(int index) {
        if (index < 1 || index > size) {
            System.out.println("Invalid index.");
            return;
        }

        if (index == 1) {
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
        } else if (index == size) {
            tail = tail.prev;
            tail.next = null;
        } else {
            Node current = head;
            for (int i = 1; i < index; i++) {
                current = current.next;
            }

            current.prev.next = current.next;
            current.next.prev = current.prev;
        }

        size--;
    }

    // 5) Traverse forward
    public void traverseForward() {
        System.out.print("Forward: ");
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // 6) Traverse backward
    public void traverseBackward() {
        System.out.print("Backward: ");
        Node current = tail;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }

    // 7) Get size
    public int getSize() {
        return size;
    }

    // 8) Clear list
    public void clear() {
        head = tail = null;
        size = 0;
    }
}
