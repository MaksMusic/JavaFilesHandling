package FileFilesPath.Files;

import java.io.IOException;
import java.nio.file.*;


public class CopyFileToDir {
    /**
     StandardCopyOption.REPLACE_EXISTING - это опция, которая указывает методу копирования файлов,
     что нужно заменить уже существующий файл, если он есть.

     Например, если вы хотите скопировать файл из одной директории в другую,
     и вторая директория уже содержит файл с таким же именем,
     то без использования опции REPLACE_EXISTING метод копирования выбросит исключение FileAlreadyExistsException.
     Однако, если вы добавите эту опцию, то уже существующий файл будет заменен новым файлом.

     */

    public static void main(String[] args) {
        /**  4.	Копировать файл в другую директорию.*/

        Path sourceFile = Paths.get("/home/user/my_file.txt");
        Path destinationFile = Paths.get("/home/user/my_folder/my_file_copy.txt");
        try {
            Files.copy(sourceFile, destinationFile, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
