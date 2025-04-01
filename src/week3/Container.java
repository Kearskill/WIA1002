package week3;

// Create a generic class called Container that accepts one parameter, T.
class Container<T> {
    // Declare a private variable, t of type T
    private T t;

    Container() { // Create a no-arg constructor.
    }

    // Create a method, add that returns nothing, accepting a
    // parameter of generic type
    void add(T t) {
        // Initialize this parameter to the initially declared variable
        this.t = t;
    }

    // Create a generic
    // method called retrieve() that returns the initially declared variable
    T retrieve() {
        return t;
    }

    // Create a main method within the Container class
    public static void main(String[] args) {
        // Create two containers of type Integer and String.
        // Append two objects to the containers, one of type Integer having value 50, another of type String
        // having value Java.

        Container container1 = new Container();
        container1.add(50);

        Container container2 = new Container();
        container2.add("Java");

        // Display the Integer and String objects from the respective containers.
        System.out.println("Container Integer: " + container1.retrieve());
        System.out.println("Container String: " + container2.retrieve());
    }
}
