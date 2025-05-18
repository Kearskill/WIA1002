package week8;
import java.util.LinkedList;

public class GraphList {
    private static final int V = 9;

    LinkedList<Integer>[] adjList;

    public GraphList(){
        adjList = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int src, int dest){
        adjList[src].add(dest);
    }

    public void printGraph(){
        char[] labels = {'A','B','C','D','E','F','G','H','I'};
        for (int i = 0; i < V; i++) {
            System.out.print(labels[i] + ": ");
            for (int node: adjList[i]) {
                System.out.print(labels[node] +  " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GraphList grph = new GraphList();

//        A : C, D
//B : D
//C : E, F
//D : E
//E : G
//F : H
//G : H
//H : I
//I : (none)
        grph.addEdge(0,2); // A to C
        grph.addEdge(0,3); // A to D
        grph.addEdge(1,3); // B to D
        grph.addEdge(2,4); // C to E
        grph.addEdge(2,5); // C to F
        grph.addEdge(3,4); // D to E
        grph.addEdge(4,6); // E to G
        grph.addEdge(5,7); // F to H
        grph.addEdge(6,7); // G to H
        grph.addEdge(7,8); // H to I

        grph.printGraph();
    }
}
