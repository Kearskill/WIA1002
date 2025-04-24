**<ins>Lab: ADTs and Bags</ins>**  
**Question 1**  
Given the interface BagInterface below:  
```java
/**
 An interface that describes the operations of a bag of objects.
 */
public interface BagInterface<T> {
    /** Gets the current number of entries in this bag.
     @return the integer number of entries currently in the bag */
    public int getCurrentSize();

    /** Sees whether this bag is full.
     @return true if the bag is full, or false if not */
    public boolean isFull();

    /** Sees whether this bag is empty.
     @return true if the bag is empty, or false if not */
    public boolean isEmpty();

    /** Adds a new entry to this bag.
     @param newEntry the object to be added as a new entry
     @return true if the addition is successful, or false if not */
    public boolean add(T newEntry);

    /** Removes one unspecified entry from this bag, if possible.
     @return either the removed entry, if the removal was successful,
     or null */
    public T remove();

    /** Removes one occurrence of a given entry from this bag.
     @param anEntry the entry to be removed
     @return true if the removal was successful, or false if not */
    public boolean remove(T anEntry);

    /** Removes all entries from this bag. */
    public void clear();

    /** Counts the number of times a given entry appears in this bag.
     @param anEntry the entry to be counted
     @return the number of times anEntry appears in the bag */
    public int getFrequencyOf(T anEntry);

    /** Tests whether this bag contains a given entry.
     @param anEntry the entry to locate
     @return true if this bag contains anEntry, or false otherwise */
    public boolean contains(T anEntry);

    /** Retrieves all entries that are in this bag.
     @return a newly allocated array of all the entries in the bag */
    public T[] toArray();
} // end BagInterface
```
Write an ArrayBag class that implement the BagInterface, as shown in the UML diagram
below. Set the DEFAULT_CAPACITY to 25.  
```
+--------------------------------------+
| ArrayBag                             |
+--------------------------------------+
| -bag: T[]                            |
| -DEFAULT_CAPACITY: integer           |
| -numberOfEntries: integer            |
+--------------------------------------+
| +getCurrentSize(): integer           |
| +isFull(): boolean                   |
| +isEmpty(): boolean                  |
| +add(newEntry: T): boolean           |
| +remove(): T                         |
| +remove(anEntry: T): boolean         |
| +clear(): void                       |
| +getFrequencyOf(anEntry: T): integer |
| +contains(anEntry: T): boolean       |
| +toArray(): T[]                      |
+--------------------------------------+
```
```java
package week4;

public class ArrayBag<T> implements BagInterface<T> {
    private T[] bag;
    private int DEFAULT_CAPACITY;
    private int numberOfEntries;

    public ArrayBag(int DEFAULT_CAPACITY) {
        this.DEFAULT_CAPACITY = DEFAULT_CAPACITY;
        numberOfEntries = 0;
        this.bag = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public int getCurrentSize() {
        return numberOfEntries;
    }

    public boolean isFull() {
        return numberOfEntries == DEFAULT_CAPACITY;
    }

    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    public boolean add(T newEntry) {
        if(isFull()){
            return false;
        }
        bag[numberOfEntries] = newEntry;
        numberOfEntries++;
        return true;
    }

    public T remove(){
        if(isEmpty()){
            return null;
        }
        T removedItem = bag[numberOfEntries-1];
        remove(removedItem);
        numberOfEntries--;
        return removedItem;
    }

    public boolean remove (T anEntry){
        if (isEmpty() || anEntry == null) {
            return false;
        }

        for (int i = 0; i < numberOfEntries; i++) {
            if (anEntry.equals(bag[i])) {
                // Shift all elements after index i left by one
                for (int j = i; j < numberOfEntries - 1; j++) {
                    bag[j] = bag[j + 1];
                }
                bag[numberOfEntries - 1] = null; // Clear last position
                numberOfEntries--;
                return true;
            }
        }
        return false; // Entry not found
    }

    public void clear(){
        for (int i = 0; i < numberOfEntries; i++) {
            bag[i] = null;
        }
        numberOfEntries = 0;
    }
    
    public int getFrequencyOf(T anEntry){
        int cnt=0;
        for (int i = 0; i < numberOfEntries; i++) {
            if (anEntry.equals(bag[i])) {
                cnt++;
            }
        }
        return cnt;
    }
    
    public boolean contains(T anEntry){
        for (int i = 0; i < numberOfEntries; i++) {
            if (anEntry.equals(bag[i])) {
                return true;
            }
        }
        return false;
    }
    
    public T[] toArray(){
        T[] result = (T[]) new Object[numberOfEntries]; // unchecked cast

        // Copy elements from bagArray to the result array
        System.arraycopy(bag, 0, result, 0, numberOfEntries);

        return result;
    }

    // Write an ArrayBag class that implement the BagInterface, as shown in the UML diagram
    // below. Set the DEFAULT_CAPACITY to 25.
    public static void main(String[] args) {
        ArrayBag arrayBag = new ArrayBag(25);
        System.out.println("Is array bag empty : "+arrayBag.isEmpty());
        System.out.println("Is array bag full : "+arrayBag.isFull());
        arrayBag.add("Hello");
        System.out.println("Is array bag empty : "+arrayBag.isEmpty());
        // too lazy to test man
    }
}
```

**Question 2**  
The union of two collections consists of their contents combined into a new collection. Add a
method union to the interface BagInterface for the ADT bag that returns as a new bag the
union of the bag receiving the call to the method and the bag that is the method’s one argument.
Include sufficient comments to fully specify the method.  
Note that the union of two bags might contain duplicate items. For example, if object x occurs
five times in one bag and twice in another, the union of these bags contains x seven times.
Specifically, suppose that bag1 and bag2 are Bag objects, where Bag implements BagInterface;
bag1 contains the String objects a, b, and c; and bag2 contains the String objects b, b, d, and e.
After the statement  

`BagInterface<String> everything = bag1.union(bag2);`

executes, the bag everything contains the strings a, b, b, b, c, d, and e. Note that union does not
affect the contents of bag1 and bag2.  
Implement the union method in ArrayBag class  
```java

```