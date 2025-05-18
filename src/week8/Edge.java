package week8;

public class Edge <T extends Comparable<T>, N extends Comparable<N>>{
    Vertex<T,N> toVertex;
    N weight;
    Edge<T,N> nextEdge;

    public Edge(){
        toVertex = null;
        weight = null;
        nextEdge = null;
    }

    public Edge(Vertex<T,N> destination, N weight, Edge<T,N> nextEdge){
        toVertex = destination;
        this.weight = weight;
        this.nextEdge = nextEdge;
    }
}
