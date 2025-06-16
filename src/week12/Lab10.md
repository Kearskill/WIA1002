**<ins>Lab: Binary Search Tree</ins>**<br>


Question 1<br>
Create a package called BST and implement a node class called TreeNode<E> and Binary
Search Tree Class called BST<E>. Both the BST<E> and TreeNode<E> classes extends
Comparable.<br>
a) Include necessary declaration in the BST<E> and TreeNode<E> classes.  

b) Implement the following methods in class BST<E>: <br>
i. `public boolean search(E e)`  
Returns true if the element is in the tree


ii. `public boolean insert(E e)`  
Insert element o into the binary tree and return true if the element is inserted
successfully  

iii. `public int getSize()`  
Get the number of nodes in the tree

iv. `public int height()and private int height(TreeNode<E> node)`  
Returns the height of the BST

v. `public E getRoot()`  <br>
Returns the root of the BST

vi. `public E minValue()`<br>
Returns the minimum value of the BST

vii. `public E maxValue()`<br>
Returns the maximum value of the BST

viii. `public java.util.ArrayList<TreeNode<E>> path(E e)`<br>
Returns a path from the root leading to the specified element

ix. `public boolean delete(E e)`<br>
Delete an element from the binary tree. Return true if the element is deleted
successfully, and return false if the element is not in the tree

x. `public boolean clear()`<br>
Remove all elements from the tree

xi. `protected void inorder(TreeNode<E> root)`<br>
Display inorder traversal from a subtree

xii. `protected void postorder(TreeNode<E> root)`<br>
Display postorder traversal from a subtree

xiii. `protected void preorder(TreeNode<E> root)`<br>
Display preorder traversal from a subtree

c) Write a test program called TestBST in the BST package. Using the appropriate
methods you implemented in BST<E>, produce the following output:<br>

Input Data: 45, 88, 54, 76, 98, 1, 2, 20, 6, 53, 42, 100, 86, 32, 28, 65, 14<br>
Inorder (sorted): 1 2 6 14 20 28 32 42 45 53 54 65 76 86 88 98 100<br>
Postorder: 14 6 28 32 42 20 2 1 53 65 86 76 54 100 98 88 45<br><br>
Preorder: 45 1 2 20 6 14 42 32 28 88 54 53 76 65 86 98 100<br>
Height of BST: 6<br>
Root for BST is: 45<br>
Check whether 10 is in the tree? false<br>
Delete 53<br>
Updated Inorder data (sorted): 1 2 6 14 20 28 32 42 45 54 65 76 86 88 98 100<br>
Min Value :1<br>
Max Value :100<br>
A path from the root to 6 is: 45 1 2 20 6<br> 


BSTLab
```java
package week12.BSTLab;

import java.util.ArrayList;

public class BSTLab<E extends Comparable<E>> implements Comparable<BSTLab<E>> {
    private TreeNodeLab<E> root;
    private int size = 0;

    public boolean search(E e) {
        TreeNodeLab<E> current = root;
        while (current != null) {
            if (e.compareTo(current.element) < 0) current = current.left;
            else if (e.compareTo(current.element) > 0) current = current.right;
            else return true;
        }
        return false;
    }

    public boolean insert(E e) {
        if (root == null) {
            root = new TreeNodeLab<>(e);
        } else {
            TreeNodeLab<E> parent = null;
            TreeNodeLab<E> current = root;
            while (current != null) {
                if (e.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else {
                    return false; // Duplicate
                }
            }
            if (e.compareTo(parent.element) < 0)
                parent.left = new TreeNodeLab<>(e);
            else
                parent.right = new TreeNodeLab<>(e);
        }
        size++;
        return true;
    }

    public int getSize() {
        return size;
    }

    public int height() {
        return height(root);
    }

    private int height(TreeNodeLab<E> node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public E getRoot() {
        return root != null ? root.element : null;
    }

    public E minValue() {
        if (root == null) return null;
        TreeNodeLab<E> current = root;
        while (current.left != null)
            current = current.left;
        return current.element;
    }

    public E maxValue() {
        if (root == null) return null;
        TreeNodeLab<E> current = root;
        while (current.right != null)
            current = current.right;
        return current.element;
    }

    public ArrayList<TreeNodeLab<E>> path(E e) {
        ArrayList<TreeNodeLab<E>> list = new ArrayList<>();
        TreeNodeLab<E> current = root;
        while (current != null) {
            list.add(current);
            if (e.compareTo(current.element) < 0)
                current = current.left;
            else if (e.compareTo(current.element) > 0)
                current = current.right;
            else
                break;
        }
        return list;
    }

    public boolean delete(E e) {
        TreeNodeLab<E> parent = null;
        TreeNodeLab<E> current = root;

        while (current != null && !current.element.equals(e)) {
            parent = current;
            if (e.compareTo(current.element) < 0)
                current = current.left;
            else
                current = current.right;
        }

        if (current == null) return false;

        // Case 1: No left child
        if (current.left == null) {
            if (parent == null)
                root = current.right;
            else if (e.compareTo(parent.element) < 0)
                parent.left = current.right;
            else
                parent.right = current.right;
        }

        // Case 2: Has left child
        else {
            TreeNodeLab<E> parentOfRightMost = current;
            TreeNodeLab<E> rightMost = current.left;

            while (rightMost.right != null) {
                parentOfRightMost = rightMost;
                rightMost = rightMost.right;
            }

            current.element = rightMost.element;

            if (parentOfRightMost.right == rightMost)
                parentOfRightMost.right = rightMost.left;
            else
                parentOfRightMost.left = rightMost.left;
        }

        size--;
        return true;
    }

    public boolean clear() {
        root = null;
        size = 0;
        return true;
    }

    protected void inorder(TreeNodeLab<E> root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.element + " ");
        inorder(root.right);
    }

    protected void postorder(TreeNodeLab<E> root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.element + " ");
    }

    protected void preorder(TreeNodeLab<E> root) {
        if (root == null) return;
        System.out.print(root.element + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public void inorder() {
        inorder(root);
        System.out.println();
    }

    public void postorder() {
        postorder(root);
        System.out.println();
    }

    public void preorder() {
        preorder(root);
        System.out.println();
    }

    @Override
    public int compareTo(BSTLab<E> o) {
        return Integer.compare(this.size, o.size);
    }
}
```

TreeNodeLab
```java
package week12.BSTLab;

public class TreeNodeLab<E extends Comparable<E>> implements Comparable<TreeNodeLab<E>> {
    E element;
    TreeNodeLab<E> left;
    TreeNodeLab<E> right;

    public TreeNodeLab(E e) {
        element = e;
    }

    @Override
    public int compareTo(TreeNodeLab<E> other) {
        return this.element.compareTo(other.element);
    }
}
```

TestBSTLab
```java
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
```

Output:
```text
Inorder (sorted): 1 2 6 14 20 28 32 42 45 53 54 65 76 86 88 98 100 
Postorder: 14 6 28 32 42 20 2 1 53 65 86 76 54 100 98 88 45 
Preorder: 45 1 2 20 6 14 42 32 28 88 54 53 76 65 86 98 100 
Height of BST: 7
Root for BST is: 45
Check whether 10 is in the tree? false
Updated Inorder data (sorted): 1 2 6 14 20 28 32 42 45 54 65 76 86 88 98 100 
Min Value: 1
Max Value: 100
A path from the root to 6 is: 45 1 2 20 6 
```