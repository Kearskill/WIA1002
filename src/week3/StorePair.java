package week3;

public class StorePair implements Comparable<StorePair>{
    private int first, second;
    public StorePair(int first, int second) {
        this.first = first;
        this.second = second;
    }
    public int getFirst() {
        return first;
    }
    public int getSecond() {
        return second;
    }
    public void setPair(int first, int second) {
        this.first = first;
        this.second = second;
    }
    public String toString() {
        return "first = " + first + " second = " + second;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        } else{
            return false;
        }
        // return this == obj;
    }

    @Override
    public int compareTo(StorePair other){
        return Integer.compare(this.first, other.first);
    }

    public static void main(String[] args) {
        /*Create a test program that creates three objects of the StorePair
        generic class called a, b and c. Set the first and second values of a,
        b, c as (6,4), (2,2), (6,3).*/
        StorePairGeneric a = new StorePairGeneric(6,4);
        StorePairGeneric b = new StorePairGeneric(2,2);
        StorePairGeneric c = new StorePairGeneric(6,3);

        /*Invoke the compareTo()and equals() methods that compares the
        three objects created in (d) in the test program.*/
        System.out.println(a.compareTo(b));
        System.out.println(a.compareTo(c));
        System.out.println(b.compareTo(a));
        System.out.println(b.compareTo(c));
        System.out.println(c.compareTo(a));
        System.out.println(c.compareTo(b));

        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
        System.out.println(b.equals(a));
        System.out.println(b.equals(c));
        System.out.println(c.equals(a));
        System.out.println(c.equals(b));
    }
}