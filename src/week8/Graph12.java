package week8;

public class Graph12<T extends Comparable<T>, N extends Comparable<N>>{
    Vertex<T,N> head;
    int size;

    public Graph12(){
        head = null;
        size = 0;
    }

    public int getSize(){
        return this.size;
    }
}
