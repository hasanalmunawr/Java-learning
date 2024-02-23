package hasanalmuDev.Belajarjavareflection;

import javax.print.DocFlavor;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AppCD {

    public static void main(String[] args) {

        int[][] matrix = {{1,4,7,11,15}
                ,{2,5,8,12,19}
                ,{3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}};

        System.out.println(fibonaci(5));


    }


    public static int search(int[] nums, int target) {
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if(nums[mid] == target) {
                return  mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    private static int fibonaci(int nums) {
        int result = 0;
        if(nums == 1 || nums == 2) {
            return 1;
        } else {
            result = fibonaci(nums) + fibonaci(nums + 1);
        }
        return result;
    }


    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> dictionary = new HashMap<>();

        for(int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            if (!dictionary.containsKey(c)) { // mengecek apakah sudah ada key nya atau belu,
                dictionary.put(c, 1);
            } else {
                dictionary.put(c, dictionary.get(c) + 1);
            }
        }

        for(int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            if  (!dictionary.containsKey(c) && dictionary.get(c) > 0) {
                dictionary.put(c, dictionary.get(c) - 1);
            } else {
                return  false;
            }
        }
        return true;
    }

    public boolean isIsomorphic(String s, String t) {
        if(t.length() != s.length()) {
            return false;
        }
        Map<Character, Character> dictionary = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            char es = s.charAt(i);
            char te = t.charAt(i);

            if(!dictionary.containsKey(es)) {
                dictionary.put(es, te);
            } else {
                if(!dictionary.get(es).equals(te)) {
                    return false;
                }
            }
        }
return true;
    }
    public boolean isIsomorp2hic(String s, String t) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            if(map1.put(s.charAt(i), i) != map2.put(t.charAt(i), i)) {
                return false;
            }
        }
        return true;
    }

    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> dictionery = new HashMap<>();
        String[] worlds = s.split(" ");

        if(pattern.length() != s.length()) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            char key = pattern.charAt(i);
            String world = worlds[i];
            if (!dictionery.containsKey(key)) { // belum ada
                dictionery.put(key, world);
            } else { // sudah ada
                if(!dictionery.get(key).equals(world)) {
                    return false;
                }
            }
        }
        return false;
    }
    public boolean wordPatter1n(String pattern, String s) {
        Map<Character, String> dictionary = new HashMap<>();
        String[] worlds = s.split(" ");

        if (pattern.length() != worlds.length) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {
            char key = pattern.charAt(i);
            String world = worlds[i];

            if (!dictionary.containsKey(key)) { // belum ada
                dictionary.put(key, world);
            } else { // sudah ada
                if (!dictionary.get(key).equals(world)) {
                    return false;
                }
            }
        }

        return true;
    }
}

class Solution {
    public boolean isHappy(int n) {

        int slow = n;
        int fast = n;
//while loop is not used here because initially slow and
//fast pointer will be equal only, so the loop won't run.
        do {
//slow moving one step ahead and fast moving two steps ahead

            slow = square(slow);
            fast = square(square(fast));
        } while (slow != fast);

//if a cycle exists, then the number is not a happy number
//and slow will have a value other than 1

        return slow == 1;
    }

//Finding the square of the digits of a number

    public int square(int num) {

        int ans = 0;

        while(num > 0) {
            int remainder = num % 10;
            ans += remainder * remainder;
            num /= 10;
        }

        return ans;
    }
}
