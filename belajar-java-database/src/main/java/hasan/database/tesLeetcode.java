package hasan.database;

import java.util.Arrays;

public class tesLeetcode {

    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int target = 6;

         int[] result =       twoSum(nums, target);
        for (int i = 0; i < result.length-1; i++) {
            System.out.println(result[i]);

        }
    }

    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;

        for(int i = 0; i < n - 1; i++) {
            for(int j = i+1 ; j < n ;j++) {
                if(nums[i] + nums[j] >= target) {
                    return  new int[] {i,j};
                }
            }
        }
        return new int[] {};

    }

    static String pemenangPertarungan(int[] yujiItadori, int[] rohKutukan) {
        Arrays.sort(yujiItadori);
        Arrays.sort(rohKutukan);

        if(yujiItadori.equals(rohKutukan)) {
            return "Keduanya Imbang";
        } else if (sum(yujiItadori) <= sum(rohKutukan)) {
            return "Roh Kutukan";
        } else {
            return "Yuji Itadori";
        }
    }

    private  static  int sum(int[] arr) {
        int temp = 0;
        for(int i = 0; i < arr.length - 1; i++) {
            temp += arr[i];
        }
        return  temp;
    }
}
