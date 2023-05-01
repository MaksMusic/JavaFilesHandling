package Files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreateFileAndDir {
    public static void main(String[] args) {
        /**  5. Создать новую директорию по указанному пути..*/
        Path dirPath2 = Paths.get("/home/user/new_folder");
        try {
            Path newDir = Files.createDirectory(dirPath2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        /**  1	Создать новый файл по указанному пути.*/
        Path file5 = Paths.get("/home/user/new_file.txt");
        try {
            Path newFile = Files.createFile(file5);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
