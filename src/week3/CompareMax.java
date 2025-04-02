package week3;

public class CompareMax{
    private static <E extends Comparable> E maximum(E a, E b, E c){
        if(a.compareTo(b) > 0 && a.compareTo(c) > 0){ //Unchecked call to 'compareTo(T)' as a member of raw type 'java.lang.Comparable'
            return a;
        } else if (b.compareTo(a) > 0 && b.compareTo(c)>0){
            return b;
        } else if (c.compareTo(a) > 0 && c.compareTo(b)>0){
            return c;
        } else{
            return a;
        }
    }

    public static void main(String[] args) {
        System.out.println(maximum(2,4,3));
        System.out.println(maximum(3.5,2.4,7.5));
        System.out.println(maximum(-3.0,5.4,0.0));
//        System.out.println("Abc","UM IS ONE","Java"); this is yabai
    }
}
/*
create a generic static method called
maximum where the generic type extends the Comparable interface,
which receives three parameters. Find the maximum of three values
invoked by the main method.
*/
