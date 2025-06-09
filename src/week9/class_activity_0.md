Scenario:

You are part of a software engineering team developing a Smart City Traffic Monitoring System. The city’s road network is modeled as a graph, where:

• Intersections are represented as vertices (nodes).

• Roads connecting intersections are edges, and

• The input/output of vertices represent traffic volume.

Your task is to calculate the total traffic for each intersection using the strategy we discussed in class.

Objective:

Write a Java program that:

1. Uses a 2D array to represent the traffic of nodes.

2. Applies the traffic calculation strategy explained in class to compute the total traffic for each node.

3. Displays the traffic amount for each node clearly.



Remember: You can use the strategy for calculating traffic for each node that we covered in class. This involves summing up all the weights of the edges connected to each node in the matrix. You also can use another strategy for calculation of traffic amount for each vertex.

```java
package week9;

public class NetworkTrafficAnalyzer {

    public static void main(String[] args) {
        // Example: traffic[i][j] = traffic from node i to node j
        int[][] traffic = {
                {0, 10, 5, 0},
                {2, 0, 3, 8},
                {4, 1, 0, 6},
                {0, 0, 7, 0}
        };

        int numNodes = traffic.length;

        // To store total traffic per node
        int[] incomingTraffic = new int[numNodes];
        int[] outgoingTraffic = new int[numNodes];

        // Calculate incoming and outgoing traffic
        for (int i = 0; i < numNodes; i++) {
            for (int j = 0; j < numNodes; j++) {
                outgoingTraffic[i] += traffic[i][j]; // sum of row i
                incomingTraffic[j] += traffic[i][j]; // sum of column j
            }
        }

        // Display results
        System.out.println("Intersection Traffic Summary:");
        System.out.println("-----------------------------");
        for (int i = 0; i < numNodes; i++) {
            int total = incomingTraffic[i] + outgoingTraffic[i];
            System.out.println("Node " + i +
                    " -> Incoming: " + incomingTraffic[i] +
                    ", Outgoing: " + outgoingTraffic[i] +
                    ", Total: " + total);
        }
    }
}
```