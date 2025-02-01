package Sorting;

public class SelectionSort {
    public static int[] selectionSort(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            for(int j = i; j < arr.length; j++) {
                if (arr[j]<arr[i]) {
                    temp = arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {9, 1, 8, 2, 7, 3, 6, 4, 5};
        int[] newArr=selectionSort(arr);
        for (int x : newArr) {
            System.out.print(x + " ");
        }
    }
}
