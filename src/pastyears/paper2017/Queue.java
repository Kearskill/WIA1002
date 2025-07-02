package pastyears.paper2017;
import java.util.ArrayList;

public class Queue<E> {
    private ArrayList<E> list;

//    i)
    public Queue (E[] items){
        list = new ArrayList<>();
        for (E item: items){
            list.add(item);
        }
    }

//    ii)
    public Queue (){
        list = new ArrayList<>();
    }

//    iii)
    public void enqueue (E e){
        list.add(e);
    }

//    iv)
    public E dequeue (){
        if (!isEmpty()){
            return list.remove(0);
        }
        return null;
    }

//    v)
    public E getElement (int i){
        if (i>=0 && i< list.size()){
            return list.get(i);
        }
        return null;
    }

//    vi)
    public int getSize(){
        return list.size();
    }

//    vii)
    public boolean isEmpty(){
        return list.isEmpty();
    }

//    viii)
    public String toString(){
        return list.toString();
    }
}
