package week4;

public class ArrayBag<T> implements BagInterface<T> {
    private T[] bag;
    private int DEFAULT_CAPACITY;
    private int numberOfEntries;

    public ArrayBag(int DEFAULT_CAPACITY) {
        this.DEFAULT_CAPACITY = DEFAULT_CAPACITY;
        numberOfEntries = 0;
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
        if(!isFull()){
            return false;
        }
        bag[numberOfEntries] = newEntry;
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
}
// Write an ArrayBag class that implement the BagInterface, as shown in the UML diagram
// below. Set the DEFAULT_CAPACITY to 25.