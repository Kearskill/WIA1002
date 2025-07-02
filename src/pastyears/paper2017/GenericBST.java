package pastyears.paper2017;
import java.util.Stack;

public class GenericBST <E extends Comparable<E>> {
    private static class Node<E>{
        E data;
        Node<E> left, right;
        public Node(E data){
            this.data = data;
            left = null;
            right = null;
        }
    }

    private Node<E> root;

    public GenericBST(){
        this.root = null;
    }

    public boolean add(Node<E> node, E item){
        if (node == null){
            root = new Node<>(item);
            return  true;
        }

        Node<E> current = node; // this is the head
        while (1 + 2 == 3){
            int cmp = item.compareTo(current.data);
            if (cmp == 0){
                return false;
            } else if (cmp<0){
                if (current.left == null) {
                    current.left = new Node<>(item);
                    return true;
                }
                current = current.left;
            } else{
                if (current.right == null){
                    current.right =     new Node<>(item);
                    return true;
                }
                current = current.right;
            }
        }
    }

    public boolean add(E item){
        if (root == null){
            root = new Node<>(item);
            return true;
        }
        return add(root,item);
    }

    public void printTreeInOrder(){
        Stack<Node<E>> stack = new Stack<>();
        Node<E> current = root;

        while(current != null || !stack.isEmpty()){
            while(current != null){
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            System.out.print(current.data + " ");
            current = current.right;
        }
        System.out.println();
    }

    public boolean contains(E item){
        Node<E> current = root;

        while( current!= null) {
            int cmp = item.compareTo(current.data);
            if (cmp == 0){
                return true;
            } else if (cmp <0){
                current = current.left;
            } else{
                current = current.right;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        GenericBST<Integer> bst = new GenericBST<>();

        bst.add(50);
        bst.add(30);
        bst.add(70);
        bst.add(20);
        bst.add(40);

        bst.printTreeInOrder();

        System.out.println(bst.contains(50));
        System.out.println(bst.contains(727));
    }
}
