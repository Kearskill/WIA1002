package pastyears.paper2017;

import java.util.ArrayList;

public interface StackInterface<T> {
    /** A constructor that creates an empty stack.
     * */
//    ArrayList<T> stack = new ArrayList<>();

    /** A method that returns the number of elements in this stack.
    */
    int getSize();

    /**  A method that returns the top element in this stack.
     * */
    T peek();

    /** A method that returns and removes the top element in this stack.
     * */
    T pop();

    /** A method that adds a new element to the top of this stack.
    * */
    void push(T element);

    /** A method that returns true if the stack is empty.
     * */
    boolean isEmpty();
}
