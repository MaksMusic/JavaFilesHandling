package Scanner;

import java.io.File;
import java.security.spec.ECField;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("text2.txt"))){
            while (scanner.hasNextLine()){
                System.out.println(scanner.nextLine());
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
