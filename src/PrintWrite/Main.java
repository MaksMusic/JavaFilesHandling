package PrintWrite;

import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        try (PrintWriter printWriter = new PrintWriter("text.txt")){
            printWriter.println("\njoni11");
        }catch (Exception e){

        }
    }

}
