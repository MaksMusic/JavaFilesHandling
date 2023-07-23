package Tasks;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.stream.Stream;

public class Tasks {
    public static void main(String[] args) {
        /** 1.	Создать экземпляр класса FileFilesPath.Path, указав путь к файлу или директории.*/
        Path path = Paths.get("C:/Users/user/Documents/my_file.txt");


        /** 2 . Проверить, существует ли файл или директория по указанному пути.*/
        Path file = Paths.get("/home/user/my_file.txt");
        if (Files.exists(file)) {
            System.out.println("Файл существует");
        } else {
            System.out.println("Файл не существует");
        }

        /** 3 Получить список всех файлов в директории по указанному пути.*/
        //no Stream
        File dir = new File("/home/user/my_folder");
        File[] files = dir.listFiles();
        for (File file1 : files) {
            if (file1.isFile()) {
                System.out.println(file1.getName());
            }
        }

        //Stream
        Path dirPath = Paths.get("/home/user/my_folder");
        try (Stream<Path> paths = Files.list(dirPath)) {
            paths.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }


        /** 4. Получить информацию о файле или директории (размер, дата создания/изменения и т.д.).*/
        Path file2 = Paths.get("/home/user/my_file.txt");
        try {
            BasicFileAttributes attr = Files.readAttributes(file2, BasicFileAttributes.class);
            System.out.println("Длина файла: " + attr.size());
            System.out.println("Дата создания: " + attr.creationTime());
            System.out.println("Дата последней модификации: " + attr.lastModifiedTime());
        } catch (IOException e) {
            e.printStackTrace();
        }

        /**  5. Создать новую директорию по указанному пути..*/
        Path dirPath2 = Paths.get("/home/user/new_folder");
        try {
            Path newDir = Files.createDirectory(dirPath2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        /**  6	Создать новый файл по указанному пути.*/
        Path file5 = Paths.get("/home/user/new_file.txt");
        try {
            Path newFile = Files.createFile(file5);
        } catch (IOException e) {
            e.printStackTrace();
        }


        /**  7.	Прочитать данные из файла.Вывести их на консоль*/
        Path file7 = Paths.get("/home/user/my_file.txt");
        try {
            List<String> lines = Files.readAllLines(file7);
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        /** 8 Записать данные в файл..*/
        String text =  "text";
        try {
            Files.write(path, text.getBytes(), Files.exists(path) ? java.nio.file.StandardOpenOption.APPEND :
                    java.nio.file.StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }



        /** 9	Копировать файл в другую директорию.*/
        Path sourceFile = Paths.get("/home/user/my_file.txt");
        Path destinationFile = Paths.get("/home/user/my_folder/my_file_copy.txt");
        try {
            Files.copy(sourceFile, destinationFile, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }



        /** 10 Удаление файла или каталога по FileFilesPath.Path:*/
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
