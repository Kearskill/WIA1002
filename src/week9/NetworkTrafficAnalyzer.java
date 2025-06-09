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
