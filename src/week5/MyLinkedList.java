package week5;

public class MyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    // Default constructor
    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // a. Add to the beginning
    public void addFirst(T e) {
        Node<T> newNode = new Node<>(e);
        newNode.next = head;
        head = newNode;
        if (tail == null) { // List was empty
            tail = head;
        }
        size++;
    }

    // b. Add to the end
    public void addLast(T e) {
        Node<T> newNode = new Node<>(e);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    // c. Add at specific index
    public void add(int index, T e) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (index == 0) {
            addFirst(e);
        } else if (index == size) {
            addLast(e);
        } else {
            Node<T> current = head;
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            Node<T> temp = current.next;
            current.next = new Node<>(e);
            current.next.next = temp;
            size++;
        }
    }

    // d. Remove from beginning
    public T removeFirst() {
        if (head == null) return null;
        T temp = head.element;
        head = head.next;
        size--;
        if (head == null) { // List became empty
            tail = null;
        }
        return temp;
    }

    // e. Remove from end
    public T removeLast() {
        if (size == 0) return null;
        if (size == 1) {
            T temp = head.element;
            head = tail = null;
            size = 0;
            return temp;
        }
        Node<T> current = head;
        while (current.next != tail) {
            current = current.next;
        }
        T temp = tail.element;
        tail = current;
        tail.next = null;
        size--;
        return temp;
    }

    // f. Remove at specific index
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        } else {
            Node<T> previous = head;
            for (int i = 1; i < index; i++) {
                previous = previous.next;
            }
            Node<T> current = previous.next;
            previous.next = current.next;
            size--;
            return current.element;
        }
    }

    // Optional: size getter
    public int size() {
        return size;
    }

    // Optional: print method for testing
    public void printList() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.element + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // 1. Check if the list contains an element
    public boolean contains(T e) {
        Node<T> current = head;
        while (current != null) {
            if (current.element.equals(e)) return true;
            current = current.next;
        }
        return false;
    }

    // 2. Get element at specific index
    public T get(int index) {
        checkIndex(index);
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.element;
    }

    // 3. Get first element
    public T getFirst() {
        if (head == null) return null;
        return head.element;
    }

    // 4. Get last element
    public T getLast() {
        if (tail == null) return null;
        return tail.element;
    }

    // 5. Get index of first occurrence
    public int indexOf(T e) {
        Node<T> current = head;
        int index = 0;
        while (current != null) {
            if (current.element.equals(e)) return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    // 6. Get index of last occurrence
    public int lastIndexOf(T e) {
        Node<T> current = head;
        int index = 0;
        int lastIndex = -1;
        while (current != null) {
            if (current.element.equals(e)) lastIndex = index;
            current = current.next;
            index++;
        }
        return lastIndex;
    }

    // 7. Replace element at index
    public T set(int index, T e) {
        checkIndex(index);
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        T old = current.element;
        current.element = e;
        return old;
    }

    // 8. Clear the list
    public void clear() {
        head = tail = null;
        size = 0;
    }

    // 9. Print elements
    public void print() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.element + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // 10. Print in reverse order
    public void reverse() {
        reverseRecursive(head);
        System.out.println("null");
    }

    public void reverse1(){
        for (int i = size; i >0 ; i--) {
            System.out.print(get(i) +" ");
        }
    }

    private void reverseRecursive(Node<T> node) {
        if (node == null) return;
        reverseRecursive(node.next);
        System.out.print(node.element + " -> ");
    }

    // Helper to check index validity
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
        }
    }
    public T getMiddleValue1() {
        Node<T> current = head;
        int midVal = size / 2;
        for (int i = 0; i < midVal; i++) {
            current = current.next;
        }
        return current.element;
    }

}
