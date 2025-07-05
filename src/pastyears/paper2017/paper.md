**<ins>June 2017, 3 hours 30 minutes, attempted by Leith</ins>**

QUESTION 1<br>
Write a program to create a (singly) linked list using a class called LinkedList, where an
example of the output for the test program is as follows:

run:
```text
Displaying the Linked List *************************************
Louis Vuitton: 10,000,000 Sold
Chanel: 100,000,000 Sold
Prada: 1,000,000 Sold
Tods: 500,000,000 Sold

Adding Coach after Chanel
Found Chanel which is handbag number 2 in linked list

Displaying the Linked List *************************************
Louis Vuitton: 10,000,000 Sold
Chanel: 100,000,000 Sold
Coach: 10,000,000 Sold
Prada: 1,000,000 Sold
Tods: 500,000,000 Sold

Adding Mulberry after Coach
Found Coach which is handbag number 3 in the linked list

Displaying the Linked List *************************************
Louis Vuitton: 10,000,000 Sold
Chanel: 100,000,000 Sold
Coach: 10,000,000 Sold
Mulberry: 90,000,000 Sold
Prada: 1.000,000 Sold
Tods: 500,000,000 Sold

Removing Chanel..
Found a match.. Chanel is handbag number 2 in the linked list

Displaying the Linked List *************************************
Louis Vuitton: 10,000,000 Sold
Coach: 10,000,000 Sold
Mulberry: 90,000,000 Sold
Prada: 1,000,000 Sold
Tods: 500,000,000 Sold

Removing Coach..
Found a match.. Coach is handbag number 2 in the linked list

Displaying the Linked List *************************************
Louis Vuitton: 10,000,000 Sold
Mulberry: 90,000,000 Sold
Prada: 1,000,000 Sold
Tods: 500,000,000 Sold

BUILD SUCCESSFUL (total time: 0 seconds)
```

Your program requires the following methods:<br>
i)<br>
Method insertFirstLinked(String, int) to insert a new element into the linked list. [2 marks]

ii)<br>
Method addAfter(String, String, int) to insert a new element after a particular element in the linked list. [4 marks]

iii)<br>
Method removeLink(String) to delete any element in the linked list. [4 marks]

iv) <br>
Method display() to display all the contents of the linked list. [2 marks]

* No marks will be given for any implementation using the existing LinkedList class or any other Collection
class available from the Java API Library.

```java
package pastyears.paper2017;


public class LinkedList {
    static class Node {
        String brand;
        int sold;
        Node next;

        public Node(String brand, int sold) {
            this.brand = brand;
            this.sold = sold;
            this.next = null;
        }
    }

    private Node head;

    // Insert in the beginning
    public void insertFirstLinked(String brand, int sold){
        Node newNode = new Node(brand, sold);
        newNode.next = head;
        head = newNode;
    }

    // Add after a specific brand
    public void addAfter(String targetBrand, String newBrand, int sold){
        Node current = head;
        int count = 1;

        System.out.println("Adding "+ newBrand + " after " + targetBrand + " ");
        while (current != null){
            if (current.brand.equals(targetBrand)){
                Node newNode = new Node(newBrand, sold);
                newNode.next = current.next;
                current.next = newNode;
                System.out.println("Found " + targetBrand + " which is handbag number "  + count + " in the linked list.\n");
                return;
            }
            current = current.next;
            count++;
        }
        // if not found
        System.out.println(targetBrand + " not found in the list.");
    }

    // Remove a node by brand
    public void removeLink(String targetBrand){
        Node current = head;
        Node previous = null;
        int count = 1;

        System.out.println("Removing " + targetBrand + "..");
        while (current != null){
            if (current.brand.equals(targetBrand)){
                if (previous == null) {
                    head = current.next;
                } else{
                    previous.next = current.next;
                }
                System.out.println("Found a match.. " +targetBrand+ " is handbag number " + count  + " in the linked list.\n");
                return;
            }
            previous = current;
            current = current.next;
            count++;
        }
    }

    public void display(){
        Node current = head;
        System.out.println("Displaying the Linked List *************************************");
        while(current!= null){
            System.out.println(current.brand  + ": " + String.format("%,d",current.sold)  + " Sold.");
            current=  current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insertFirstLinked("Tods", 500000000);
        list.insertFirstLinked("Prada", 1000000);
        list.insertFirstLinked("Chanel", 100000000);
        list.insertFirstLinked("Louis Vuitton", 10000000);

        list.display();

        list.addAfter("Chanel","Coach",10000000);

        list.display();

        list.addAfter("Coach", "Mulberry", 90000000);

        list.display();

        list.removeLink("Chanel");

        list.display();

        list.removeLink("Coach");

        list.display();
    }

}
```

