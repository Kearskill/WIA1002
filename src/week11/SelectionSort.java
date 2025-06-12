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

    public void selectionSortSmallest (int[] a){
        for (int i = 0; i < a.length - 1; i++) {
            int j = i;
            for (int k = i+1; k < a.length; k++) {
                if (a[k] < a[j]){
                    j = k;
                }
            }

            int temp = a[j];
            a[j] = a[i];
            a[i] = temp;
        }
    }

    /*public void selectSortLargest (int[] a){
        for (int i = a.length - 1; i > 0 ; i--) {
            int j = 0;
            for (int k = 1; k > i + 1 ; k--) {
                if (a[k])
            }
        }
    }*/
}
