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

```

h) Repeat (d) – (f), for the following operations :

i. addLast() – value of element, c

ii. add(int index, E e) – value of element, d

iii. removeFirst()

iv. removeLast()

v. remove(int index) – remove at index 1

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

b) Correct the statements by rewriting them in the correct order and syntax.Write the
correct/right method name to replace operationX.  

**Question 3**  
Given the following nodes. Answer the following:
###### imagine a picture here  
a) Based on the above figure, what is the name of the method for above operation?  

b) Write codes to represent the above figure. (Kindly use the variables stated in the
figure)  

