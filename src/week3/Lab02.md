**<ins>Lab: Generics</ins>**  
1\. Create a generic class called MyGeneric that accepts one parameter.
   Declare a variable called e for the type parameter. Create a no-arg
   constructor. Create a constructor that accepts one generic parameter.
   Create a setter and getter method for the generic type.  
   Create a test program that creates two instances of generic class of
   type String called strObj and of type Integer called intObj. Set a
   value for each of these objects. Display these values using the getter
   method.
```java
public class MyGeneric<T> {
    private T value;
    MyGeneric(){}
    MyGeneric(T value){
        this.value = value;
    }
    T getValue(){
        return value;
    }
    void setValue(T value){
        this.value = value;
    }

    public static void main(String[] args) {
        MyGeneric<String> strObj = new MyGeneric<>();
        MyGeneric<Integer> intObj =  new MyGeneric<>();

        strObj.setValue("Java");
        intObj.setValue(42);
        System.out.println(strObj.getValue());
        System.out.println(intObj.getValue());
    }
}
```  
2\. In a class called CompareMax, create a generic static method called
   maximum where the generic type extends the Comparable interface,
   which receives three parameters. Find the maximum of three values
   invoked by the main method.
```java
public class CompareMax{
    private static <E extends Comparable> E maximum(E a, E b, E c){
        if(a.compareTo(b) > 0 && a.compareTo(c) > 0){ //Unchecked call to 'compareTo(T)' as a member of raw type 'java.lang.Comparable'
            return a;
        } else if (b.compareTo(a) > 0 && b.compareTo(c)>0){
            return b;
        } else if (c.compareTo(a) > 0 && c.compareTo(b)>0){
            return c;
        } else{
            return a;
        }
    }

    public static void main(String[] args) {
        System.out.println(maximum(2,4,3));
        System.out.println(maximum(3.5,2.4,7.5));
        System.out.println(maximum(-3.0,5.4,0.0));
//        System.out.println("Abc","UM IS ONE","Java"); this is yabai
    }
}
```  
3\. a) Modify the following program to become a generic class called StorePairGeneric.
```java
public class StorePair {
    private int first, second;
    public StorePair(int first, int second) {
        this.first = first;
        this.second = second;
    }
    public int getFirst() {
        return first;
    }
    public int getSecond() {
        return second;
    }
    public void setPair(int first, int second) {
        this.first = first;
        this.second = second;
    }
    public String toString() {
        return "first = " + first + " second = " + second;
    }
}
```  
Answer below:
```java
public class StorePairGeneric<T> {
    private T first, second;

    public StorePairGeneric(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public void setPair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public String toString() {
        return "first = " + first + " second = " + second;
    }
}
```
b) Override the Object equals() method in the StorePair class to
compare the first values of two objects for equality.
```java
@Override
public boolean equals(Object obj){
  if (this == obj){
      return true;
  } else{
      return false;
  }
}
```

c) Have the StorePair class implement the Comparable interface.<br>
Override the compareTo() method to compare the first values of two
objects.
```java
public class StorePair implements Comparable<StorePair> {
    @Override
    public int compareTo(StorePair other) {
        return Integer.compare(this.first, other.first);
    }
}
```

d) Create a test program that creates three objects of the StorePair
generic class called a, b and c. Set the first and second values of a,
b, c as (6,4), (2,2), (6,3).
```java
public static void main(String[] args) {
   StorePairGeneric a = new StorePairGeneric(6,4);
   StorePairGeneric b = new StorePairGeneric(2,2);
   StorePairGeneric c = new StorePairGeneric(6,3);
}
```
e) Invoke the compareTo()and equals() methods that compares the
three objects created in (d) in the test program.
```java
System.out.println(a.compareTo(b)); // 1
System.out.println(a.compareTo(c)); // 0
System.out.println(b.compareTo(a)); // -1
System.out.println(b.compareTo(c)); // -1
System.out.println(c.compareTo(a)); // 0
System.out.println(c.compareTo(b)); // 1

System.out.println(a.equals(b)); // false
System.out.println(a.equals(c)); // false
System.out.println(b.equals(a)); // false
System.out.println(b.equals(c)); // false
System.out.println(c.equals(a)); // false
System.out.println(c.equals(b)); // false
```
4. Provide a declaration and implementation of the generic method
   minmax() that takes in an array of generic type and returns a string
   with the following format: `Min = <minValue>` `Max = <maxValue>`. For
   instance, in your main method, create one object of type array for
   integers and one object of type string:
```declarative
Integer[] intArray = {5,3,7,1,4,9,8,2};
String[] strArray = {"red", "blue", "orange", "tan"};

minmax() method returns “Min = 1 Max = 9” For intArray
minmax() method returns “Min = blue Max = tan” for strArray
```
Integer[] intArray = {5,3,7,1,4,9,8,2};  
String[] strArray = {"red", "blue", "orange", "tan"};  
minmax() method returns “Min = 1 Max = 9” For intArray  
minmax() method returns “Min = blue Max = tan” for strArray  