QUESTION 2<br>
Imagine a pile of books on your desk. Each book is so large and heavy, and you can only
remove the top one from the pile. You cannot remove a book from under another one.
Likewise, you can add another book to the pile only by placing it on the top of the pile.
You cannot add a book beneath one another and can only remove the pile's top book.

Considering all the given information above.

a) <br>
Design a stack interface, StackInterface<E> that you can use to specify common
methods for any stack object that implements this interface. The interface should
specify the following common attribute and methods:  
* An attribute that is an ArrayList to store the elements in this stack.
* A constructor that creates an empty stack.
* A method that returns the number of elements in this stack.
* A method that returns the top element in this stack.
* A method that returns and removes the top element in this stack.
* A method that adds a new element to the top of this stack.
* A method that returns true if the stack is empty. [2 marks]

```java
package pastyears.paper2017;

public interface StackInterface<T> {
    /** A method that returns the number of elements in this stack.
    */
    int getSize();

    /**  A method that returns the top element in this stack.
     * */
    T peek();

    /** A method that returns and removes the top element in this stack.
     * */
    T pop();

    /** A method that adds a new element to the top of this stack.
    * */
    void push(T element);

    /** A method that returns true if the stack is empty.
     * */
    boolean isEmpty();
}
```

b) <br>
If you represent books by their titles, design a stack generic class, GenericStack<E>
that implement the StackInterface<E>, you can use it to track the books in the pile on
your desk. Implement the methods using ArrayList. This class should override the
Java toString method to return the list of elements in this stack. [7 marks]

```java
package pastyears.paper2017;
import java.util.ArrayList;
import java.util.Scanner;

public class GenericStack<E> implements StackInterface<E>{
    private ArrayList<E> stack;

    public GenericStack(){
        stack = new ArrayList<>();
    }

    public int getSize(){
        return stack.size();
    }

    public E peek(){
        if(!isEmpty()){
            return stack.get(stack.size() - 1);
        }
        return null;
    }

    public E pop(){
        if(!isEmpty()){
            return stack.remove(stack.size() - 1);
        }
        return null;
    }

    public void push(E element){
        stack.add(element);
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    @Override
    public String toString(){
        return stack.toString();
    }
}

```

c) <br>
Write a test program, TestPileStack that demonstrates your implementation. An
example of the output for the test program is as follows: [2 marks]

```text
Create a new stack: an empty pile of books
isEmpty() returns true

Push 3 books to the pile:
Enter book title 1: The Hobbit
Enter book title 2: The Lord of the Rings
Enter book title 3: The Da Vinci Code

The new books that you added are: [The Hobbit, The Lord of the Rings, The Da Vinci
Code]

The pile should not be empty:
isEmpty() returns false
The pile has 3 books.

Get the top book and remove the top book:

The Da Vinci Code is at the top of the pile.
The Da Vinci Code is removed from the pile.

The Lord of the Rings is at the top of the pile.
The Lord of the Rings is removed from the pile.

The Hobbit is at the top of the pile.
The Hobbit is removed from the pile.

The pile should be empty:
isEmpty() returns true
```

```java
class StackDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GenericStack<String> bookPile = new GenericStack<>();

        System.out.println("Create a new stack: an empty pile of books");
        System.out.println("isEmpty() returns " + bookPile.isEmpty());

        System.out.println("\nPush 3 books to the pile: ");
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter book title " + (i + 1) + ": ");
            String title = sc.nextLine();
            bookPile.push(title);
        }

        System.out.println("\nThe new books that you added are: " + bookPile);
        System.out.println("\nThe pile should not be empty:");
        System.out.println("\nisEmpty() returns " + bookPile.isEmpty());
        System.out.println("The pile has " + bookPile.getSize() + " ");

        System.out.println("\nGet the top book and remove the top book:");

        while (!bookPile.isEmpty()) {
            String topBook = bookPile.peek();
            System.out.println(topBook + " is at the top of the pile.");
            System.out.println(topBook + " is removed from the pile.");
            bookPile.pop();
            System.out.println();
        }

        System.out.println("The pile should be empty:");
        System.out.println("isEmpty() returns " + bookPile.isEmpty());

        sc.close();
    }
}
```


