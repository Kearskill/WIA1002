<ins>**Jan 2018, 3 hours 30 minutes, attempted by Leith**</ins><br>
QUESTION 1 <br>
The Towers of Hanoi problem is a classical problem used to illustrate the power of
recursion. Explanation of the problem goes as follows:

There are three poles and 64 discs of different sizes. Initially, all the discs are placed on
the first pole with the largest disc at the bottom and the smallest one at the top. You
need to move all the discs from the first pole to the third pole, with the smallest disc at
the top and the largest at the bottom. You can move only one disc at a time and at any
point of time, a larger disc cannot be placed over a smaller one. The second pole can be
used as an intermediate pole to help you in transferring the discs.

### insert picture

For a puzzle with 2 discs (disc 1 and disc 2), the puzzle can be solved with the following
steps (algorithm):
Step 1: Move disc 1 from pole 1 to pole 2
Step 2: Move disc 2 from pole 1 to pole 3
Step 3: Move disc 3 from pole 1 to pole 3

Write a program to solve Towers of Hanoi using recursion.
(Save and copy this file to your exam account directory and keep it inside a folder called
[Q1]).
(7 markah/marks)

QUESTION 2 <br>
Queue supports the insert and the remove operations based on the First-in First-out
policy. Write a program to create a class named Queue. The class should consist of
methods as specified in Table 1:

**Table 1: List of method names and their specification**

| Constructor/Method name        | Specification                                      |
|--------------------------------|----------------------------------------------------|
| i) Constructor for Queue class | Default constructor                                |
| ii) isEmpty                    | Return whether or not the queue is empty           |
| iii) peek                      | Return the value of the first element in the queue |
| iv) enqueue                    | Add element to the bottom of the queue             |
| v) dequeue                     | Remove element from the top of the queue           |
| vi) display                    | Display all elements in the queue                  |

[8 marks]

a)<br>
Test the methods by programming your main() method similar to the example in
Figure 1.

```java
public static void main(String[] args) {
    Queue q = new Queue(5);
    q.enqueue("hello");
    q.enqueue("all");
    q.enqueue("who");
    q.enqueue("wants");
    q.enqueue("ice cream");
    q.dequeue();
    q.dequeue();
    q.enqueue("1000");
    q.enqueue("2000");
    q.peek();
}
```

```text
Data hello inserted
Data all inserted
Data who inserted
Data wants inserted
Data ice cream inserted
Data hello has been removed
Data all has been removed
Data 1000 inserted
Data 2000 inserted
Peek(): who
BUILD SUCCESSFUL (total time: 0 seconds)
```

[2 marks]

b)<br>
Modify the method display() to display each index and element in boxes as shown in
the example in Figure 2.

#### insert picture here

#### insert more picture here

[3 marks]

(Save and copy all related files to this program (Queue class and main() method) to your exam account directory
and keep them inside a folder called [Q2])

- No marks will be given for any implementation using the existing Queue class or any other Collection classes available
  from the Java API Library.

QUESTION 3 <br>
One popular technique in data structure is stack. Write a program using stack. Your
program must contain the following methods (see Table 2).

| Constructor/Method name         | Specification                                                          |
|---------------------------------|------------------------------------------------------------------------|
| i)  Constructor for Stack class | Default constructor                                                    |
| ii) isEmpty                     | Return whether or not the stack is empty                               |
| iii) peek                       | Return the value of the first element in the stack without removing it |
| iv) push                        | Add element to the top of stack                                        |
| v) pop                          | Remove element from the top of the stack                               |
| vi) popAll                      | Remove all elements from the stack                                     |
| vii) display                    | Display all elements in the stack                                      |
| viii) displayInReverse          | Display all elements in the stack in reversed order                    |

[8 marks]

a) Test the methods by programming your main() method similar to the example in
Figure 3. [2 marks]

### inesrt picture

b) With some modification, change your stack program into Generic form so that the 
following can be implemented. [5 marks]

### figure 4

(Save and copy all related files to this program (Stack class and main() method) to your exam
account directory and keep them inside a folder name [Q3]).

- No marks will be given for any implementation using the existing Stack class or any
other Collection classes available from the Java API Library.

