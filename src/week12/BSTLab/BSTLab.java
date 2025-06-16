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

