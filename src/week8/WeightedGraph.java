package week8;
import java.util.List;

public class WeightedGraph {
    protected List<List<Edge>> neighbors;

    public boolean addEdge(int u, int v, double weight) {
        neighbors.get(u).add(new Edge(u, v, weight));
        return true;
    }

    public boolean addUndirectedEdge(int u, int v, double weight) {
        boolean added1 = addEdge(u, v, weight);
        boolean added2 = addEdge(v, u, weight);
        return added1 && added2;
    }

    public boolean removeEdge(int u, int v) {
        List<Edge> edges = neighbors.get(u);
        for (int i = 0; i < edges.size(); i++) {
            if (edges.get(i).v == v) {
                edges.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean removeUndirectedEdge(int u, int v) {
        boolean removed1 = removeEdge(u, v);
        boolean removed2 = removeEdge(v, u);
        return removed1 && removed2;
    }
}
