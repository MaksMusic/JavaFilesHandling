package FileOutputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

public class FileOutputStreamMain {
    public static void main(String[] args) {
        String text = "Hello tomas как твои дела";
        File file = new File("text2.txt");
        try (FileOutputStream fileOutputStream = new FileOutputStream(file,true) ){
            fileOutputStream.write(text.getBytes("UTF-8"));
        }catch (Exception e) {

        }
    }
}
