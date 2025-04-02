package week3;

public class L2Q4<T extends Comparable<T>> implements <Comparable<T>>{


    @Override
    public String toString(){
        return "Min = " + max + "\nMin = " + min;
    }


    public static void main(String[] args) {
        Integer[] intArray = {5,3,7,1,4,9,8,2};
        String[] strArray = {"red", "blue", "orange", "tan"};

//        minmax() method returns “Min = 1 Max = 9” For intArray
//        minmax() method returns “Min = blue Max = tan” for strArray
    }
}
