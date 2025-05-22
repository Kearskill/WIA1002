**<ins>Lab 7: Graph</ins>**<br>

1. The addEdge method in WeightedGraph.java adds only directed edges. Create an
   addUndirectedEdge method that creates undirected edges. This method receives two vertices
   and a weight and return a boolean

```java
import java.util.*;

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
}


public class Edge {
   public int u;
   public int v;
   public double weight;

   public Edge(int u, int v, double weight) {
      this.u = u;
      this.v = v;
      this.weight = weight;
   }
}
```

2. Create a method removeEdge that removes an edge if the source and destination of the edge
   is given.
```java
package week8;
import java.util.List;

public class WeightedGraph {
    protected List<List<Edge>> neighbors;

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
```

3. We do not need weighted graphs all the time. Based on the framework of the weighted
   graph12, create a class Graph.java for unweighted graphs. Implement both addEdge and
   addUndirectedEdge methods.

```java
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

```

4. Modify the TestWeightedGraph.java in the lecture notes to test the Graph class created in
   question 3.
```java
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
```