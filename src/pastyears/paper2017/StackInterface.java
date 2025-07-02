package pastyears.paper2017;

public interface StackInterface<E> {
    /** A method that returns the number of elements in this stack.
    */
    int getSize();

    /**  A method that returns the top element in this stack.
     * */
    E peek();

    /** A method that returns and removes the top element in this stack.
     * */
    E pop();

    /** A method that adds a new element to the top of this stack.
    * */
    void push(E element);

    /** A method that returns true if the stack is empty.
     * */
    boolean isEmpty();
}
