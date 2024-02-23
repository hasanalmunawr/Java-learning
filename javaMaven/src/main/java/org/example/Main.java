package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
     
     int[] nums = {1,3,5,6};
     int target = 5;
        // System.out.println(search(nums, target));
        System.out.println("jelo");


    }

    private static int search(int[] arr, int target) {
        int position =0;
        int wadah = 0;

        for(int i = 0; i < arr.length -1; i++) {
            wadah += arr[i];
            if(wadah == target) {
                return position;
            }
            position++;
        }
        return 1;

    }
}