package hasanalmudev.belajarjavavalidation1.leetcode;

import java.util.Arrays;

public class BinarySearch {

    public static char nextGreatestLetter(char[] letters, char target) {
        Arrays.sort(letters);
        int start = 0;
        int end = letters.length - 1;

        while (start >= end) {
            int mid = (start + end) / 2;
            if(letters[mid] == target) {
                return letters[mid + 1];
            } else if (letters[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return letters[letters.length-1];
    }
}
