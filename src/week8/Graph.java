package week8;
import java.util.List;
import java.util.ArrayList;

public class Graph {
    protected List<List<Integer>> neighbors;

    public Graph(int numVertices) {
        neighbors = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            neighbors.add(new ArrayList<>());
        }
    }

    public boolean addEdge(int u, int v) {
        if (!neighbors.get(u).contains(v)) {
            neighbors.get(u).add(v);
            return true;
        }
        return false;
    }

    public boolean addUndirectedEdge(int u, int v) {
        boolean added1 = addEdge(u, v);
        boolean added2 = addEdge(v, u);
        return added1 && added2;
    }

    public boolean removeEdge(int u, int v) {
        return neighbors.get(u).remove((Integer)v);
    }

    public boolean removeUndirectedEdge(int u, int v) {
        boolean removed1 = removeEdge(u, v);
        boolean removed2 = removeEdge(v, u);
        return removed1 && removed2;
    }

    public void printGraph() {
        for (int i = 0; i < neighbors.size(); i++) {
            System.out.print(i + ": ");
            for (int j : neighbors.get(i)) {
                System.out.print("-> " + j + " ");
            }
            System.out.println();
        }
    }
}
