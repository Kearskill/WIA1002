**<ins>Tutorial: Generics</ins>**

1. Create a generic class called Container that accepts one parameter, T. Create a no-arg constructor.
   Declare a private variable, t of type T. Create a method, add that returns nothing, accepting a
   parameter of generic type. Initialize this parameter to the initially declared variable. Create a generic
   method called retrieve() that returns the initially declared variable.<br>
   Create a main method within the Container class. Create two containers of type Integer and String.
   Append two objects to the containers, one of type Integer having value 50, another of type String
   having value Java. Display the Integer and String objects from the respective containers.

```java
// Create a generic class called Container that accepts one parameter, T.
class Container<T> {
    // Declare a private variable, t of type T
    private T t;

    Container() { // Create a no-arg constructor.
    }

    // Create a method, add that returns nothing, accepting a
    // parameter of generic type
    void add(T t) {
        // Initialize this parameter to the initially declared variable
        this.t = t;
    }

    // Create a generic
    // method called retrieve() that returns the initially declared variable
    T retrieve() {
        return t;
    }

    // Create a main method within the Container class
    public static void main(String[] args) {
        // Create two containers of type Integer and String.
        // Append two objects to the containers, one of type Integer having value 50, another of type String
        // having value Java.

        Container container1 = new Container();
        container1.add(50);

        Container container2 = new Container();
        container2.add("Java");

        // Display the Integer and String objects from the respective containers.
        System.out.println("Container Integer: " + container1.retrieve());
        System.out.println("Container String: " + container2.retrieve());
    }
}
```

2. Create a class called MyArray that has two methods, a main method that creates 3 arrays of<br>
   a) integer containing the numbers 1,2,3,4 and 5<br>
   b) string containing names, Jane, Tom and Bob<br>
   c) character containing alphabet, a, b and c<br>
   and a generic method listAll that displays the list of arrays.

```java
public class MyArray {
    /*
        main method that creates 3 arrays of
        a) integer containing the numbers 1,2,3,4 and 5
        b) string containing names, Jane, Tom and Bob
        c) character containing alphabet, a, b and c
    */
    public static void main(String[] args) {
//        int[] integerArr = {1,2,3,4,5}; // this is banned, don't use primitive
//        char[] charArr = {'a','b','c'}; // this is banned, use Capital Character

        Integer[] integerArr = {1, 2, 3, 4, 5};
        String[] stringArr = {"Jane", "Tom", "Bob"};
        Character[] charArr = {'a', 'b', 'c'};

        System.out.println("Integer array: ");
        MyArray.<Integer>listAll(integerArr); // you can remove <Integer>, Explicit type arguments can be inferred
        System.out.println("String array: ");
        MyArray.<String>listAll(stringArr);
        System.out.println("Character array: ");
        MyArray.<Character>listAll(charArr);
    }

    private static <E> void listAll(E[] list) {
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();
        System.out.println();
    }
}
```

3. What is a raw type? Why is a raw type unsafe? Why is the raw type allowed in Java?<br>
   `Raw type is a generic class/interface used without specifying a concrete type/without type parameter.`<br>
   `Raw type pose security risk, and it may compile well but will run an exception at runtime(prod)`<br>
   `Raw type is allowed because old people likes to stay with old Java (backward compatibility).`<br>


4. What is erasure? Why are Java generics implements using erasure?<br>
   `Erasure removes generic type. Start of program, generic type information is used to compile, but erased afterward.`<br>
   `This headache inducing approach allows generic code to be backward-compatible with legacy code to cater old people.`<br>


5. Create a generic class named Duo that has two parameters, A and B. Declare a variable named first of
   type A, and the second variable named second of type B. Create a constructor that accepts these two
   parameters. In the constructor, assign these parameters respectively to the declared variables.

```java
public class Duo<A, B> {
    private A first;
    private B second;

    Duo(A first, B second) {
        this.first = first;
        this.second = second;
    }
}
```

6. Use the Duo class in Question 4 to declare and create two objects as follows :<br>
   a. First object called sideShape consist of respectively String type and Integer type.<br>
   b. Second object called points consists of two Double types. <br>

```java
public class Duo<A, B> {
    private A first;
    private B second;

    Duo(A first, B second) {
        this.first = first;
        this.second = second;
    }

    public String toString() {
        return "(" + first + ", " + second + ")";
    }

    public static void main(String[] args) {
        Duo<String, Integer> sideShape = new Duo<>("Square", 5);
        Duo<Double, Double> points = new Duo<>(2.3, 4.5);

        System.out.print("Side shape: ");
        System.out.println(sideShape);
        System.out.print("Points: ");
        System.out.println(points);
    }
}
```

7. Assume that the following objects were created<br>
   ArrayList<String> vehicle = new ArrayList<>();<br>
   ArrayList<Object> transportation = new ArrayList<>();<br>

Declare a method header for generic method,allTransportation that returns nothing,which accepts
two ArrayList parameters using the wildcards.

```java
public static void allTransportation(ArrayList<String> vehicle, ArrayList<?> transportation);
```

<br>

8\. Assuming that two new object are created as follows<br>
ArrayList<Integer> numOfCars = new ArrayList<>();<br>
ArrayList<Double> milesPerHour = new ArrayList<>();<br>

Using the <?> wildcard, implement a generic method that displays the list.

```java
import java.util.ArrayList;

public class WildCardExample {
    public static void main(String[] args) {
        ArrayList<Integer> numOfCars = new ArrayList<>();
        ArrayList<Double> milesPerHour = new ArrayList<>();

        numOfCars.add(2);
        numOfCars.add(5);
        numOfCars.add(23);

        milesPerHour.add(23.5);
        milesPerHour.add(60.23);
        milesPerHour.add(20.7);

        System.out.println("Number of cars: ");
        displayList(numOfCars);
        System.out.println("Miles per hour: ");
        displayList(milesPerHour);
    }

    private static void displayList(ArrayList<?> obj) {
        for (Object a : obj) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
```

9\. When the compiler encounters a generic class, interface, or method with an unbound type
parameter, such as <T> or <E>, it replaces all occurrences of the type parameter with what
type?<br>
`= Object`

10\. When the compiler encounters a generic class, interface, or method with a bound type
parameter, such as <T extends Number> or <E extends Comparable>, it replaces all
occurrences of the type parameter with what type?<br>
`Replaces all occurrences of the type parameter with the upper bound`
`<T extends Number> will replace T with Number`
`<E extends Comparable> will replace E with Comparable`