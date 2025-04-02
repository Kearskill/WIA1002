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

```