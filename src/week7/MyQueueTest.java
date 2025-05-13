package week7;

public class MyQueueTest {
    public static void main(String[] args) {
//        a. Have an initialize queue items consists of Durian and Blueberry in a fruitQ
        String[] initiallizeFruits = {"Durian", "Blueberry"};
        MyQueue<String> fruitQueue = new MyQueue<>(initiallizeFruits);

//        b. Then add new items in the following order: Apple, Orange, Grapes, Cherry.
        fruitQueue.enqueue("Apple");
        fruitQueue.enqueue("Orange");
        fruitQueue.enqueue("Grapes");
        fruitQueue.enqueue("Cherry");

//        c. Display the queue.
        System.out.println("Queue: " + fruitQueue.toString());

//        d. Show the top item.
        System.out.println("Top item: " +fruitQueue.peek());

//        e. Get the queue size.
        System.out.println("Queue size: "+ fruitQueue.getSize());

//        f. Delete Durian.
        MyQueue<String> tempQueue = new MyQueue<>();
        while(!fruitQueue.isEmpty()){
            String item = fruitQueue.dequeue();
            if(!item.equals("Durian")){
                tempQueue.enqueue(item);
            }
        }
        fruitQueue = tempQueue;
        System.out.println("After removing Durian: " + fruitQueue.toString());

//        g. Get item in index position of 2
        System.out.println("Item in position 2 : " + fruitQueue.getElement(2));

//        h. Check whether the queue consists of Cherry
        System.out.println("Cherry in the queue : " + fruitQueue.contains("Cherry"));

//        i. Check whether the queue consists of Durian
        System.out.println("Durian in the queue : " + fruitQueue.contains("Durian"));

//        j. Display the queue using the isEmpty() condition
        if (!fruitQueue.isEmpty()){
            System.out.println("Final Queue: " + fruitQueue.toString());
        } else{
            System.out.println("Queue is empty.");
        }
    }
}

