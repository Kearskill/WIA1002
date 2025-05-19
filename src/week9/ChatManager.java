package week9;
// Group Tutorial [OCC10 & OCC 11] (Kami Budak DS)
// Group Members:
// Student 1 - Dania (OCC10) -- Testcase✅ - Singly LinkedList
// Student 2 - Nabilah (OCC11) -- Testcase✅ -Indexed List
// Student 3 - Ameer & Amri (OCC11) -- Testcase✅ - Doubly LinkedList with Cursor
// Student 4 - Mariam (OCC11) -- Testcase ✅ - Undo/Redo with Stack
// Student 5 - Kearney (OCC11) -- ok - Testing

import java.util.Stack;

public class ChatManager {
    // ===== Student 1 =====
    // [Dania Batrisyia],OCC10 – Singly Linked List
    static class SinglyLinkedList {
        static class Node {
            String data;
            Node next;

            Node(String data) {
                this.data = data;
            }
        }

        int size = 0;
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

    // ===== Student 2 =====
    // [Nurul Nabilah],OCC11 – Indexed List
    static class SinglyLinkedListIndexed extends SinglyLinkedList {
        void addAt(int index, String msg) {
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException("Invalid index");
            }

            Node newNode = new Node(msg);

            if (index == 0) {
                newNode.next = head;
                head = newNode;
            } else {
                Node curr = head;
                for (int i = 0; i < index - 1; i++) {
                    curr = curr.next;
                }
                newNode.next = curr.next;
                curr.next = newNode;
            }

            size++;
        }

        String removeAt(int index) {
            if (index < 0 || index >= size || head == null) {
                throw new IndexOutOfBoundsException("Invalid index");
            }

            Node removed;

            if (index == 0) {
                removed = head;
                head = head.next;
            } else {
                Node curr = head;
                for (int i = 0; i < index - 1; i++) {
                    curr = curr.next;
                }
                removed = curr.next;
                curr.next = curr.next.next;
            }

            size--;
            return null;
        }
    }

    // ===== Student 3 =====
    // [Ameer Zafran] [Amri Amsyar] , OCC11 – Doubly Linked List with Cursor

    //static so that we can directly make an instance of it
    //if non-static -> ChatManager.DoublyLinkedList list = manager.new DoublyLinkedList
    static class DoublyLinkedListWithCursor {
        static class Node {
            String data;
            Node prev, next;

            Node(String data) {
                this.data = data;
            }
        }

        Node head, tail, cursor;

        void insertAtCursor(String msg) {
            Node newNode = new Node(msg);
            if (cursor == null) {
                head = tail = cursor = newNode;
            } else {
                newNode.prev = cursor;
                newNode.next = cursor.next;
                if (cursor.next != null) {
                    cursor.next.prev = newNode;
                } else {
                    tail = newNode;
                }
                cursor.next = newNode;
                cursor = newNode;
            }
        }

        void moveLeft() {
            if (cursor != null && cursor.prev != null) {
                cursor = cursor.prev;
            }
        }

        void moveRight() {
            if (cursor != null && cursor.next != null) {
                cursor = cursor.next;
            }
        }

        void print() {
            Node current = head;
            while (current != null) {
                if (current == cursor) {
                    System.out.print("[" + current.data + "] <-> ");
                } else {
                    System.out.print(current.data + " <-> ");
                }
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


    // ===== Student 5 =====
    // [Kearney] , OCC11 – Testing
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

        // Student 2 [Nabilah]: Indexed List
        SinglyLinkedListIndexed indexList = new SinglyLinkedListIndexed();
        System.out.println("Test for Indexed List");

        // Add at index 0, for the message daijobu
        indexList.addAt(0, "Daijobu");

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


        // Student 4 [Mariam]: Undo/Redo with Stack
        UndoRedoManager manager = new UndoRedoManager();
        System.out.println("Test for Undo/Redo with Stack");

        // msg 1
        manager.perform("add:Hi");

        // msg 2
        manager.perform("remove:Bye");
        System.out.println("Undo : " + manager.undo());
        System.out.println("Redo : " + manager.redo());
        manager.printStacks();
    }
}
