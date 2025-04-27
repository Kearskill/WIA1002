package week5;

public class TestLinkedList {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();

        // a. Append the following: a, b, c, d, e
        list.addLast("a");
        list.addLast("b");
        list.addLast("c");
        list.addLast("d");
        list.addLast("e");

        // b. Print all the elements in the list.
        System.out.println("List elements:");
        list.print();

        // c. Reverse all the elements in the list.
        System.out.println("Reversed list:");
        list.reverse();

        // d. Retrieve the number of elements in the list.
        System.out.println("Number of elements: " + list.size());

        // e. Retrieve the first and last value.
        System.out.println("First element: " + list.getFirst());
        System.out.println("Last element: " + list.getLast());

        // f. Delete the third value (index 2)
        System.out.println("Removed third value: " + list.remove(2));

        // g. Retrieve index location for the second and third value
        System.out.println("Index of 'b': " + list.indexOf("b"));
        System.out.println("Index of 'd': " + list.indexOf("d")); // now at index 2

        // h. Check if the list has the value ‘c’
        System.out.println("Contains 'c'? " + list.contains("c"));

        // i. Replace the items individually with: j, a, v, a
        list.set(0, "j");
        list.set(1, "a");
        list.set(2, "v");
        list.set(3, "a");

        // Final list
        System.out.println("Final replaced list:");
        list.print();
    }
}
