**<ins>Tutorial: LinkedList</ins>**  
Question 1

a) Assume that a node class called Node<E> exist. Create two nodes called node1 and
node2. Node1 contains alphabet ‘a’ and node2 contains alphabet ‘z’. Also, create 2
references, head and tail. Let head points to node 1 and tail points to node 2.
```java
Node<Character> node1 = new Node<>('a');
Node<Character> node2 = new Node<>('z');

Node<Character> head = node1;
Node<Character> tail = node2;
```

b) Draw the nodes from (a).  
`head -> [a]  [z] <- tail`

c) Write a statement/code for node1 accessing the node2. Modify 1(b) to show this.  
`node1.next = node2;`  
`head -> [a] -> [z] <- tail`

d) Create a new node, firstNode. Add this new node at the first location of all existing
nodes.     
Draw these nodes.
```java
Node<Character> firstNode = new Node<>('X');
firstNode.next = head;
head = firstNode;
```  
`head -> [X] -> [a] -> [z] <- tail`

e) If we have no information about the status of a linked-list, what are the conditions we
need to consider to perform the operation in (d)?  
```text
If the list is empty (head==null), 
both head and tails should point (.next) to firstNode.

If the list has one or more nodes,
link the firstNode to the head, 
and update head (head = firstNode).
```

f) Write a list of operations/steps/pseudocode needed to add the firstNode to the first
location.  
```text
1. Create the firstNode
2. If head is null:
        head = new Node
        tail = new Node
   Else:
        newNode.next = head
        head = newNode
```

g) Write codes to assign the firstNode to the first location.
```java
Node<Character> firstNode = new Node<>('x');
if (head == null) {
    head = tail = firstNode;
} else {
    firstNode.next = head;
    head = firstNode;
}
```

h) Repeat (d) – (f), for the following operations :  
i. addLast() – value of element, c
```text
function addLast(element):
    newNode = Node(element)
    if tail == null:
        head = tail = newNode
    else:
        tail.next = newNode
        tail = newNode
```
```java
Node<Character> newNode = new Node<>('c');
if (tail == null) {
    head = tail = newNode;
} else {
    tail.next = newNode;
    tail = newNode;
}
```

ii. add(int index, E e) – value of element, d
```java
int index = 1;
Node<Character> newNode = new Node<>('d');
Node<Character> curr = head;
for (int i = 0; i < index - 1; i++) {
    curr = curr.next;
}
newNode.next = curr.next;
curr.next = newNode;
```

iii. removeFirst()
```java
if (head != null) {
    head = head.next;
    if (head == null) tail = null;
}
```

iv. removeLast()
```java
if (head == null) return;
if (head.next == null) {
    head = tail = null;
} else {
    Node<Character> curr = head;
    while (curr.next != tail) {
        curr = curr.next;
    }
    curr.next = null;
    tail = curr;
}
```

v. remove(int index) – remove at index 1
```java
int index = 1;
if (index == 0) {
    head = head.next;
    if (head == null) tail = null;
} else {
    Node<Character> curr = head;
    for (int i = 0; i < index - 1; i++) {
        curr = curr.next;
    }
    curr.next = curr.next.next;
    if (curr.next == null) tail = curr;
}
```

**Question 2**  
Given is a method containing incorrect statements that checks if an element is in a list

```
public void operationX(E e) {
    pointerB.next = pointerB;

    for(int i++; i>size; int i) {
        System.out.println(current.element);
        if(current.element = e)
    }

    Node<E> pointerB = head;
    return false;
}
```
a) What is the name of the method for operationX?   
`public boolean contains(E e)`

b) Correct the statements by rewriting them in the correct order and syntax.Write the
correct/right method name to replace operationX.  
```java
public boolean contains(E e) {
    Node<E> current = head;

    while (current != null) {
        System.out.println(current.element); // optional for debugging
        if (current.element.equals(e)) {
            return true;
        }
        current = current.next;
    }

    return false;
}
```

**Question 3**  
Given the following nodes. Answer the following:
###### imagine a picture here  
a) Based on the above figure, what is the name of the method for above operation?  
`addLast(), since it iterate until the end of the nodes, to find the last node.`

b) Write codes to represent the above figure. (Kindly use the variables stated in the
figure)  
```java
// Assume Node<E> is already defined and we’re using Characters as an example
Node<Character> head = new Node<>('a');
Node<Character> pointer1 = head;

Node<Character> tail = new Node<>('b');
pointer1.next = tail;

tail.next = null;

// Optional third node (not connected)
Node<Character> temp = new Node<>('c');
temp.next = null;
```

