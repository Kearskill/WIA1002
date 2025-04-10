**Tutorial: ADTs**   
Question 1:  
Consider the following problem:  
A new candy machine is purchased for the cafeteria, but it is not working properly. The candy
machine has four dispensers to hold and release items sold by the candy machine as well as a
cash register. The machine sells four products—candies, chips, gum, and cookies—each stored
in a separate dispenser. You have been asked to write a program for this candy machine so that it
can be put into operation.  
The program should do the following:

- Show the customer the different products sold by the candy machine.
- Let the customer make the selection.
- Show the customer the cost of the item selected.
- Accept the money from the customer.
- Return the change.
- Release the item, that is, make the sale.

You can see that the program you are about to write is supposed to deal with dispensers and cash
registers. That is, the main objects are four dispensers and a cash register.
Because all the dispensers are of the same type, you need to create a class, say, Dispenser, to create
the dispensers. Similarly, you need to create a class, say, CashRegister, to create a cash register.  
You will create the class CandyMachine containing the four dispensers, a cash register, and the
application program.    
Your tasks are to design ADTs to represent the three classes:  
a. Identify the instance variables for each of the class (i.e. Dispenser, Cash Register, Candy
Machine)  
b. Identify the methods/operations for each of the class (i.e. Dispenser, Cash Register, Candy
Machine)  
c. Produce a UML class diagram to represent the three classes

```java
package week4;

import java.util.Scanner;

public class CandyMachine {
    private Dispenser[] dispensers;
    private CashRegister cashRegister;

    CandyMachine() {
        dispensers = new Dispenser[]{
                new Dispenser("Candies", 30, 8),
                new Dispenser("Chips", 200, 7),
                new Dispenser("Gum", 50, 5),
                new Dispenser("Cookies", 100, 6)
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

    public void start() {
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

class CashRegister {
    private int cash;

    CashRegister(int cash) {
        this.cash = cash;
    }

    public boolean canBuy(int payment, int cost) {
        return payment >= cost;
    }

    public int calcChange(int payment, int cost) {
        // ONLY USE IF canBuy() is checked
        return payment - cost;
    }

    public void addCash(int amount) {
        if (amount > 0) {
            cash += amount;
        }
    }

}

class Dispenser {
    private String name;
    private int price;
    private int quantity;

    Dispenser(String name, int price, int quantity) {
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


    public boolean isSufficient(int quantity) {
        return this.quantity >= quantity;
    }

    public boolean isAvailable() {
        return quantity >= 1;
    }

    public void makeSale() {
        if (quantity > 0) {
            quantity--;
        }
    }
}
```

Question 2:  
A bid for installing an air conditioner consists of the name of the company, a description of the
unit, the performance of the unit, the cost of the unit, and the cost of installation. Design an ADT
that represents a single bid for installing an air conditioning unit. Write a Java interface named
BidInterface to specify the following ADT operations by stating its purpose, precondition,
postcondition, parameters using javadoc-style comments:

- Returns the name of the company making this bid.
- Returns the description of the air conditioner that this bid is for.
- Returns the capacity of this bid's AC in tons (1 ton = 12,000 BTU).
- Returns the seasonal efficiency of this bid's AC (SEER).
- Returns the cost of this bid's AC.
- Returns the cost of installing this bid's AC.
- Returns the yearly cost of operating this bid's AC.

```java
package week4;

public interface BidInterface {
    /**Return the name of the company making this bid.
     * @return the name in String*/
    public String getName();

    /**Returns the description of the air conditioner that this bid is for
     * @return the description in String*/
    public String getDescription();

    /**Returns the capacity of this bid's AC in tons
     * @param btu the unit to be converted
     * @return the capacity of this bid's AC in tons*/
    public double getCapacity(double btu);

    /**Returns the seasonal efficiency of this bid's AC (SEER)
     * @return the seasonal efficiency of this bid's AC (SEER)*/
    public double getSeer();

    /**Returns the cost of this bid's AC
     * @return the cost of this bid's AC*/
    public double getAcCost();

    /**Returns the cost of installing this bid's AC
     * @return the cost of installing this bid's AC*/
    public double getInstallCost();

    /**Returns the yearly cost of operating this bid's AC
     * @return the yearly cost of operating this bid's AC*/
    public double getOperatingCost();
}
```

Then design another ADT to represent a collection of bids. The second ADT should include
methods to search for bids based on price and performance. Also note that a single company could
make multiple bids, each with a different unit. Write a Java interface named
BidCollectionInterface to specify the following ADT operations by stating its purpose,
precondition, postcondition, parameters using javadoc-style comments:

- Adds a bid to this collection.
- Returns the bid in this collection with the best yearly cost.
- Returns the bid in this collection with the best initial cost. The initial cost will be defined
  as the unit cost plus the installation cost.
- Clears all of the items from this collection.
- Gets the number of items in this collection.
- Sees whether this collection is empty.

```java
package week4;

public interface BidCollectionInterface {
  /**Adds a bid to this collection*/
  public void addBid();

  /**Returns the bid in this collection with the best yearly cost
   * @return the bid the best yearly cost*/
  public double getBestYearlyCost();

  /**Returns the bid in this collection with the best 
   * @return bid as (unit cost + installation cost)*/
  public double getBestInitialCost();

  /**Clears all the items from this collection*/
  public void clearAllItems();

  /**Gets the number of items in this collection
   * @return number of items in the collection*/
  public int getNumberOfItems();

  /**Sees whether this collection is empty
   * @return true if the collection is empty*/
  public boolean isEmpty();
}
```