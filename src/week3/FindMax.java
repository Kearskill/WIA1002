package week3;

public class FindMax {
    public static <E extends Comparable<E>> E max(E[] list){
        if (list == null || list.length == 0){
            return null;
        }

        E max = list[0];
        for (E a : list){
            if(a.compareTo(max)>0){ // if more than 0, a > max
                max = a;
            }
        }
        return max;
    }

    public static void main(String[] args) {
//        int[] array_a = {1,2,3}; // banned, use Integer rather than int
        Integer[] array_a = {1,2,3};
        String[] array_b = {"red","green","blue"};
//        Circle[] array_c = {new Circle(3), new Circle(2.9), new Circle(5.9)}; // banned, where is new Circle?
        /*Circle[] array_c = new Circle[]{
                new Circle(3),
                new Circle(2.9),
                new Circle(5.9),
        };*/ // banned, where is Circle<>()? why use Circle()

        Circle[] array_c = new Circle[]{
                new Circle<>(3.0),
                new Circle<>(2.9),
                new Circle<>(5.9),
        };

        System.out.println("Max array a: " + max(array_a));
        System.out.println("Max array b: " + max(array_b));
        System.out.println("Max array c: " + max(array_c));
    }
}

class Circle <T extends Comparable<T>> implements Comparable<Circle<T>>{
    private T radius;
    Circle(T radius){
        this.radius = radius;
    }

    public T getRadius(){
        return radius;
    }

    public void setRadius(T radius){
        this.radius = radius;
    }

    @Override
    public int compareTo(Circle<T> other) {
        return this.radius.compareTo(other.radius);
    }

    @Override
    public String toString(){
        return radius.toString();
    }
}