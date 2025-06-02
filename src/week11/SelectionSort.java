package week11;

public class SelectionSort {
    public void selectionSort(int[] list){
        for (int i = 0; i < list.length; i++) {
            int currentMin = list[i];
            int currentMinIndex = i;

            for (int j = i+1; j <list.length ; j++) {
                if (currentMin > list[j]){
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }

            if (currentMinIndex != i){
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }
        }
    }
}
