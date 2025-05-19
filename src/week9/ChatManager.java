package week9;
// Group Tutorial [Kami Budak DS]
// Group Members:
// Student 1 - Dania
// Student 2 - Nabila
// Student 3 - Ameer & Amri
// Student 4 - Mariam
// Student 5 - Kearney
import java.util.Stack;

public class ChatManager {
    // Student 1 [Dania] - Singly Linked List
    static class SinglyLinkedList {
        static class Node {
            String data;
            Node next;

            Node(String data) {
                this.data = data;
            }
        }

        Node head, tail;

        void addFirst(String msg) {
            Node newNode = new Node(msg);
            newNode.next = head;
            head = newNode;
            if (tail == null) {
                tail = head;
            }
        }

        void addLast(String msg) {
            Node newNode = new Node(msg);
            if (tail == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        String removeFirst() {
            if (head == null) return null;
            String removedData = head.data;
            head = head.next;
            if (head == null) {
                tail = null;
            }
            return removedData;
        }

        void print() {
            Node current = head;
            while (current != null) {
                System.out.print(current.data + " -> ");
                current = current.next;
            }
            System.out.println("null");
        }
    }



    // ===== Student 4 =====
    // [Mariam Shazlinda] , OCC11 – Undo/Redo with Stack

    static class UndoRedoManager {
        Stack<String> undo = new Stack<>();
        Stack<String> redo = new Stack<>();

        void perform(String action) {
            undo.push(action);
            redo.clear();
        }

        String undo() {
            if (!undo.isEmpty()) {
                String action = undo.pop();
                redo.push(action);
                return action;
            }
            return null;
        }


        String redo() {
            if (!redo.isEmpty()) {
                String action = redo.pop();
                undo.push(action); // try tukar
                return action;
            }
            return null;
        }

        void printStacks() {
            System.out.println("Undo Stacks:  " + undo);
            System.out.println("Redo Stacks:  " + redo);
        }
    }



    public static void main(String[] args) { // Testing by Student 5 [Kearney]
        // Student 1 [Dania]:  Singly linked list
        SinglyLinkedList list = new SinglyLinkedList();
        System.out.println("Test for Singly Linked List");
        // Add to the first index of the list
        list.addFirst("Hello");

        // Add to the last index of the list
        list.addLast("How are you?");

        list.print();

        // Remove the first element of the list
        list.removeFirst();

        // Print list
        list.print();

        /*// Student 2 [Nabilah]: Indexed List
        SinglyLinkedListIndexed indexList = new SinglyLinkedListIndex();
        System.out.println("Test for Indexed List");

        // Add at index 1, for the messsage "I'm fine"
        indexList.addAt(1, "I'm fine");

        // Remove node at index 0
        indexList.removeAt(0);

        // Print all indexList
        indexList.print();

        // Student 3 [Ameer & Amri]: Doubly Linked List with Cursor
        DoublyLinkedListWithCursor history = new DoublyLinkedListWithCursor();
        System.out.println("Test for Doubly Linked List with Cursor");
        // Insert at cursor (current index)
        history.insertAtCursor("Hi");
        history.insertAtCursor("Bye");

        // Move to the left
        history.moveLeft();

        // Insert at cursor (current index)
        history.insertAtCursor("Wait");

        // Print all history
        history.print(); // expected output: Hi <-> [Wait] <-> Bye <-> null
*/
        // Student 4 [Mariam]: Undo/Redo with Stack
        UndoRedoManager manager = new UndoRedoManager();
        System.out.println("Test for Undo/Redo with Stack");
        //
        manager.perform("add:Hi");
        manager.perform("remove:Bye");
        System.out.println("Undo : " + manager.undo());
        System.out.println("Redo : " + manager.redo());
        manager.printStacks();
    }
}
