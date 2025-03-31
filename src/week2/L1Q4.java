package week2;

import org.w3c.dom.ls.LSOutput;

import javax.sound.midi.Track;
import java.util.ArrayList;
import java.util.Date;
/*An Account class was specified in Question 3. Design a new Account1 class as follows:
■ Add a new data field name of the String type to store the name of the customer.
■ Add a new constructor that constructs an account with the specified name, id, and balance.
■ Add a new data field named transactions whose type is ArrayList that stores the transaction
for the accounts. Each transaction is an instance of the Transaction class. The Transaction class
is defined as shown in figure below.
■ Modify the withdraw and deposit methods to add a transaction to the transactions array list.
■ All other properties and methods are the same as in Question 3.

Write a test program that creates an Account1 object with annual interest rate 1.5%, balance
1000, id 1122, and name George. Deposit $30, $40, and $50 to the account and withdraw $5, $4,
and $2 from the account. Print an account summary that shows account holder name, interest
rate, balance, and all transactions.*/
public class L1Q4 {
    public static void main(String[] args) {
        System.out.println("Start program.");
        AccountQ4 testAcc = new AccountQ4("George",1122,1000,1.5);
        testAcc.display();

        System.out.println("After depositing $30, $40, $50");
        testAcc.deposit(30);
        testAcc.deposit(40);
        testAcc.deposit(50);
        testAcc.display();

        System.out.println("After withdrawing $5, $4, $2");
        testAcc.withdraw(5);
        testAcc.withdraw(4);
        testAcc.withdraw(2);
        testAcc.display();
        System.out.println("End program.");
    }
}

class AccountQ4 extends AccountQ3{
    private String name;
    private ArrayList<Transactions> transactions;

    AccountQ4(String name,int id,double balance, double annualInterestRate){
        super(id, balance,annualInterestRate); // Call to 'super()' must be first statement in constructor body
        this.name = name;
        this.transactions = new ArrayList<>();
    }
    private class Transactions{
        private Date date;
        private char type; // 'W' for withdraw, 'D' for deposit
        private double amount;
        private double balance;
        private String description;

        Transactions(char type, double amount, double balance,String description){
            this.type = type;
            this.amount = amount;
            this.balance = balance;
            this.description = description;
            date = new Date();
        }

        @Override
        public String toString(){
            return "\nType: " + type +"\nAmount: "+amount+"\nBalance: "+balance+"\nDescription: "+description+"Date: "+date+"\n";
        }
    }

    @Override
    boolean withdraw(double moneyWithdraw){
        if (getBalance() > moneyWithdraw) {
            setBalance(getBalance()-moneyWithdraw);
            Transactions transaction = new Transactions('W',moneyWithdraw,getBalance(),"Withdrawn");
            transactions.add(transaction);
            return true;
        } else {
            return false;
        }
    }
    @Override
    void deposit(double moneyDeposit){
        setBalance(getBalance() + moneyDeposit);
        Transactions transaction = new Transactions('D',moneyDeposit,getBalance(),"Deposited");
        transactions.add(transaction);
    }

    void display(){
        System.out.println("Account holder name:" + name +".");
        System.out.println("Annual Interest rate: " + getAnnualInterestRate() +"%");
        System.out.println("Balance: $" +roundTo2Places(getBalance()));
        System.out.println("Transations: ");
            for (Transactions skibidi : transactions) {
                System.out.println(skibidi);
            }
        System.out.println();
    }

    private double roundTo2Places(double num){
        return Math.round(num * 100.0) / 100.0;
    }
}
