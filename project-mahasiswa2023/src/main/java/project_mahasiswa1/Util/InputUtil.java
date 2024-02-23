package project_mahasiswa1.Util;

import java.util.Scanner;

public class InputUtil {

    private  static Scanner input = new Scanner(System.in);

    public static int inputInt(String masage) {
        System.out.print(masage);
        int inputan = input.nextInt();
        return  inputan;
    }

    public  static  String inputStr(String masage) {
        System.out.print(masage);
        String inputan = input.nextLine();
        return  inputan;
    }
}
