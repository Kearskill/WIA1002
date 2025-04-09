package week4;
import java.util.Scanner;

public class CandyMachine {
    private Dispenser[] dispensers;
    private CashRegister cashRegister;

    CandyMachine(){
        dispensers = new Dispenser[]{
                new Dispenser("Candies",30,8),
                new Dispenser("Chips",200,7),
                new Dispenser("Gum",50,5),
                new Dispenser("Cookies",100,6)
        };
        cashRegister = new CashRegister(1000); // $100
    }

    private void processTransaction(Dispenser dispenser, Scanner scanner) {
        if (!dispenser.isAvailable()) {
            System.out.println("Sorry, this item is out of stock.");
            return;
        }

        System.out.println("Cost: " + dispenser.getPrice() + " cents");
        System.out.print("Please enter your money (in cents): ");
        int payment = scanner.nextInt();

        if (!cashRegister.canBuy(payment, dispenser.getPrice())) {
            System.out.println("Insufficient payment. Transaction cancelled.");
            return;
        }

        int change = cashRegister.calcChange(payment, dispenser.getPrice());
        cashRegister.addCash(dispenser.getPrice());
        dispenser.makeSale();

        System.out.println("Item dispensed: " + dispenser.getName());
        System.out.println("Change returned: " + change + " cents");
    }

    public void start(){
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Welcome to the Candy Machine!");
            System.out.println("Please choose a product:");
            for (int i = 0; i < dispensers.length; i++) {
                System.out.printf("%d. %s - %d cents (%d left)\n",
                        i + 1, dispensers[i].getName(),
                        dispensers[i].getPrice(),
                        dispensers[i].getQuantity());
            }
            System.out.println("5. Exit");

            int choice = scanner.nextInt();

            if (choice == 5) {
                running = false;
                System.out.println("Thank you for using the Candy Machine!");
            } else if (choice >= 1 && choice <= 4) {
                processTransaction(dispensers[choice - 1], scanner);
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }


    public static void main(String[] args) {
        CandyMachine obj = new CandyMachine();
        obj.start();
    }
}

class CashRegister{
    private int cash;

    CashRegister(int cash){
        this.cash = cash;
    }

    public boolean canBuy(int payment, int cost){
        return payment >= cost;
    }

    public int calcChange(int payment, int cost){
        // ONLY USE IF canBuy() is checked
        return payment - cost;
    }

    public void addCash(int amount) {
        if (amount > 0) {
            cash += amount;
        }
    }

}

class Dispenser{
    private String name;
    private int price;
    private int quantity;

    Dispenser(String name, int price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }


    public int getPrice() {
        return price;
    }


    public int getQuantity() {
        return quantity;
    }


    public boolean isSufficient(int quantity){
        return this.quantity >= quantity;
    }

    public boolean isAvailable(){
        return quantity>=1;
    }

    public void makeSale(){
        if (quantity>0){
            quantity--;
        }
    }
}