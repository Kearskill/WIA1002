package week3;

public class Duo<A, B> {
    private A first;
    private B second;

    Duo(A first, B second) {
        this.first = first;
        this.second = second;
    }

    public String toString() {
        return "(" + first + ", " + second + ")";
    }

    public static void main(String[] args) {
        Duo<String, Integer> sideShape = new Duo<>("Square", 5);
        Duo<Double, Double> points = new Duo<>(2.3, 4.5);

        System.out.print("Side shape: ");
        System.out.println(sideShape);
        System.out.print("Points: ");
        System.out.println(points);
    }
}


