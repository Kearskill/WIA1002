package week8;

public class TestWeighedGraph {
    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addUndirectedEdge(0, 1);
        g.addUndirectedEdge(0, 2);
        g.addEdge(3, 4);

        System.out.println("Graph after adding edges:");
        g.printGraph();

        g.removeEdge(3, 4);
        g.removeUndirectedEdge(0, 2);

        System.out.println("\nGraph after removing some edges:");
        g.printGraph();
    }
}
