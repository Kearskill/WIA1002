package week6;
import java.util.Stack;
import java.util.Scanner;

public class TowerOfHanoiUsingStacks {
    public static int N;
    public static Stack<Integer>[] tower = new Stack[4];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        tower[1] = new Stack<Integer>(); // Column 1
        tower[2] = new Stack<Integer>(); // Column 2
        tower[3] = new Stack<Integer>(); // Column 3

        System.out.println("Enter the number of disks: ");
        int num = sc.nextInt();
        N = num;
        toh(num); // basically play button
    }

    private static void toh(int n){
        for (int d = n; d>0;d--){
            tower[1].push(d);
        }
        display();
        move(n,1,2,3);
    }

    private static void move(int n,int a,int b,int c){
        if (n>0){
            move(n-1,a,c,b);
            int d = tower[a].pop();
            tower[c].push(d);
            display();
            move(n-1,b,a,c);
        }
    }

    private static void display(){
        System.out.println(" A | B | C ");
        System.out.println("-----------");
        for (int i = N-1; i >=0 ; --i) {
            String d1 = " ";
            String d2 = " ";
            String d3 = " ";
            try{
                d1 = String.valueOf(tower[1].get(i));
            } catch (Exception e){}

            try{
                d2 = String.valueOf(tower[2].get(i));
            } catch (Exception e){}

            try{
                d3 = String.valueOf(tower[3].get(i));
            } catch (Exception e){}

            System.out.println(" "+d1+" | " +d2+" | "+ d3);
        }
        System.out.println("\n");
    }
}
