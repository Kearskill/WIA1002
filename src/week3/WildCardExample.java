package week3;
//Using the <?> wildcard, implement a generic method that displays the list.
import java.util.ArrayList;
public class WildCardExample {
    public static void main(String[] args) {
        ArrayList<Integer> numOfCars = new ArrayList<>();
        ArrayList<Double> milesPerHour = new ArrayList<>();

        numOfCars.add(2);
        numOfCars.add(5);
        numOfCars.add(23);

        milesPerHour.add(23.5);
        milesPerHour.add(60.23);
        milesPerHour.add(20.7);

        System.out.println("Number of cars: ");
        displayList(numOfCars);
        System.out.println("Miles per hour: ");
        displayList(milesPerHour);
    }
    private static void displayList(ArrayList<?> obj){
        for (Object a : obj){
            System.out.print(a +" ");
        }
        System.out.println();
    }
}
