Tutorial: Priority Queue

1. Describe the main difference between Queue and PriorityQueue.<br>
```text
Queue:
- Follow first-in-first-out order.
- The element that is added first is removed first.

Priority Queue:
- Follow priority-based ordering, not insertion order.
- The element with the highest priority is removed first, regardless of when it is added.
```
2. Briefly provide THREE (3) real-life example in using PriorityQueue.<br>
```text
- In a hospital, the patient with the most critical conditions are treated first.
- In a CPU, operating system gives more CPU time to high-priority tasks before the lower-priority task.
- Dijkstra's Algorithm, finding shortest path between nodes on a map.
```
3. Show the output for every System.out.println ((a) – (f)) in the following code:

```java
import java.util.*;

public static void main(String args[]) {
    PriorityQueue<String> pQueue = new PriorityQueue<String>();
    pQueue.offer("C++");
    pQueue.offer("Python");
    pQueue.offer("Java");
    pQueue.offer("Fortran");
    System.out.println("peek() gives us: " + pQueue.peek()); //(a)
    System.out.println("The queue elements:"); //(b)
    Iterator itr = pQueue.iterator();
    while (itr.hasNext())
        System.out.println(itr.next()); //(b)

    pQueue.poll();
    System.out.println("After poll():"); //(c)
    Iterator<String> itr2 = pQueue.iterator();

    while (itr2.hasNext())
        System.out.println(itr2.next()); //(c)

    pQueue.remove("Java");
    System.out.println("After remove():"); //(d)
    Iterator<String> itr3 = pQueue.iterator();

    while (itr3.hasNext())
        System.out.println(itr3.next()); //(d)

    boolean b = pQueue.contains("Ruby");
    System.out.println("Priority queue contains Ruby or not?: " + b); //(e)
    Object[] arr = pQueue.toArray();
    System.out.println("Value in array: "); //(f)

    for (int i = 0; i < arr.length; i++)
        System.out.println("Value: " + arr[i].toString()); //(f)
}
```

```text
(a) peek() gives us: C++

(b) The queue elements:
    C++
    Fortran
    Java
    Python
    
(c) After poll():
    Fortran
    Python
    Java
    
(d) After remove():
    Fortran
    Python
    
(e) Priority queue contains Ruby or not?: false

(f) Value in array: 
    Value: Fortran
    Value: Python
```

4. Answer the following sub-questions with referring to the following code:

```java
public class PriorityQueue2 {
    public static void main(String... args) {
        PriorityQueueComparator pqc = new PriorityQueueComparator();
        PriorityQueue<String> pq = new PriorityQueue<String>(5, pqc);
        pq.add("Jason");
        pq.add("Ali");
        pq.add("Muhamad");
        for (String s : pq) {
            System.out.println(s);
        }
    }
}

public class PriorityQueueComparator implements Comparator<String> {
    public int compare(String s1, String s2) {
        if (s1.length() < s2.length()) {
            return -1;
        }
        if (s1.length() > s2.length()) {
            return 1;
        }
        return 0;
    }
}
```

a) What is the purpose of the PriorityQueueComparator in the code?<br>
```text
- Customize the ordering of elements in PriorityQueue.
- Order strings by their lengths.
```
b) What is the output for the code?
```text
Ali
Jason
Muhamad
```