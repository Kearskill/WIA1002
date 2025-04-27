**<ins>Lab: Linked List</ins>**<br>
Question 1

1) Write the generic Node class consisting of two components of a node (i.e.:
   element, next), with a default construct and a constructor that accepts an
   item assigned to the initially declared element variable.

```java
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
```

2) Write a class called MyLinkedList. The class should have the following :  
   a. Default constructor  
   b. Nodes for head and tail

```java
public class MyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }
}
```

3) Implement the following methods from tutorial in this class:<br>
   a. public void addFirst(E e)<br>
   b. public void addLast(E e)<br>
   c. public void add(int index, E e)<br>
   d. public E removeFirst()<br>
   e. public E removeLast()<br>
   f. public E remove(int index)<br>

```java
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
}
```

4) Expand the MyLinkedList by implementing the following methods:<br>

| Methods                      | Description                                                                           |
|------------------------------|---------------------------------------------------------------------------------------|
| public boolean contains(E e) | Return true if list contains the element e                                            |
| public E get(int index)      | Return element at the specified index                                                 |
| public E getFirst()          | Return the value of the first item                                                    |
| public E getLast()           | Return the value of the last item                                                     |
| public int indexOf(E e)      | Return the index of the head matching element in this list. Return -1 of no match     |
| public int lastIndexOf(E e)  | Return the index of the last matching element in this list. Return -1 of no match     |
| public E set(int index, E e) | Replace the element at the specified position in this list with the specified element |
| public void clear()          | Clear the list                                                                        |
| public void print()          | Print all the elements in the list                                                    |
| public void reverse()        | Print all elements in reverse order                                                   |

```java
public class MyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    // Default constructor
    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // -- Existing Methods (addFirst, addLast, etc.) would go here --

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

    public void reverse1() {
        for (int i = size; i > 0; i--) {
            System.out.print(get(i) + " ");
        }
    }

    private void reverseRecursive(Node<T> node) {
        if (node == null) return;
        reverseRecursive(node.next);
        System.out.print(node.element + " -> ");
    }

    // Size getter
    public int size() {
        return size;
    }

    // Helper to check index validity
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
        }
    }
}
```

5) Write a test program called TestLinkedList that creates a list from
   MyLinkedList class. Using the methods in (3) and (4), do the following:<br>
   a. Append the following : a, b, c, d, e<br>
   b. Print all the elements in the list.<br>
   c. Reverse all the elements in the list.<br>
   d. Retrieve the number of elements in the list.<br>
   e. Retrieve the first and last value.<br>
   f. Delete the third value.<br>
   g. Retrieve the index location for the second and third value.<br>
   h. Checks if the list has the value ‘c’.<br>
   i. Replace the items individually with the following: j,a,v,a.<br>

```java
public class TestLinkedList {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();

        // a. Append the following: a, b, c, d, e
        list.addLast("a");
        list.addLast("b");
        list.addLast("c");
        list.addLast("d");
        list.addLast("e");

        // b. Print all the elements in the list.
        System.out.println("List elements:");
        list.print();

        // c. Reverse all the elements in the list.
        System.out.println("Reversed list:");
        list.reverse();

        // d. Retrieve the number of elements in the list.
        System.out.println("Number of elements: " + list.size());

        // e. Retrieve the first and last value.
        System.out.println("First element: " + list.getFirst());
        System.out.println("Last element: " + list.getLast());

        // f. Delete the third value (index 2)
        System.out.println("Removed third value: " + list.remove(2));

        // g. Retrieve index location for the second and third value
        System.out.println("Index of 'b': " + list.indexOf("b"));
        System.out.println("Index of 'd': " + list.indexOf("d")); // now at index 2

        // h. Check if the list has the value ‘c’
        System.out.println("Contains 'c'? " + list.contains("c"));

        // i. Replace the items individually with: j, a, v, a
        list.set(0, "j");
        list.set(1, "a");
        list.set(2, "v");
        list.set(3, "a");

        // Final list
        System.out.println("Final replaced list:");
        list.print();
    }
}
```

Question 2<br>
A method called getMiddleValue() returns the value of the middle element of a
linked list. The method signature is given as follows :<br>

public E getMiddleValue()

Write the codes for the getMiddleValue().<br>

```java
public class LinkedList<T> {
    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public T getMiddleValue1() {
        Node<T> current = head;
        int midVal = size / 2;
        for (int i = 0; i < midVal; i++) {
            current = current.next;
        }
        return current.element;
    }

    // Optional: method to add elements for testing
    public void add(T data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }
}
```





