package week9;
// Group Tutorial [Kami Budak DS]
// Group Members:
// Student 1 - Dania
// Student 2 - Nabila
// Student 3 - Ameer & Amri
// Student 4 - Mariam
// Student 5 - Kearney

public class ChatManager {




    public static void main(String[] args) {
        // Student 1 [Dania]:  Singly linked list
        SinglyLinkedList list = new SinglyLinkedList();
        System.out.println("Test for Singly Linked List\n");
        // Add to the first index of the list
        list.addFirst("Hello");

        // Add to the last index of the list
        list.addLast("How are you?");

        // Remove the first element of the list
        list.removeFirst();

        // Print list
        list.print();

        // Student 2 test: Indexed List
        SinglyLinkedListIndexed indexList = new SinglyLinkedListIndex();
        System.out.println("Test for Indexed List");
        indexList.addAt(1, "I'm fine");
        indexList.removeAt(0);
        indexList.print();

        // Student 3 test: Doubly Linked List with Cursor
        DoublyLinkedListWithCursor history = new DoublyLinkedListWithCursor();
        System.out.println("Test for Doubly Linked List with Cursor");
        history.insertAtCursor("Hi");
        history.insertAtCursor("Bye");
        history.moveLeft();
        history.insertAtCursor("Wait");
        history.print(); // expected output: Hi <-> [Wait] <-> Bye <-> null

        // Student 4 test: Undo/Redo with Stack
        UndoRedoManager manager = new UndoRedoManager();
        manager.perform("add:Hi");
        manager.perform("remove:Bye");
        System.out.println("Undo : " + manager.undo());
        System.out.println("Redo : " + manager.redo());
        manager.printStacks();
    }
}
