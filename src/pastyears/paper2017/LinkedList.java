package pastyears.paper2017;


public class LinkedList {
    static class Node {
        String brand;
        int sold;
        Node next;

        public Node(String brand, int sold) {
            this.brand = brand;
            this.sold = sold;
            this.next = null;
        }
    }

    private Node head;

    // Insert in the beginning
    public void insertFirstLinked(String brand, int sold){
        Node newNode = new Node(brand, sold);
        newNode.next = head;
        head = newNode;
    }

    // Add after a specific brand
    public void addAfter(String targetBrand, String newBrand, int sold){
        Node current = head;
        int count = 1;

        System.out.println("Adding "+ newBrand + " after " + targetBrand + " ");
        while (current != null){
            if (current.brand.equals(targetBrand)){
                Node newNode = new Node(newBrand, sold);
                newNode.next = current.next;
                current.next = newNode;
                System.out.println("Found " + targetBrand + " which is handbag number "  + count + " in the linked list.\n");
                return;
            }
            current = current.next;
            count++;
        }
        // if not found
        System.out.println(targetBrand + " not found in the list.");
    }

    // Remove a node by brand
    public void removeLink(String targetBrand){
        Node current = head;
        Node previous = null;
        int count = 1;

        System.out.println("Removing " + targetBrand + "..");
        while (current != null){
            if (current.brand.equals(targetBrand)){
                if (previous == null) {
                    head = current.next;
                } else{
                    previous.next = current.next;
                }
                System.out.println("Found a match.. " +targetBrand+ " is handbag number " + count  + " in the linked list.\n");
                return;
            }
            previous = current;
            current = current.next;
            count++;
        }
    }

    public void display(){
        Node current = head;
        System.out.println("Displaying the Linked List *************************************");
        while(current!= null){
            System.out.println(current.brand  + ": " + String.format("%,d",current.sold)  + " Sold.");
            current=  current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insertFirstLinked("Tods", 500000000);
        list.insertFirstLinked("Prada", 1000000);
        list.insertFirstLinked("Chanel", 100000000);
        list.insertFirstLinked("Louis Vuitton", 10000000);

        list.display();

        list.addAfter("Chanel","Coach",10000000);

        list.display();

        list.addAfter("Coach", "Mulberry", 90000000);

        list.display();

        list.removeLink("Chanel");

        list.display();

        list.removeLink("Coach");

        list.display();
    }

}
