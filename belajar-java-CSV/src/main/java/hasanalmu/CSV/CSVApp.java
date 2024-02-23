package hasanalmu.CSV;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CSVApp {

    public static void main(String[] args) {
        try {
            File file = new File("/home/hasan/hasan.csv");
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter(",");

            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }
}
