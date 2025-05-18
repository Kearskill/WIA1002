package week6;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class MyStack<E> {
    ArrayList<E> list = new ArrayList<E>();

    public int getSize() {
        return list.size();
    }

    public void push(E o) { // push is add
        list.add(o);
    }

    public E pop() { // pop is remove
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        E o = list.get(getSize() - 1);
        list.remove(getSize() - 1);
        return o;
    }

    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list.get(getSize() - 1);
    }

    public Boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        return "stack " + list.toString();
    }

   /* public boolean search(E o){
        return list.contains(o);
    }

    public int search (E o){
        if (list.contains(o)){
            return 1;
        } else{
            return 0;
        }
    }*/

    /*public int search(E o) {
        int index = 0;
        if (list.contains(o)) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).equals(o)) {
                    index = i;
                } else {
                    index = 0;
                }

            }
        }
        return index;
    }*/

    public int search(E o) {
        for (int i = list.size() - 1, pos = 1; i >= 0; i--, pos++) {
            if (list.get(i).equals(o)) {
                return pos; // 1-based position from the top
            }
        }
        return -1; // Not found
    }
}
