package week8;

public class GraphMatrix{
    public static void main(String[] args) {
        int [][] graph ={
                {0,0,1,1,0,0,0,0,0}, // A
                {0,0,0,1,0,0,0,0,0}, // B
                {0,0,0,0,1,1,0,0,0}, // C
                {0,0,0,0,1,0,0,0,0}, // D
                {0,0,0,0,0,0,1,0,0}, // E
                {0,0,0,0,0,0,0,1,0}, // F
                {0,0,0,0,0,0,0,1,0}, // G
                {0,0,0,0,0,0,0,0,1}, // H
                {0,0,0,0,0,0,0,0,0}, // I
        };

        printGraph(graph);
    }

    private static void printGraph(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}