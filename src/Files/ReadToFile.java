package Files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ReadToFile {
    public static void main(String[] args) {
        /**  3.	Прочитать данные из файла.Вывести их на консоль*/
        Path file7 = Paths.get("/home/user/my_file.txt");
        try {
            List<String> lines = Files.readAllLines(file7);
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
