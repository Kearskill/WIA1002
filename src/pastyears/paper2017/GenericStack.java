package pastyears.paper2017;
import java.util.ArrayList;
import java.util.Scanner;

public class GenericStack<E> implements StackInterface<E>{
    private ArrayList<E> stack;

    public GenericStack(){
        stack = new ArrayList<>();
    }

    public int getSize(){
        return stack.size();
    }

    public E peek(){
        if(!isEmpty()){
            return stack.get(stack.size() - 1);
        }
        return null;
    }

    public E pop(){
        if(!isEmpty()){
            return stack.remove(stack.size() - 1);
        }
        return null;
    }

    public void push(E element){
        stack.add(element);
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    @Override
    public String toString(){
        return stack.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GenericStack<String> bookPile = new GenericStack<>();

        System.out.println("Create a new stack: an empty pile of books");
        System.out.println("isEmpty() returns " + bookPile.isEmpty());

        System.out.println("\nPush 3 books to the pile: ");
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter book title " + (i+ 1) + ": ");
            String title = sc.nextLine();
            bookPile.push(title);
        }

        System.out.println("\nThe new books that you added are: " + bookPile);
        System.out.println("\nThe pile should not be empty:");
        System.out.println("\nisEmpty() returns "+  bookPile.isEmpty());
        System.out.println("The pile has " + bookPile.getSize() + " ");

        System.out.println("\nGet the top book and remove the top book:");

        while(!bookPile.isEmpty()){
            String topBook = bookPile.peek();
            System.out.println(topBook + " is at the top of the pile.");
            System.out.println(topBook + " is removed from the pile.");
            bookPile.pop();
            System.out.println();
        }

        System.out.println("The pile should be empty:");
        System.out.println("isEmpty() returns " + bookPile.isEmpty());

        sc.close();
    }
}
