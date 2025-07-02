package pastyears.paper2017;
import java.util.Stack;
import java.util.regex.Pattern;

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
}