QUESTION 3<br>
Write a code for the following methods to be implemented in a generic binary search tree class type E.  
i)<br>
Method `public boolean add(Node<E> node, E item)` to add new item type E into the
binary search tree. The method should return a boolean value: `true` if the insertion is successful, and false if
it is a duplicated item. [3 marks]

```java
    public boolean add(Node<E> node, E item) {
    if (node == null) {
        root = new Node<>(item);
        return true;
    }

    Node<E> current = node; // this is the head
    while (1 + 2 == 3) {
        int cmp = item.compareTo(current.data);
        if (cmp == 0) {
            return false;
        } else if (cmp < 0) {
            if (current.left == null) {
                current.left = new Node<>(item);
                return true;
            }
            current = current.left;
        } else {
            if (current.right == null) {
                current.right = new Node<>(item);
                return true;
            }
            current = current.right;
        }
    }
}

public boolean add(E item) {
    if (root == null) {
        root = new Node<>(item);
        return true;
    }
    return add(root, item);
}
```


ii) <br>
Method `public void printTreeInOrder()` to print all the tree items in "`in order`" iteratively (non-recursive). [4 marks]

```java
public void printTreeInOrder() {
    Stack<Node<E>> stack = new Stack<>();
    Node<E> current = root;

    while (current != null || !stack.isEmpty()) {
        while (current != null) {
            stack.push(current);
            current = current.left;
        }

        current = stack.pop();
        System.out.print(current.data + " ");
        current = current.right;
    }
    System.out.println();
}
```


iii) <br>
Method `public boolean contains(E item)` to check if the binary search tree contains a specified item. The method should return `boolean` value: `true` 
if the item is found, otherwise return `false`. [3 marks]

```java
public boolean contains(E item) {
    Node<E> current = root;

    while (current != null) {
        int cmp = item.compareTo(current.data);
        if (cmp == 0) {
            return true;
        } else if (cmp < 0) {
            current = current.left;
        } else {
            current = current.right;
        }
    }
    return false;
}
```

The Node class:
```java
private static class Node<E>{
    E data;
    Node<E> left, right;
    public Node(E data){
        this.data = data;
        left = null;
        right = null;
    }
}
```

The demo file:
```java
public static void main(String[] args) {
    GenericBST<Integer> bst = new GenericBST<>();

    bst.add(50);
    bst.add(30);
    bst.add(70);
    bst.add(20);
    bst.add(40);

    bst.printTreeInOrder();

    System.out.println(bst.contains(50));
    System.out.println(bst.contains(727));
}
```
QUESTION 4<br>
Write a program to accept numbers and encode them to return their corresponding word by using queue.

Your program shall demonstrate the following:

a)<br>
Implement a Queue<E> class. Ensure that the following methods and constructors
are implemented. [8 marks]

i) `public Queue (E[] items)`<br>
ii) `public Queue ()`<br>
iii) `public void enqueue (E e)`<br>
iv) `public E dequeue ()`<br>
v) `public E getElement (int i)`<br>
vi) `public int getSize()`<br>
vii) `public boolean isEmpty()`<br>
viii) `public String toString()`<br>

```java
package pastyears.paper2017;
import java.util.ArrayList;

public class Queue<E> {
    private ArrayList<E> list;

//    i)
    public Queue (E[] items){
        list = new ArrayList<>();
        for (E item: items){
            list.add(item);
        }
    }

//    ii)
    public Queue (){
        list = new ArrayList<>();
    }

//    iii)
    public void enqueue (E e){
        list.add(e);
    }

//    iv)
    public E dequeue (){
        if (!isEmpty()){
            return list.remove(0);
        }
        return null;
    }

//    v)
    public E getElement (int i){
        if (i>=0 && i< list.size()){
            return list.get(i);
        }
        return null;
    }

//    vi)
    public int getSize(){
        return list.size();
    }

//    vii)
    public boolean isEmpty(){
        return list.isEmpty();
    }

//    viii)
    public String toString(){
        return list.toString();
    }
}
```

b)<br>
The program uses the Queue<E> class implemented in Question 4(a). Following are further hints to guide the program
development:

i)<br>
A list of alphabets (i.e., a - z) is given as an array as follows. Store this array of
alphabets in the queue implemented in Question 4(a). There are 26 characters in
total. [9 marks]

