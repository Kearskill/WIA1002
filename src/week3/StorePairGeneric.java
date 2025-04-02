package week3;
public class StorePairGeneric<T extends Comparable<T>> implements Comparable<StorePairGeneric<T>>{
    private T first, second;
    public StorePairGeneric(T first, T second) {
        this.first = first;
        this.second = second;
    }
    public T getFirst() {
        return first;
    }
    public T getSecond() {
        return second;
    }
    public void setPair(T first, T second) {
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
    }

    @Override
    public int compareTo(StorePairGeneric<T> other){
        return this.first.compareTo(other.first);
    }

    public static void main(String[] args) {
        StorePairGeneric a = new StorePairGeneric("ABC",2);
        StorePairGeneric b = new StorePairGeneric(4,"UM is me");
        System.out.println(a);
        System.out.println(a.equals(a));
        System.out.println(a.equals(b));
    }
}