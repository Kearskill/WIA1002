**<ins>Lab: Stack and Problem Solving with Stack</ins>**<br>
Q1
a) Create a generic stack called MyStack class using ArrayList. The MyStack generic class
should implement the following methods :

1) public void push(E 0);
2) public E pop();
3) public E peek();
4) public int getSize();
5) public boolean isEmpty();
6) public String toString();
7) public boolean search(E o);

```java
package week6;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class MyStack<E> {
    ArrayList<E> list = new ArrayList<E>();

    public int getSize() {
        return list.size();
    }

    public void push(E o) { // push is add
        list.add(o);
    }

    public E pop() { // pop is remove
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        E o = list.get(getSize() - 1);
        list.remove(getSize() - 1);
        return o;
    }

    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list.get(getSize() - 1);
    }

    public Boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        return "stack " + list.toString();
    }
    
   /* public boolean search(E o){
        return list.contains(o);
    }
    
    public int search (E o){
        if (list.contains(o)){
            return 1;
        } else{
            return 0;
        }
    }*/

    public int search(E o) {
        for (int i = list.size() - 1, pos = 1; i >= 0; i--, pos++) {
            if (list.get(i).equals(o)) {
                return pos; // 1-based position from the top
            }
        }
        return -1; // Not found
    }
}
```   

b) Write a test program for Q1(a) called TestMyStack class.<br> Create a stack of type Character from MyStack.<br>
Following the given order, add elements, a b and c in the stack.<br>
Print the stack.<br>
Check if element ‘b’ is in the stack.
Check if element ‘k’ is in the stack.

```java
package week6;

public class TestMyStack {
    public static void main(String[] args) {
        MyStack<Character> ms = new MyStack<Character>();
        ms.push('a');
        ms.push('b');
        ms.push('c');
        System.out.println(ms);

        System.out.println("Value c is at location: "+ ms.search('c'));
        System.out.println("Does value b exist in stack1: " + ms.search('b'));
        System.out.println("Does value k exist in stack1: " + ms.search('k'));

        MyStack<Integer> is = new MyStack<Integer>(); // is  = integer stack
        is.push(1);
        is.push(2);
        is.push(3);
        System.out.println(is);
        System.out.println("Does value 6 exist in stack2: " + is.search(6));
    }
}

```

c) In the same test program as Q1(b), create a second stack of type integer.
Following the given order, add elements, 1 2 and 3 in the stack.
Print the stack.
Check if element ‘6’ is in the stack.

Answer: as above (part 1(b))

Q2<br>
Write a new test program for Q1(a) called TestIntMyStack class.  
a) Prompt user to enter an integer value.  
b) Push the values 1 through the user entered value onto the stack.    
c) Print the size of the stack.    
d) Display the contents of the stack by repeatedly calling pop() until the
stack is empty.  
What is the output of the elements? What is the order, why?

```java
package week6;
import java.util.Scanner;

public class TestIntMyStack {
    public static void main(String[] args) {
        MyStack<Integer> s1 = new MyStack<Integer>();
        Scanner sc =new Scanner(System.in);

        System.out.println("Please enter an integer: ");
        int value = sc.nextInt();
        for (int i = 1; i <= value; i++) {
            s1.push(i);
        }

        System.out.println(s1);
        System.out.println("The size of the stack is " + s1.getSize());
        System.out.println("Popping the stack: ");
        while(!s1.isEmpty()){
            int intValue = s1.pop();
            System.out.print(intValue +  " ");
        }
        System.out.println("\n");
    }
}
```

Q3<br>
Assuming that an unknown number of positive integers are stored in a stack, S.
Using only stack ADT operations write an algorithm/function to find the sum of
every element in S.

