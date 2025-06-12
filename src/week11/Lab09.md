**<ins>Lab: Searching and Sorting</ins>**

Selection sort orders a list of values by repetitively putting a particular value
into its final position. The search strategy is as follows:

1. Scan list, find the smallest value in the list
2. Switch it with the value in the first position
3. Find the next smallest value in the list
4. Switch it with the value in the second position
5. Repeat until all values are in their proper places

Given the following array,  
arr = {45, 7, 2, 8, 19, 3}  

Q1-Implement selection sort according to the search strategy shown above.

The method signature is given as:  
`public void selectionSortSmallest(int[] arr)`



Q2-Modify your answer in Q1 so that it uses the largest value in the list in
Step1 and 3 of the search strategy. The method signature is given as  

`public void selectionSortLargest(int[] arr)`
 

Q3-In the test program, display the values of array, arr after the sorting
operation. Ensure that you invoke both implemented  

`selectionSortSmallest(int[] arr)` and `selectionSortLargest(int[] arr)` to reorder
the values.

Q4- Suppose you have an integer array of eight elements
(10,34,2,56,7,67,88,42). Your task is to sort this array in ascending order
using the insertion sort algorithm. 