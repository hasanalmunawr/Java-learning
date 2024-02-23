package hasan.almunawar.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class cpp {

    public static void main(String[] args) {

        String worl = "helloworld";
        int a = 3;
        int b = 7;

        StringBuilder buffer = new StringBuilder();
        for(int i = a; i < b; i++) {
            buffer.append(worl.charAt(i));
        }
        System.out.println(buffer.toString());



    }


    private static  String isAnagram(String a, String b) {
        a = a.toLowerCase();
        b = b.toLowerCase();

        if(a.length() != b.length()) {
            return "Not Anagrams";
        }

        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();

        if(Arrays.equals(charsA, charsB)) {
            return "Anagrams";
        } else {
            return "Not Anagrams";
        }
    }




}
