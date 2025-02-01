package Sorting;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {5, 1, 2, 4, 3, 7, 6, 4, 2, 7, 9, 0, 1, 2, 6, 9, 3};
        int[] newArr=bubbleSort(arr);
        for (int x : newArr) {
            System.out.print(x + " ");
        }
    }

    public static int[] bubbleSort(int[] arr) {
        int temp = 0;

        for (int j = 0; j < arr.length; j++) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    for (int x : arr) {
                        System.out.print(x + " ");
                    }
                    System.out.println("");
                }
//
//
            }
        }
        return arr;
    }
}
