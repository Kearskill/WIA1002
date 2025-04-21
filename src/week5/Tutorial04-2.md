**<ins>Tutorial: Linked List & Doubly Linked List</ins>**  
Question 1:
```text
public E xyz(int index,E e){
    Node<E> current=head;
    Node<E> temp;
    
    if(index<0) return null;
    else if(index>=size-1) {
        this.addLast(e);
        return null;
    }
    else if(index==0) {
        temp=head;
        head.element=e;
        return temp.element;
    }else{
        for (int i = 1; i < index; i++) {
        current=current.next;
    }
    temp=current.next;
    current.next.element=e;
    return temp.element;
}
```
Given method xyz with 2 arguments:  
a) Based on the above source code, explain what the lines of code do from line 10 – 21.
```java
else if(index==0) {        // If the index is 0 (first element)
    temp = head;           // Store the current head node in temp
    head.element = e;      // Update the head's element with the new value 'e'
    return temp.element;   // Return the old element that was replaced
}
```
`Updates the first node (head) with new element e`  
`Returns the old head (before replacing` 

```java
else {                     // For indices between 1 and size-2
    for (int i = 1; i < index; i++) {  // Traverse to the node before the target index
        current = current.next;
    }
    temp = current.next;               // Store the node at the target index in temp
    current.next.element = e;          // Update its element with 'e'
    return temp.element;               // Return the old element that was replaced
}
```  
`This part traverses the linked list until reaching the node before the target index.`   
`It then replaces the element at index with e and returns the old element.`  

b) What is the main purpose of the method xyz()?
```text
This method updates the element at a given index in a linked list and returns the old element:

If index < 0 → Returns null (invalid).

If index >= size-1 → Appends e at the end (via addLast()).

If index == 0 → Updates the head node and returns the old element.

If 0 < index < size-1 → Updates the node at index and returns the old element.

Summary: It’s a "replace at index" method for a linked list.
```

c) Obviously, there are some bugs in the source code. Debug the code and make it concise and
simpler.   
```java
public E xyz(int index, E e) {
    if (index < 0 || index >= size) {  // Proper bounds check
        return null;
    }
    
    Node<E> current = head;
    for (int i = 0; i < index; i++) {  // Correct traversal (starts at 0)
        current = current.next;
    }
    
    E oldElement = current.element;  // Store old element before replacing
    current.element = e;            // Update with new element
    return oldElement;              // Return the old element
}
```
Issues in the Original Code:
- Incorrect bounds check (index >= size-1) → Should be index >= size.

- Redundant traversal (i = 1 instead of i = 0) → Can lead to off-by-one errors.

- Unnecessary variable (temp) → Can be eliminated for simplicity.  

Question 2:  
```text
1. else{
2.     Node<E> temp = head;
3.     for(int i = 0; i<index;i++){
4.         temp =temp.next;
5.     }
6.     element =temp.element;
7.     temp.next.prev =temp.prev;
8.     temp.prev.next =temp.next;
9.     temp.next =null;
10.    temp.prev =null;
11.    size--;
}
```
Based on the source code above, assume the index given is 3  
a) Explain what the lines of code do from line 2-11.  
`Traverse to the node at index 3 (fourth node since node starts from 0)`  
`Stores the element of the node that is being removed`  
`Update neighbouring nodes prev and next`  
`Nullify references, ensuring temp is completely detached from the list`
`Decrement the size of the elements to ensure the correct count of the elements.`  

b) Draw the nodes for lines 7 - 10  
Before removal<br>
`Node 0 (head) ⇄ Node 1 ⇄ Node 2 ⇄ [Node 3 (temp)] ⇄ Node 4`  

Line 7<br>
```text
Node 0 ⇄ Node 1 ⇄ Node 2 ⇄ Node 3 (temp)   Node 4
                  ↑_________↙
```

Line 8  
```text
Node 0 ⇄ Node 1 ⇄ Node 2      Node 3 (temp)   Node 4
                  ↘_________↗
```

Line 9 - 10
```text
Node 0 ⇄ Node 1 ⇄ Node 2 ⇄ Node 4
[Node 3 (temp)] → next = null, prev = null
```

Final state
```text
Node 0 ⇄ Node 1 ⇄ Node 2 ⇄ Node 4
Size is decremented by 1.
```

Question 3<br>
A doubly linked list keeps a set of characters. The head, the middle and the tail nodes respectively
contains alphabet ‘a’, ‘b’ and ‘c’. These nodes are in successive order. Create a new node that contains
alphabet ‘z’. Add this new node at the last location of this linked list. Draw all of these nodes including
their correct references.<br>
```java
class Node<E> {
    E element;
    Node<E> prev;
    Node<E> next;

    public Node(E element) {
        this.element = element;
        this.prev = null;
        this.next = null;
    }
}

public class DoublyLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // Add a node to the end of the list
    public void addLast(E element) {
        Node<E> newNode = new Node<>(element);
        if (tail == null) { // Empty list
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    // Print the list from head to tail
    public void printForward() {
        Node<E> current = head;
        while (current != null) {
            System.out.print(current.element + " ⇄ ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Print the list from tail to head
    public void printBackward() {
        Node<E> current = tail;
        while (current != null) {
            System.out.print(current.element + " ⇄ ");
            current = current.prev;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DoublyLinkedList<Character> list = new DoublyLinkedList<>();

        // Initialize the list with 'a' → 'b' → 'c'
        list.addLast('a');
        list.addLast('b');
        list.addLast('c');

        System.out.println("Original list (forward):");
        list.printForward();  // Output: a ⇄ b ⇄ c ⇄ null

        System.out.println("Original list (backward):");
        list.printBackward(); // Output: c ⇄ b ⇄ a ⇄ null

        // Add 'z' to the end
        list.addLast('z');

        System.out.println("\nAfter adding 'z' (forward):");
        list.printForward();  // Output: a ⇄ b ⇄ c ⇄ z ⇄ null

        System.out.println("After adding 'z' (backward):");
        list.printBackward(); // Output: z ⇄ c ⇄ b ⇄ a ⇄ null
    }
}
```