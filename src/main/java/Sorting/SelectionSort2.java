package Sorting;

public class SelectionSort2 {

    public static int[] selectionSort(int[] arr) {
        int minIndex, swap;
        for (int j = 0; j < arr.length - 1; j++) {
            minIndex = j;
            for (int i = j + 1; i < arr.length; i++) {
                if (arr[i] < arr[minIndex]) {
                    minIndex = i;
                }
            }
            swap = arr[j];
            arr[j] = arr[minIndex];
            arr[minIndex] = swap;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {52985,3,8525,1940186,1349,58246};
        int[] newArr = selectionSort(arr);
        for (int x : newArr) {
            System.out.print(x + " ");
        }
    }
}
