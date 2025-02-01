package Sorting;

public class InsertionSort {
//    9, 1, 8, 2, 7, 3, 6, 4, 5

    public static int[] insertionSort(int[] arr) {
        int temp = 0;
        int j;
        for (int i = 1; i < arr.length; i++) {
            temp = arr[i];
            for (j = i; j > 0 && greater(arr[j-1], temp); j--) {
                System.out.println("arr[j-1]: " + arr[j-1] + " -> arr[j]: " + arr[j]);
                arr[j] = arr[j-1];
            }
            arr[j] = temp;
            for (int x : arr) {
                System.out.print(x + " ");
            }
            System.out.println("");
        }
        return arr;
    }

    public static boolean greater(int num1, int num2) {
        return num1 > num2;
    }

    public static void main(String[] args) {
        int[] arr = {9, 1, 8, 2, 7, 3, 6, 4, 5};
        int[] newArr=insertionSort(arr);
        System.out.println("");
        for (int x : newArr) {
            System.out.print(x + " ");
        }
    }

}
