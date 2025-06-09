Tutorial: Sorting and searching
1. Compare between linear search and binary search algorithms by searching for the numbers 45 and
   54 in the following list :<br>
   `3 8 12 34 54 85 61 110`

```java
// Linear Search
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
        System.out.println(linearSearch(list, 45)); // return -1
        System.out.println(linearSearch(list, 54)); // return 4
    }
}
```

```java
// binary search
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
```

2. Describe the technique for each sort algorithm below. Given the following list:<br>
   `90 8 7 56 125 237 9 1 653`<br>
   Show a trace of execution for:<br>
   a. Selection sort<br>
   b. Insertion sort<br>
   c. Bubble sort<br>
   d. Merge sort<br>
3. 
