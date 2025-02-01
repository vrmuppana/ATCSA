package Sorting;

public class MergeSort {

    public static void merge(int[] leftArray, int[] rightArray, int[] arr) {
        int l = 0;
        int r = 0;
        // L > 1 2 3 4
        // R > 5 6 7 8
        for (int i = 0; i < arr.length; i++) {

            if (leftArray[l] <= rightArray[r]) {
                l++;
                arr[i] = leftArray[l];
            }
            else {
                r++;
                arr[i] = rightArray[r];
            }

        }
    }

    public static void mergeSort(int[] arr) {

        if (arr.length==1) return;

        int half = arr.length/2;
        int[] leftArray = new int[half];
        int[] rightArray = new int[arr.length-half];

        for (int i = 0; i < arr.length; i++) {
            if (i<half)
                leftArray[i] = arr[i];
            else
                rightArray[i-half]=arr[i];
        }
//        System.out.print("\nAfterLeftArray: ");
//        for (int i = 0; i < leftArray.length; i++) {
//            System.out.print(leftArray[i] + " ");
//        }
//        System.out.print("\nAfterRightArray: ");
//        for (int i = 0; i < rightArray.length; i++) {
//            System.out.print(rightArray[i] + " ");
//        }

        mergeSort(leftArray);

        mergeSort(rightArray);
        merge(leftArray, rightArray, arr);
    }



    public static void main(String[] args) {
        int[] arr = {9, 1, 8, 2, 7, 3, 6, 4, 5};
        mergeSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
