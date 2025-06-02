package week11;

public class LinearSearch {
    private static int linearSearch(int[] list, int key){
        for (int i = 0; i < list.length; i++) {
            if (key == list[i]){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] list = {3,8,12,34,54,85,61,110};
        System.out.println(linearSearch(list, 45));
        System.out.println(linearSearch(list, 54));
    }
}
