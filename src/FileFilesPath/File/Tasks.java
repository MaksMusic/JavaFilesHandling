package FileFilesPath.File;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Tasks {
    public static void main(String[] args) {

    }


    //Написать метод, который принимает путь к директории и выводит список всех файлов в ней и ее поддиректориях рекурсивно.
    public static void listFiles(String directoryPath) {
        File dir = new File(directoryPath);
        File[] files = dir.listFiles();

        for (File file : files) {
            if (file.isDirectory()) {
                listFiles(file.getAbsolutePath());
            } else {
                System.out.println(file.getAbsolutePath());
            }
        }
    }


    //Скопировать содержимое одного файла в другой. Оба файла заданы путями.
    public class FileUtils {
        public static void copyFile(String sourcePath, String destinationPath) {
            try {
                Path source = Paths.get(sourcePath);
                Path destination = Paths.get(destinationPath);
                Files.copy(source, destination);
                // если файл 2 существует FileFilesPath.Files.copy(source, destination,StandardCopyOption.REPLACE_EXISTING);
                System.out.println("FileFilesPath.File copied successfully.");
            } catch (IOException e) {
                System.out.println("Failed to copy file.");
            }
        }
    }

    //Получить размер файла в байтах и мегабайтах

    public static void getFileSize(String filePath) {
        File file = new File(filePath);
        long fileSizeBytes = file.length();
        double fileSizeMegabytes = (double) fileSizeBytes / (1024 * 1024);

        System.out.println("FileFilesPath.File size in bytes: " + fileSizeBytes);
        System.out.println("FileFilesPath.File size in megabytes: " + fileSizeMegabytes);


    }

    //Удалить директорию и все ее содержимое. Если директория не существует, метод должен вывести ошибку.
    public static boolean deleteDirectory(String directoryPath) {
        File dir = new File(directoryPath);

        if (dir.exists()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        deleteDirectory(file.getAbsolutePath());
                    } else {
                        file.delete();
                    }
                }
            }
            return dir.delete();
        } else {
            System.err.println("Directory does not exist!");
            return false;
        }
    }



    //Посчитать общий размер файлов в заданной директории и ее поддиректориях

    public static long getTotalSize(String directoryPath) {
        File dir = new File(directoryPath);
        long totalSize = 0;

        File[] files = dir.listFiles();

        for (File file : files) {
            if (file.isDirectory()) {
                totalSize += getTotalSize(file.getAbsolutePath());
            } else {
                totalSize += file.length();
            }
        }
        return totalSize;
    }


}
