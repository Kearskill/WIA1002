package week8;
public class Vertex <T extends Comparable<T>, N extends Comparable <N>>{
    T vertexInfo;
    int indeg;
    int outdeg;
    Vertex<T,N> nextVertex;
    Edge12<T, N> firstEdge12;

    public Vertex(){
        vertexInfo = null;
        indeg = 0;
        outdeg = 0;
        nextVertex = null;
        firstEdge12 = null;
    }
    public Vertex(T vertexInfo, Vertex<T,N> next){
        this.vertexInfo = vertexInfo;
        indeg = 0;
        outdeg = 0;
        nextVertex = next;
        firstEdge12 = null;
    }
}
