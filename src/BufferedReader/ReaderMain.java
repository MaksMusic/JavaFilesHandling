package BufferedReader;

import java.io.*;
import java.nio.charset.StandardCharsets;


/** чтение   */
public class ReaderMain {
    public static void main(String[] args) {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("file.txt"));){
           String s;
           while ( (s = bufferedReader.readLine()) != null){
               System.out.println(s);
           }
        }catch (IOException e){
           e.printStackTrace();
       }
    }
}
