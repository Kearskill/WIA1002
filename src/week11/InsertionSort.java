package week11;

public class InsertionSort {
    public static void insertionSort(int[] list){
        for (int i = 1; i < list.length; i++) {
            int currentElement = list[i];
            int k;
            for (k = i-1; k >= 0 && list[k]>currentElement; k--) {
                list[k + 1] = list[k];
            }
            list[k + 1] = currentElement;
        }
    }

    public int[] doInsertionSort (int[] input){
        int temp;
        for (int i =1; i < input.length; i++) {
            for (int j = i; j > 0 ; j--) {
                if(input[j] < input[j-1]){
                    temp = input[j];
                    input[j] = input[j-1];
                    input[j-1] = temp;
                }
            }
        }
        return input;
    }
}
