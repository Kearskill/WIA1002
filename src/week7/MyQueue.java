package week7;
import java.util.LinkedList;

public class MyQueue<E> {
    private LinkedList<E> list;
//a. public MyQueue(E[] e)
    public MyQueue(E[] e){
        list = new LinkedList<>();
        for (E item: e){
            list.add(item);
        }
    }

//b. public MyQueue()
    public MyQueue(){
        list = new LinkedList<>();
    }

//c. public void enqueue(E e)
    public void enqueue(E e){
        list.addLast(e);
    }

//d. public E dequeue()
    public E dequeue(){
        if(!isEmpty()){
            return list.removeFirst();
        }
        return null;
    }

//e. public E getElement(int i)
    public E getElement(int i){
        if (i>=0 && i< list.size()){
            return list.get(i);
        }
        return null;
    }

//f. public E peek()
    public E peek(){
        if (!isEmpty()){
            return list.getFirst();
        }
        return null;
    }

//g. public int getSize()
    public int getSize(){
        return list.size();
    }

//h. public boolean contains(E e)
    public boolean contains(E e){
        return list.contains(e);
    }

//i. public boolean isEmpty();
    public boolean isEmpty(){
        return list.isEmpty();
    }

//j. public String tostring()
    public String toString(){
        return list.toString();
    }
}
