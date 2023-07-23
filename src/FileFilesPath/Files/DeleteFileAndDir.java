package FileFilesPath.Files;

import java.io.IOException;
import java.nio.file.*;

public class DeleteFileAndDir {
    public static void main(String[] args) {
        /**
         * Если объект по указанному пути является папкой, то метод FileFilesPath.Files.delete(path)
         * выбросит исключение DirectoryNotEmptyException, если папка не пуста.
         * Поэтому в этом случае мы используем метод FileFilesPath.Files.delete(path), чтобы удалить папку и ее содержимое.
         *
         * Если объект по указанному пути является файлом, то мы используем метод FileFilesPath.Files.deleteIfExists(path),
         * чтобы удалить файл, если он существует. Если файла не существует, то метод не делает ничего.
         * Такой подход позволяет удалять файлы и папки безопасно и корректно, учитывая их тип и содержимое.
         */

        Path path = Paths.get("/home/user/my_file.txt");

        /** Удаление файла или каталога по FileFilesPath.Path:*/
        try {
            if (Files.isDirectory(path)) {
                Files.delete(path);
            } else {
                Files.deleteIfExists(path);
            }
        } catch (IOException e) {
            System.out.println("");
        }
    }
}
