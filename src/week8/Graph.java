package week8;

public class Graph <T extends Comparable<T>, N extends Comparable<N>>{
    Vertex<T,N> head;
    int size;


    public Graph(){
        head = null;
        size = 0;
    }

    public int getSize(){
        return this.size;
    }
}
