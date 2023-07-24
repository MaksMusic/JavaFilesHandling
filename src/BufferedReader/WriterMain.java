package BufferedReader;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class WriterMain {
    public static void main(String[] args) {

        try (FileWriter fileWriter = new FileWriter("file.txt", true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            String content = "Это новое содержимое файла";

            bufferedWriter.write(content);
            bufferedWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

