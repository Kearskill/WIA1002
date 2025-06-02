package week11;

public class BinarySearch {
    private static int binarySearch(int[] list, int key){
        int low = 0;
        int high = list.length;

        while (high>= low){
            int mid = (low + high) / 2;
            if (key < list[mid]){
                high = mid - 1;
            } else if (key == list[mid]){
                return mid;
            } else{
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] list = {3, 8, 12, 34, 54, 85, 61, 110};
        SelectionSort a = new SelectionSort();
        a.selectionSort(list);

        System.out.println(binarySearch(list,45)); // -1
        System.out.println(binarySearch(list,54)); // 4
    }
}
