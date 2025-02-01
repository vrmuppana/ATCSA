package Searching;

public class BinarySearch {

    public static void binarySearch(int[] arr, int target) {
        int min = 0;
        int max = arr.length-1;
        int guess = (min+max)/2;
        for(int i = 0; max-min != 1; i++) {
            if (arr[guess] == target) {
                System.out.println("Target found");
                return;
            }
            if (arr[guess] > target) {
                max = guess - 1;
//                System.out.println(max + " = " + guess + "-1 -> arr[guess]>target" );
            } else {
                min = guess + 1;
//                System.out.println(min + " = " + guess + "+1 -> arr[guess]<target" );
            }
            guess = (min+max)/2;
        }
        if (arr[guess+1]==target)
            System.out.println("Target found");
        else System.out.println("Target not found");
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 7, 9, 13};
        binarySearch(arr, 7);
    }
}
