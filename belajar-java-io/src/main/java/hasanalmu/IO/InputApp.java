package hasanalmu.IO;

import java.util.Scanner;

public class InputApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Input your name : ");
        String nextLine = scanner.nextLine();

        System.out.println("hello " + nextLine);
    }
}
