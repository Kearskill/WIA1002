package week6;
import java.util.Scanner;

public class TestIntMyStack {
    public static void main(String[] args) {
        MyStack<Integer> s1 = new MyStack<Integer>();
        Scanner sc =new Scanner(System.in);

        System.out.println("Please enter an integer: ");
        int value = sc.nextInt();
        for (int i = 1; i <= value; i++) {
            s1.push(i);
        }

        System.out.println(s1);
        System.out.println("The size of the stack is " + s1.getSize());
        System.out.println("Popping the stack: ");
        while(!s1.isEmpty()){
            int intValue = s1.pop();
            System.out.print(intValue +  " ");
        }
        System.out.println("\n");
    }
}
