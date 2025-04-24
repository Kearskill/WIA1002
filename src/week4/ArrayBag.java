//package week4;
//
//public class ArrayBag<T> implements BagInterface<T> {
//    private T[] bag;
//    private int DEFAULT_CAPACITY;
//    private int numberOfEntries;
//
//    public ArrayBag() {
//        this.DEFAULT_CAPACITY = 25;
//        numberOfEntries = 0;
//        this.bag = (T[]) new Object[DEFAULT_CAPACITY];
//    }
//
//    public int getCurrentSize() {
//        return numberOfEntries;
//    }
//
//    public boolean isFull() {
//        return numberOfEntries == DEFAULT_CAPACITY;
//    }
//
//    public boolean isEmpty() {
//        return numberOfEntries == 0;
//    }
//
//    public boolean add(T newEntry) {
//        if(isFull()){
//            return false;
//        }
//        bag[numberOfEntries] = newEntry;
//        numberOfEntries++;
//        return true;
//    }
//
//    public T remove(){
//        if(isEmpty()){
//            return null;
//        }
//        T removedItem = bag[numberOfEntries-1];
//        remove(removedItem);
//        numberOfEntries--;
//        return removedItem;
//    }
//
//    public boolean remove (T anEntry){
//        if (isEmpty() || anEntry == null) {
//            return false;
//        }
//
//        for (int i = 0; i < numberOfEntries; i++) {
//            if (anEntry.equals(bag[i])) {
//                // Shift all elements after index i left by one
//                for (int j = i; j < numberOfEntries - 1; j++) {
//                    bag[j] = bag[j + 1];
//                }
//                bag[numberOfEntries - 1] = null; // Clear last position
//                numberOfEntries--;
//                return true;
//            }
//        }
//        return false; // Entry not found
//    }
//
//    public void clear(){
//        for (int i = 0; i < numberOfEntries; i++) {
//            bag[i] = null;
//        }
//        numberOfEntries = 0;
//    }
//
//    public int getFrequencyOf(T anEntry){
//        int cnt=0;
//        for (int i = 0; i < numberOfEntries; i++) {
//            if (anEntry.equals(bag[i])) {
//                cnt++;
//            }
//        }
//        return cnt;
//    }
//
//    public boolean contains(T anEntry){
//        for (int i = 0; i < numberOfEntries; i++) {
//            if (anEntry.equals(bag[i])) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public T[] toArray(){
//        T[] result = (T[]) new Object[numberOfEntries]; // unchecked cast
//
//        // Copy elements from bagArray to the result array
//        System.arraycopy(bag, 0, result, 0, numberOfEntries);
//
//        return result;
//    }
//
//    public BagInterface<T> union(BagInterface<T> otherbag){
//        ArrayBag<T> result = new ArrayBag<>();
//
//        for (int i = 0; i < numberOfEntries; i++) {
//            result.add(bag[i]);
//        }
//
//        T[] anotherBagArray = otherbag.toArray();
//        for (T item : anotherBagArray) {
//            result.add(item);
//        }
//
//        return result;
//    }
//    }
//
//    // Write an ArrayBag class that implement the BagInterface, as shown in the UML diagram
//    // below. Set the DEFAULT_CAPACITY to 25.
//    public static void main(String[] args) {
//        ArrayBag arrayBag = new ArrayBag();
//        System.out.println("Is array bag empty : "+arrayBag.isEmpty());
//        System.out.println("Is array bag full : "+arrayBag.isFull());
//        arrayBag.add("Hello");
//        System.out.println("Is array bag empty : "+arrayBag.isEmpty());
//        // too lazy to test man
//
//
//        BagInterface<String> everything = bag1.union(bag2);
//    }
//}
