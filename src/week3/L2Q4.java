package week3;

public class L2Q4 {
    // why do i use T?
    // = Although its a collection (array), i still need to individually check for
    //   min and max.
    public static <T extends Comparable<T>> String minmax(T[] array) {
        if (array == null || array.length == 0) {
            return "Min = null Max = null";
        }

        T min = array[0];
        T max = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i].compareTo(min) < 0) {
                min = array[i];
            }
            if (array[i].compareTo(max) > 0) {
                max = array[i];
            }
        }

        return String.format("Min = %s Max = %s", min, max);
    }


    public static void main(String[] args) {
        Integer[] intArray = {5, 3, 7, 1, 4, 9, 8, 2};
        String[] strArray = {"red", "blue", "orange", "tan"};

//        minmax() method returns “Min = 1 Max = 9” For intArray
        System.out.println(minmax(intArray));
//        minmax() method returns “Min = blue Max = tan” for strArray
        System.out.println(minmax(strArray));

        String[] skibidiArray = {"toilets","cameramen","YouTube","Turkish animator","DaFuqBoom","Slenderman"};
        // sorted by lexicographically (A-Z, a-z)
        System.out.println(minmax(skibidiArray));
    }
}