```text
alphabet = ('a', 'b,'c,..'y','z')
```

ii)<br>
The index (see example output) represents the index location of the alphabets
and not given as a separate array.

iii)<br>
The program interacts with the user by asking the frequency of input numbers to
be provided.

iv)<br>
Once the user enters all the numbers, the program will display their
corresponding alphabets.

Following are examples of the output. The bolded texts (`**texts**`) are the user input.

Example Output 1:
```text
Queue: [a, b, c, d, e, f, g, h, i, j, k, I, m, n, o, p, q, r, s, t, u, v, w, x, y, z]
Index: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25,
26]
How many times will you enter a number: **0**
(Please enter your number(s) between 0-26.)
The entered numbers are[]
The deciphered values are -Cannot decipher. No value was entered.-
```

Example Output 2:
```text
Queue: [a, b, c, d, e, f, g, h, i, j, k, I, m, n, o, p, q, r, s, t, u, v, w, x, y, z]
Index: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25,
26]
How many times will you enter a number: **13**
(Please enter your number(s) between 0-26.)
Enter number 1 >> **3**
Enter number 2 >> **0**
Enter number 3 >> **19**
Enter number 4 >> **0**
Enter number 5 >> **18**
Enter number 6 >> **19**
Enter number 7 >> **17**
Enter number 8 >> **20**
Enter number 9 >> **2**
Enter number 10 >> **19**
Enter number 11 >> **20**
Enter number 12 >> **17**
Enter number 13 >> **4**
The entered numbers are [3, 0, 19, 0, 18, 19, 17, 20, 2, 19, 20, 17, 4]
The deciphered values are datastructure
```

Queue.java👇

```java
package pastyears.paper2017;
import java.util.ArrayList;

public class Queue<E> {
    private ArrayList<E> list;

//    i)
    public Queue (E[] items){
        list = new ArrayList<>();
        for (E item: items){
            list.add(item);
        }
    }

//    ii)
    public Queue (){
        list = new ArrayList<>();
    }

//    iii)
    public void enqueue (E e){
        list.add(e);
    }

//    iv)
    public E dequeue (){
        if (!isEmpty()){
            return list.remove(0);
        }
        return null;
    }

//    v)
    public E getElement (int i){
        if (i>=0 && i< list.size()){
            return list.get(i);
        }
        return null;
    }

//    vi)
    public int getSize(){
        return list.size();
    }

//    vii)
    public boolean isEmpty(){
        return list.isEmpty();
    }

//    viii)
    public String toString(){
        return list.toString();
    }
}
```

AlphabetEncoder.java 👇

```java
package pastyears.paper2017;

import java.util.ArrayList;
import java.util.Scanner;

public class AlphabetEncoder {
    public static void main(String[] args) {
        Character[] alphabetArray = new Character[26];

        for (int i = 0; i < 26; i++) {
            alphabetArray[i] = (char) ('a' + i);
        }

        Queue<Character> alphabetQueue = new Queue<>(alphabetArray);

        System.out.println("Queue: "+ alphabetQueue);

        System.out.print("Index: [");
        for (int i = 0; i < 26; i++) {
            System.out.print(i);
            if (i<25) System.out.print(", ");
        }
        System.out.println("]");

        Scanner sc = new Scanner(System.in);
        System.out.print("How many times will you enter a number: ");
        int n = sc.nextInt();

        ArrayList<Integer> numbers = new ArrayList<>();

        if (n==0){ // weird edge case
            System.out.println("(Please enter your number(s) between 0-26.)");
            System.out.println("The entered numbers are " + numbers);
            System.out.println("The deciphered values are -Cannot decipher. No value was entered.-");
            return;
        }

        System.out.println("(Please enter your number(s) between 0-26.)");
        for (int i = 0; i < n; i++) {
            System.out.print("Enter number " + (i + 1) + " >> ");
            int num = sc.nextInt();
            numbers.add(num);
        }

        // Display entered numbers
        System.out.println("The entered numbers are " + numbers);

        // iv) Decipher values
        StringBuilder result = new StringBuilder();
        for (int index : numbers) {
            if (index >= 0 && index < alphabetQueue.getSize()) {
                result.append(alphabetQueue.getElement(index));
            } else {
                result.append('?'); // invalid index
            }
        }

        System.out.println("The deciphered values are " + result.toString());
    }
}
```
