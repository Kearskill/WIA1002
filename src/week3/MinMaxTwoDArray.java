package week3;

public class MinMaxTwoDArray {
    public static <E extends Comparable<E>> E min(E[][] list){
        if (list==null || list.length==0) {
            return null;
        }
        E min = list[0][0];
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[i].length; j++) {
                if(min.compareTo(list[i][j]) > 0){ // +ve number is a > b
                    min = list[i][j];
                }
            }
        }
        return min;
    }

    public static <E extends Comparable<E>> E max(E[][] list){
        if (list==null || list.length==0) {
            return null;
        }
        E max = list[0][0];
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[i].length; j++) {
                if(max.compareTo(list[i][j]) < 0){ // +ve number is a > b
                    max = list[i][j];
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Integer[][] numbers = {{4,5,6},{1,2,3}};
        System.out.println("Minimum: " + min(numbers));
        System.out.println("Maximum: " + max(numbers));
    }
}
