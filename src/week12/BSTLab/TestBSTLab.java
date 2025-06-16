package week12.BSTLab;
import java.util.ArrayList;

public class TestBSTLab {
    public static void main(String[] args) {
        BSTLab<Integer> tree = new BSTLab<>();
        int[] data = {45, 88, 54, 76, 98, 1, 2, 20, 6, 53, 42, 100, 86, 32, 28, 65, 14};

        for (int num : data) {
            tree.insert(num);
        }

        System.out.print("Inorder (sorted): ");
        tree.inorder();

        System.out.print("Postorder: ");
        tree.postorder();

        System.out.print("Preorder: ");
        tree.preorder();

        System.out.println("Height of BST: " + tree.height());
        System.out.println("Root for BST is: " + tree.getRoot());
        System.out.println("Check whether 10 is in the tree? " + tree.search(10));

        tree.delete(53);
        System.out.print("Updated Inorder data (sorted): ");
        tree.inorder();

        System.out.println("Min Value: " + tree.minValue());
        System.out.println("Max Value: " + tree.maxValue());

        ArrayList<TreeNodeLab<Integer>> path = tree.path(6);
        System.out.print("A path from the root to 6 is: ");
        for (TreeNodeLab<Integer> node : path) {
            System.out.print(node.element + " ");
        }
        System.out.println();
    }
}