```java
import java.util.Stack;

public class StackSum {

    public static int sumStack(Stack<Integer> S) {
        int sum = 0;
        Stack<Integer> temp = new Stack<>();

        // Pop all elements from S, add to sum, and push to temp
        while (!S.isEmpty()) {
            int element = S.pop();
            sum += element;
            temp.push(element);
        }

        // Restore the original stack S
        while (!temp.isEmpty()) {
            S.push(temp.pop());
        }

        return sum;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println("Original stack: " + stack);
        int total = sumStack(stack);
        System.out.println("Sum of elements: " + total);
        System.out.println("Stack after sum (should be unchanged): " + stack);
    }
}
```

Q4<br>
A string is a palindrome if it spells the same way forwards and backwards. Write a
Java program that uses a Stack to determine if a string is a palindrome or not. Let
your string be of maximum size 15 characters. Note however that the actual size
may be 15 or less.

```java
import java.util.Scanner;
import java.util.Stack;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string (max 15 characters): ");
        String input = scanner.nextLine();

        // Ensure the input doesn't exceed 15 characters
        if (input.length() > 15) {
            System.out.println("Error: Input exceeds 15 characters.");
            return;
        }

        if (isPalindrome(input)) {
            System.out.println("'" + input + "' is a palindrome.");
        } else {
            System.out.println("'" + input + "' is not a palindrome.");
        }
    }

    public static boolean isPalindrome(String str) {
        // Remove spaces and convert to lowercase for case-insensitive comparison
        String processedStr = str.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();

        // Push each character onto the stack
        for (int i = 0; i < processedStr.length(); i++) {
            stack.push(processedStr.charAt(i));
        }

        // Compare characters from start with those popped from stack
        for (int i = 0; i < processedStr.length(); i++) {
            if (processedStr.charAt(i) != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}
```

Q5<br>
The Tower of Hanoi is a mathematical game or puzzle. It consists of three rods, and
a number of disks of different sizes which can slide onto any rod. The puzzle starts
with the disks in a neat stack in ascending order of size on one rod, the smallest at
the top, thus making a conical shape. The objective of the puzzle is to move the
entire stack to another rod, obeying the following rules:<br>
i) Only one disk may be moved at a time.<br>

ii) Each move consists of taking the upper disk from one of the rods and sliding it
onto another rod, on top of the other disks that may already be present on that rod. <br>

iii) No disk may be placed on top of a smaller disk.<br>

You are required to write the source code using Java syntax to solve Tower of Hanoi
Problem using stacks data structure.

```java
import java.util.Stack;

public class TowerOfHanoi {
    private Stack<Integer>[] rods;
    private int numDisks;

    @SuppressWarnings("unchecked")
    public TowerOfHanoi(int disks) {
        numDisks = disks;
        rods = new Stack[3];
        for (int i = 0; i < 3; i++) {
            rods[i] = new Stack<Integer>();
        }

        // Initialize the first rod with disks (largest at bottom)
        for (int disk = numDisks; disk >= 1; disk--) {
            rods[0].push(disk);
        }
    }

    public void solve() {
        moveDisks(numDisks, 0, 2, 1);
    }

    private void moveDisks(int n, int fromRod, int toRod, int auxRod) {
        if (n == 1) {
            int disk = rods[fromRod].pop();
            rods[toRod].push(disk);
            System.out.println("Move disk " + disk + " from rod " + (fromRod + 1) + " to rod " + (toRod + 1));
            return;
        }

        moveDisks(n - 1, fromRod, auxRod, toRod);

        int disk = rods[fromRod].pop();
        rods[toRod].push(disk);
        System.out.println("Move disk " + disk + " from rod " + (fromRod + 1) + " to rod " + (toRod + 1));

        moveDisks(n - 1, auxRod, toRod, fromRod);
    }

    public void printRods() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Rod " + (i + 1) + ": " + rods[i]);
        }
    }

    public static void main(String[] args) {
        int numDisks = 3; // Change this value for different number of disks
        TowerOfHanoi tower = new TowerOfHanoi(numDisks);

        System.out.println("Initial state:");
        tower.printRods();

        System.out.println("\nSolving Tower of Hanoi with " + numDisks + " disks:");
        tower.solve();

        System.out.println("\nFinal state:");
        tower.printRods();
    }
}
```
