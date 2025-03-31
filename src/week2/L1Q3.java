package week2;
/*
Question 3
Implement a class named Account that contains:
■ A private int data field named id for the account (default 0).
■ A private double data field named balance for the account (default 0).
■ A private double data field named annualInterestRate that stores the current interest rate
(default 0). Assume all accounts have the same interest rate.
■ A private Date data field named dateCreated that stores the date when the account was
created.
■ A no-arg constructor that creates a default account.
■ A constructor that creates an account with the specified id and initial balance.
■ The accessor and mutator methods for id, balance, and annualInterestRate.
■ The accessor method for dateCreated.
■ A method named getMonthlyInterestRate() that returns the monthly interest rate.
■ A method named getMonthlyInterest() that returns the monthly interest.
■ A method named withdraw that withdraws a specified amount from the account.
■ A method named deposit that deposits a specified amount to the account.
(Hint: The method getMonthlyInterest() is to return monthly interest, not the interest rate.
Monthly interest is balance * monthlyInterestRate. monthlyInterestRate is
annualInterestRate / 12. Note that annualInterestRate is a percentage, e.g., like 4.5%. You
need to divide it by 100.) Write a test program that creates an Account object with an account ID
of 1122, a balance of $20,000, and an annual interest rate of 4.5%. Use the withdraw method to
withdraw $2,500, use the deposit method to deposit $3,000, and print the balance, the monthly
interest, and the date when this account was created.
*/

import java.time.LocalDateTime;
import java.util.Date;

public class L1Q3 {
    public static void main(String[] args) {
        AccountQ3 testAcc = new AccountQ3(1122, 20000.0, 4.5);
        System.out.println("Basic info:");
        System.out.println("ID: " + testAcc.getId());
        System.out.println("Balance: " + testAcc.getBalance());
        System.out.println("Annual Interest Rate: " + testAcc.getAnnualInterestRate());
        System.out.println("Date Created: " + testAcc.getDateCreated()+"\n");
        testAcc.withdraw(2500.0);
        System.out.println("Balance after withdrawing 2500$: "+testAcc.getBalance()+"\n");
        testAcc.deposit(3000.0);
        System.out.println("Balance after depositing 3000$: "+testAcc.getBalance());
        System.out.println("Monthly Interest: " + testAcc.getMonthlyInterest()+"$");
    }
}

class AccountQ3 {
    private int id;
    private double balance;
    private double annualInterestRate;
    private Date dateCreated;

    AccountQ3() { // no arg constructor
        id = 0;
        balance = 0.0;
        annualInterestRate = 0.0;
        dateCreated = new Date();
    }

    AccountQ3(int id, double balance) { //id and balance constructor
        this.id = id;
        this.balance = balance;
        annualInterestRate = 0.0;
        dateCreated = new Date();
    }

    AccountQ3(int id, double balance, double annualInterestRate) { // id, balance and annualInterestRate constructor
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
        dateCreated = new Date();
    }

    int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    }

    double getBalance() {
        return balance;
    }

    void setBalance(double balance) {
        this.balance = balance;
    }

    double getAnnualInterestRate() {
        return annualInterestRate;
    }

    void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    Date getDateCreated() {
        return dateCreated;
    }

    double getMonthlyInterestRate() {
        return annualInterestRate / 12.0 / 100.0;
    }

    double getMonthlyInterest() {
        return balance * getMonthlyInterestRate();
    }

    boolean withdraw(double moneyWithdraw) {
        if (balance > moneyWithdraw) {
            balance -= moneyWithdraw;
            return true;
        } else {
            return false;
        }
    }

    void deposit(double moneyDeposit){
        balance += moneyDeposit;
    }

}