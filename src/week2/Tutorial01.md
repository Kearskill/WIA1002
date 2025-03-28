**1.** Write the definition of a class Telephone that contains:
   - An instance variable areaCode
   - An instance variable number
   - A static variable numberOfTelephoneObject that keeps track of the number of Telephone 
   objects created
   - A constructor that accepts two arguments used to initialize the two instance variables
   - The accessor and mutator methods for areaCode and number
   - A method makeFullNumber that does not accept any argument, concatenates areaCode
   and number with a dash in between, and returns the resultant String.

Write the statements to:

Instantiate 5 Telephone objects and store them in an array. Iterate through the array to
print the full number of the 5 Telephone objects on the console. Your output should look
as below:
- 03-79676300
- 03-79676301
- 03-79676302
- 03-79676303
- 03-79676304


```java
class Telephone{
    private String areaCode;
    private String number;
    private int numberOfTelephoneObject;

    public Telephone(String areaCode, String number){
        this.areaCode = areaCode;
        this.number = number;
        numberOfTelephoneObject++;
    }
    public Telephone(){
        this.areaCode = null;
        this.number = null;
        numberOfTelephoneObject++;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String makeFullNumber(){
        return areaCode + "-" + number;
    }
}

class Main{
    public static void main(String[] args) {
        Telephone[] phones = new Telephone[5];
        int a = 79676300;
        for (int i = 0; i < phones.length; i++) {
            phones[i] = new Telephone("03",Integer.toString(a));
            a++;
        }

        for (int i = 0; i < phones.length; i++) {
            System.out.println(phones[i].makeFullNumber());
        }
    }
}
```
**2.** What is the output for the following? Explain.
```java
class Person {
    public Person() {
        System.out.println("(1) Performs Person's tasks");
    }
}

class Employee extends Person {
    public Employee() {
        this("(2) Invoke Employee's overloaded constructor");
        System.out.println("(3) Performs Employee's tasks ");
    }

    public Employee(String s) {
        System.out.println(s);
    }
}

public class Faculty extends Employee {
    public Faculty() {
        System.out.println("(4) Performs Faculty's tasks"); 
    }
    public static void main(String[] args) {
        new Faculty();
    }
}
```

From psvm (driver class), we can observe it starts from Faculty instance.

Faculty instance calls Employee instance (super class) before executing inside, so number 4 is on hold.

Employee instance calls Person instance (super class of Employee)

Person instance is the grandmother of classes, so it prints that out first (message 1)

After that, the process goes back to Employee, and Employee `this(message)` call its own instance to print out String s (message 2), and prints out third (message 3)

Finally it goes back to Faculty instance, and last message is printed (message 4)

The order goes `1 --> 2 --> 3 --> 4`


**3.** What is the output for the following? Explain.
```java
public class C {
    public static void main(String[] args) {
        Object[] o = {new A(), new B()};
        System.out.print(o[0]);
        System.out.print(o[1]);
    }
}

class A extends B {
    public String toString() {
        return "A";
    }
}

class B {
    public String toString() {
        return "B";
    }
}
```

I see a lack of @Override, thus I think both will output superclass (B)

`BB`

I stand corrected, its `AB`

**4.** Write a class definition for an abstract class, Vehicle, that contains:
   - a double instance variable, maxSpeed
   - a protected double instance variable, currentSpeed
   - a constructor accepting a double used to initialize the maxSpeed instance variable
   - an abstract method, accelerate, that accepts no parameters and returns nothing.
   - a method getCurrentSpeed that returns the value of currentSpeed
   - a method getMaxSpeed that returns the value of maxSpeed
   - a method pedalToTheMetal, that repeatedly calls accelerate until the speed of the vehicle
   is equal to maxSpeed. pedalToTheMetal returns nothing.

Can you create an instance of Vehicle?

```java
abstract class Vehicle {
    private double maxSpeed;
    protected double currentSpeed;

    public Vehicle(double maxSpeed){
        this.maxSpeed = maxSpeed;
        this.currentSpeed = 0.0;
    }

    public abstract void accelerate();

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public double getMaxSpeed(){
        return maxSpeed;
    }

    public void pedalToTheMetal(){
        if(currentSpeed<maxSpeed){
            accelerate();
        }
    }
}
```
No, I cannot directly make an instance of abstract class.

**5.** Assume the existence of an interface, Account, with the following methods:
   - deposit: accepts an integer parameter and returns an integer
   - withdraw: accepts an integer parameter and return a Boolean
   Define a class, BankAccount, that implements the above interface and has the following
   members:
   - an instance variable named balance
   - a constructor that accepts an integer that is used to initialize the instance variable
   - an implementation of the deposit method that adds its parameter to the balance
   variable. The new balance is returned as the value of the method.
   - an implementation of the withdraw method that checks whether its parameter is less
   than or equal to the balance and if so, decreases the balance by the value of the
   parameter and returns true; otherwise, it leaves the balance unchanged and returns
   false.
```java
interface Account {
    int deposit(int money);
    boolean withdraw(int money);
}

class BankAccount implements Account {
    private int balance;

    public BankAccount(int balance){
        this.balance = balance;
    }

    public int deposit(int deposit_money){
        balance += deposit_money;
        return balance;
    }
    public boolean withdraw(int withdraw_money){
        if(balance >=withdraw_money ){ //if balance more than to be withdrawed
            balance -= withdraw_money;
            return true;
        } else{
            return false;
        }
    }
}
```