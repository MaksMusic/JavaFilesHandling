package Path;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class BasicAttClass {
    public static void main(String[] args) {
        var filePath = Paths.get("/home/user/my_file.txt");
        BasicFileAttributes attr = null;
        try {
            attr = Files.readAttributes(filePath, BasicFileAttributes.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Имя файла: " + filePath.getFileName());
        System.out.println("Размер: " + attr.size());
        System.out.println("Время создания: " + attr.creationTime());
        System.out.println("Время последнего доступа: " + attr.lastAccessTime());
        System.out.println("Время последней модификации: " + attr.lastModifiedTime());
        System.out.println("Это директория: " + attr.isDirectory());
        System.out.println("Это обычный файл: " + attr.isRegularFile());
        System.out.println("Это символическая ссылка: " + attr.isSymbolicLink());
        System.out.println("Ключ файла: " + attr.fileKey());
    }
}
