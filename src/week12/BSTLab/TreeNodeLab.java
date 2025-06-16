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
