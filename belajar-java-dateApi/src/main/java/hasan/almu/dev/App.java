package hasan.almu.dev;



import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



/**
 * Hello world!
 *
 */
public class App 
{

    static String absen(String[] name) {
        StringBuffer buffer = new StringBuffer("Absen : ");
        for(int i = 0; i < name.length ; i++) {
            buffer.append(name[i]);
            if(i < name.length - 1 ) {
                buffer.append(", ");
                if(i == name.length - 2) {
                    buffer.append("dan ");
                }
            }
        }
        return  buffer.toString();
    }

    public static int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        int[] result = new int[2];

        while (left < right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) {
                if(nums[mid] == nums[mid + 1]) {
                    return new int[] {mid, mid+1};
                } else{
                    return  new int[] {mid - 1, mid};
                }
            } else if (nums[mid] < target) {
                mid = right - 1;
            } else {
                mid = left + 1;
            }
        }
        return new int[] {-1, -1};
    }


    public static void main(String[] args) {

        int[] nums = {5,7,7,8,8,10};
            int target = 8;

        int [] result = searchRange(nums, target);

        for(var i : result) {
            System.out.println(i);
        }
    }

}