```java
package week3;

public class L2Q4 {
    // why do i use T?
    // = Although its a collection (array), i still need to individually check for
    //   min and max.
    public static <T extends Comparable<T>> String minmax(T[] array) {
        if (array == null || array.length == 0) {
            return "Min = null Max = null";
        }

        T min = array[0];
        T max = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i].compareTo(min) < 0) {
                min = array[i];
            }
            if (array[i].compareTo(max) > 0) {
                max = array[i];
            }
        }

        return String.format("Min = %s Max = %s", min, max);
    }


    public static void main(String[] args) {
        Integer[] intArray = {5, 3, 7, 1, 4, 9, 8, 2};
        String[] strArray = {"red", "blue", "orange", "tan"};

//        minmax() method returns “Min = 1 Max = 9” For intArray
        System.out.println(minmax(intArray));
//        minmax() method returns “Min = blue Max = tan” for strArray
        System.out.println(minmax(strArray));

        String[] skibidiArray = {"toilets","cameramen","YouTube","Turkish animator","DaFuqBoom","Slenderman"};
        // sorted by lexicographically (A-Z, a-z)
        System.out.println(minmax(skibidiArray));
    }
}
```

5. Create a class called FindMax that contains the following:  
   Create a Circle class that uses the Comparable interface. Declare the
   radius variable and a single parameterized constructor that accepts
   this variable.  
   In your main program, create 3 different objects of type array  
   (a) for
   integers that stores the following values, 1,2,3;   
   (b) a list of string that
   stores red, green, blue and  
   (c) a circle object of radius 3, 2.9 and 5.9.  
   Invoke the max method as below:  

   `public static <E extends Comparable<E>> E max(E[] list)`  
   The max method above returns the maximum value in an array.
```java
package week3;

public class FindMax {
    public static <E extends Comparable<E>> E max(E[] list){
        if (list == null || list.length == 0){
            return null;
        }

        E max = list[0];
        for (E a : list){
            if(a.compareTo(max)>0){ // if more than 0, a > max
                max = a;
            }
        }
        return max;
    }

    public static void main(String[] args) {
//        int[] array_a = {1,2,3}; // banned, use Integer rather than int
        Integer[] array_a = {1,2,3};
        String[] array_b = {"red","green","blue"};
//        Circle[] array_c = {new Circle(3), new Circle(2.9), new Circle(5.9)}; // banned, where is new Circle?
        /*Circle[] array_c = new Circle[]{
                new Circle(3),
                new Circle(2.9),
                new Circle(5.9),
        };*/ // banned, where is Circle<>()? why use Circle()

        Circle[] array_c = new Circle[]{
                new Circle<>(3.0),
                new Circle<>(2.9),
                new Circle<>(5.9),
        };

        System.out.println("Max array a: " + max(array_a));
        System.out.println("Max array b: " + max(array_b));
        System.out.println("Max array c: " + max(array_c));
    }
}

class Circle <T extends Comparable<T>> implements Comparable<Circle<T>>{
    private T radius;
    Circle(T radius){
        this.radius = radius;
    }

    public T getRadius(){
        return radius;
    }

    public void setRadius(T radius){
        this.radius = radius;
    }

    @Override
    public int compareTo(Circle<T> other) {
        return this.radius.compareTo(other.radius);
    }

    @Override
    public String toString(){
        return radius.toString();
    }
}
```

6. In a class called MinMaxTwoDArray, write two generic methods:  
   a. First method returns the minimum element in a two-dimensional
   array. Below is the method signature:
   `public static <E extends Comparable<E>> E min(E[][] list)`  
   b. Second method returns the maximum element in a two-dimensional
   array. Below is the method signature:  
   `public static <E extends Comparable<E>> E max(E[][] list)`  
   c. Create a test program that creates one instance of generic class of
   type Integer called numbers with the elements: {4, 5, 6}, {1, 2, 3}.  
   Display the minimum and maximum elements using the min and
   max methods.
```java
package week3;

public class MinMaxTwoDArray {
    public static <E extends Comparable<E>> E min(E[][] list){
        if (list==null || list.length==0) {
            return null;
        }
        E min = list[0][0];
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[i].length; j++) {
                if(min.compareTo(list[i][j]) > 0){ // +ve number is a > b
                    min = list[i][j];
                }
            }
        }
        return min;
    }

    public static <E extends Comparable<E>> E max(E[][] list){
        if (list==null || list.length==0) {
            return null;
        }
        E max = list[0][0];
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[i].length; j++) {
                if(max.compareTo(list[i][j]) < 0){ // +ve number is a > b
                    max = list[i][j];
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Integer[][] numbers = {{4,5,6},{1,2,3}};
        System.out.println("Minimum: " + min(numbers));
        System.out.println("Maximum: " + max(numbers));
    }
}
```