QUESTION 4 <br>
One popular technique in data structure is linked list. Write a program using linked list.
Your program must contain the following methods (see Table 3).
i)
Jadual 3: Senarai nama-nama metod dan spesifikasinya
Table 3: List of method names and their specification
Pembina/Nama Metod
Constructor/Method name
Constructor for the linked
list class
ii) Constructor for the node
class
iii) isEmpty
iv) add
v) addAfter
vi) remove
vii) display
Spesifikasi
Specification
Konstruktor lalai untuk kelas senarai berpaut
Default constructor for the linked list class
Konstruktor lalai untuk kelas nod
Default constructor for the node class
Memulangkan sama ada timbunan tersebut
adalan kosong atau tidak
Return whether or not the stack is empty
Menambah elemen di posisi teratas dalam
timbunan
Add element to the top of stack
Membuang elemen di posisi teratas dalam
timbunan
Remove element from the top ofthe stack
Membuang kesemua elemen-elemen di dalam
timbunan
Remove all elements from the stack
Memaparkan elemen-elemen di dalam
timbunan
Display all elements in the stack
(10 markah/marks)
a) Uji metod-metod tersebut dengan memprogram di dalam metod main() anda
seperti contoh di dalam Rajah 5.
Test the methods by programming your main() method similar to the example
Figure 5.
in
public static void main(String[] args) {
LList list = new LList();
list.add ("Computing Mathematics 1", 3):
list.add("Frinciples of AI", 3);
list.add("Programming 1", 5);
xun:
list.add("Data Structure", 5)
list.display():
list.addAfter("Programming 1", "Software Architecture", 4);
list.addAfter("Software Architecture", "Networking", 4);
list.remove ("Networking", 4);
list.display():
list.remove ("Principles of AI", 3);
list.display():
Displaying the Linked List
Data Structure: 5 hours
Programming 1: 5 hours
Principles of AI: 3 hours
Computing Mathematics 1: 3 hours
Adding Software Architecture after Programmmming 1
Found Programming 1 which is book number 2 in the linked list
Displaying the Linked List
Data Structure: 5 hours
Programming 1: 5 hours
Software Architecture: 4 hours
Principles of AI: 3 hours
Computing Mathematics 1: 3 hours
Adding Networking after Software Architecture
Found Software Architecture which is book number 3 in the linked list
Rajah 5
Figure 5
(3 markah/marks)
10/12
WIA1002
b) Tambah satu metod totalCreditHours() untuk mengira jumlah jam kredit yang
dikumpul. Lihat contoh program dan output dalam Rajah 6.
Add a method totalCreditHours() to count the total credit hours collected. See Figure
6 for program and output example.
public static void main (String[] args){
LList list = new LList();
list.add ("Computing Mathematics 1", 3):
list.add("Principles of AI", 3);
list.add ("Programming 1", 5):
list.add ("Data Structure", 5):
//list.display():
list.totalCreditHours ():
list.addAfter ("Programming 1", "Software Architecture", 4);
list.addAfter("Software Architecture", "Networking", 4);
//list.display();
list.totalCreditHours ();
list.remove ("Networking", 4);
//list.display ();
list.remove ("Principles of AI", 3);
//list.display ();
list.totalCreditHours():
}
run:
Total credit hours taken: 16
Adding Software Architecture after Programming 1
Found Programming 1 which is book number 2 in the linked list
Adding Networking after Software Architecture
Found Software Architecture which is book number 3 in the linked list
Total credit hours taken: 24
Removing Networking..
Found a match.. Networking is book mumber 4 in the linked list
Removing Principles of AI..
Found a match.. Principles of AI is book number 4 in the linked list
Total credit hours taken: 17
BUILD SUCCESSFUL (total time: 0 seconds)
Rajah 6
Figure 6
(2 markah/marks)
11/12
WIA1002
(Simpan dan salin kesemua fail-fail yang berkaitan dengan program ini (kelas
LList dan metod main()) ke direktori akaun peperiksaan anda di dalam folder
yang dinamakan [Q4]).
(Save and copy all related files to this program (LList class and main() method) to your
exam account directory and keep them inside a folder called [Q4]).
* Markah tidak akan diberikan bagi apa-apa pelaksanaan menggunakan kelas
  LinkedList atau mana-mana kelas Collection yang sedia ada didapati daripada
  Java API Library.
* No marks will be given for any implementation using the existing LinkedList class or
  any other Collection classes available from the Java API Library.
