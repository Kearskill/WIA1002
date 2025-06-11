package week12;

public class TestBSTDelete {
    public static void main(String[] args) {
        BST<String> tree = new BST<String>();

        // these are inserted lexicographically
        tree.insert("George");
        tree.insert("Michael");
        tree.insert("Tom");
        tree.insert("Adam");
        tree.insert("Jones");
        tree.insert("Peter");
        tree.insert("Daniel");
        printTree(tree);

/*Get the last element from the Postorder,
this is your root element, then find that
element in the Inorder and split the elements
in left and right list giving you LEFT: "3 2 1 5 4 6"
and RIGHT: "9 7 11 10" then walk the Postorder list
and split it once you find the first number before
the index of the root element in the Inorder list,
in this case this is "6" so walk till 6 and
this will give you "1 2 3 4 5 6" and the rest is
"9 11 10 7". Then insert those lists in reverse order,
e.g.: "6 5 4 3 2 1" and after that "7 10 11 9" this
should give you the correct order of the tree.*/
        /*Inorder: 3 2 1 5 4 6 8 9 7 11 10
Postorder: 1 2 3 4 5 6 9 11 10 7 8*/

        System.out.println("\nAfter delete George:");
        tree.delete("George");
        printTree(tree);

        System.out.println("\nAfter delete Adam:");
        tree.delete("Adam");
        printTree(tree);

        System.out.println("\nAfter delete Michael:");
        tree.delete("Michael");
        printTree(tree);
    }

    public static void printTree(BST tree) {
        // Traverse tree
        System.out.print("Inorder (sorted): ");
        tree.inorder();
        System.out.print("\nPostorder: ");
        tree.postorder();
        System.out.print("\nPreorder: ");
        tree.preorder();
        System.out.print("\nThe number of nodes is " + tree.getSize());
        System.out.println();
    }
}
