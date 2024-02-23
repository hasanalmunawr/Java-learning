package hasan.almu.testing;

import java.util.*;

public class cpp {
    public static void main(String[] args) {
       String a = "hasan";
        String b = "nasah";

        System.out.println(iscak(a,b));

        StringBuilder bul = new StringBuilder(a).reverse();
        System.out.println(bul);




    }

    public  static boolean iscak(String a, String b) {
        String newA = a.toLowerCase();
        String newB = b.toLowerCase();

        // 1
        StringBuilder builder = new StringBuilder(newA).reverse();
        if(builder.toString() .equals(newB)) {
            return  true;
        } else if (newA.equals(newB)) {
            return  true;
        } else {

        }

        return  false;
    }

    public  static  void as(String a) {
        String newA = a.toLowerCase();

        StringBuilder builder = new StringBuilder(newA).reverse();


    }

    public static String findDay(int month, int day, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);

        int dayOfWeek = calendar.get(calendar.DAY_OF_WEEK);

        String[] daysOfWeek = {"", "SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY"};
        return daysOfWeek[dayOfWeek];
    }



}
