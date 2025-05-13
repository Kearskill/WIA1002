<ins>**Tutorial: Queue**</ins>

1. Name **four** everyday examples of a queue other than those discussed during lecture.

2. What is the difference between a queue and stack?

3. Use the following code segment to answer parts (a) through (c):  
```text
Queue<Integer> q = new Queue<Integer>();
Scanner keyIn = new Scanner(System.in);
for (int i = 1; i <= 5; i++){
    if (keyIn.nextBoolean())
        System.out.print(i + " ");
    else
        q.enqueue(i);
    }
}

while (!q.isEmpty()){
    System.out.print(q.dequeue() + " ");
}
System.out.println();
```

(a) What is the output for the following input sequence?  
`true false false true true`

(b) Is it possible to have output: `1 3 5 4 2`? If yes, give an input sequence that produces the output; or else, provide justification to your answer.  

(c) Give at least three input sequences that produce the output: 
`1 2 3 4 5`

4. Hand trace a queue X through the following operations:
```text
X.enqueue(new Integer(14));
X.enqueue(new Integer(3));
X.enqueue(new Integer(5));
Object Y = X.dequeue();
X.enqueue(new Integer(7));
X.enqueue(new Integer(9));
Y = X.dequeue();
X.enqueue(new Integer(2));
X.enqueue(new Integer(4));
```

Given the resulting queue X above, what would be the result of each of the following?
```text
a) X.front();

b) Y = X.dequeue();
   X.enqueue(new Integer(10));
   X.front();
   
c) Y = X.dequeue();

d) X.front();
```

5. Provide and explain three operations / functions of Linked List based Queue that you can add
   to the GenericQueue class, other than those discussed in the lecture (i.e., enqueue, dequeue
   and getSize – from Slide 10 in the lecture slide).