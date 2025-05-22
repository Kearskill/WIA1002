package week8;

public class Edge12<T extends Comparable<T>, N extends Comparable<N>>{
    Vertex<T,N> toVertex;
    N weight;
    Edge12<T,N> nextEdge12;

    public Edge12(){
        toVertex = null;
        weight = null;
        nextEdge12 = null;
    }

    public Edge12(Vertex<T,N> destination, N weight, Edge12<T,N> nextEdge12){
        toVertex = destination;
        this.weight = weight;
        this.nextEdge12 = nextEdge12;
    }
}
