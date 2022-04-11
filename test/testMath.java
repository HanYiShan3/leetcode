package org.test;

/**
 * @author yishan
 */
public class testMath {
    /**
     *
     * @param arr
     */
 public static void bubbleSort(int[] arr) {
  for (int i = 0; i < arr.length - 1; i++) {
   for (int j = 0; j < arr.length - 1 - i; j++) {
    if (arr[j] > arr[j + 1]) {
     int temp = arr[j];
     arr[j] = arr[j + 1];
     arr[j + 1] = temp;
    }
   }
  }
 }

    public static void main(String[] args) {
        int[] arr = {1, 4, 10, 2, 7, 6, 5, 9, 8, 3};
        bubbleSort(arr);
        for (int j : arr) {
            System.out.println(j);
        }
    }
}