package Tasks;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.stream.Stream;

public class Tasks {
    public static void main(String[] args) {
        /** 1.	������� ��������� ������ FileFilesPath.Path, ������ ���� � ����� ��� ����������.*/
        Path path = Paths.get("C:/Users/user/Documents/my_file.txt");


        /** 2 . ���������, ���������� �� ���� ��� ���������� �� ���������� ����.*/
        Path file = Paths.get("/home/user/my_file.txt");
        if (Files.exists(file)) {
            System.out.println("���� ����������");
        } else {
            System.out.println("���� �� ����������");
        }

        /** 3 �������� ������ ���� ������ � ���������� �� ���������� ����.*/
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


        /** 4. �������� ���������� � ����� ��� ���������� (������, ���� ��������/��������� � �.�.).*/
        Path file2 = Paths.get("/home/user/my_file.txt");
        try {
            BasicFileAttributes attr = Files.readAttributes(file2, BasicFileAttributes.class);
            System.out.println("����� �����: " + attr.size());
            System.out.println("���� ��������: " + attr.creationTime());
            System.out.println("���� ��������� �����������: " + attr.lastModifiedTime());
        } catch (IOException e) {
            e.printStackTrace();
        }

        /**  5. ������� ����� ���������� �� ���������� ����..*/
        Path dirPath2 = Paths.get("/home/user/new_folder");
        try {
            Path newDir = Files.createDirectory(dirPath2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        /**  6	������� ����� ���� �� ���������� ����.*/
        Path file5 = Paths.get("/home/user/new_file.txt");
        try {
            Path newFile = Files.createFile(file5);
        } catch (IOException e) {
            e.printStackTrace();
        }


        /**  7.	��������� ������ �� �����.������� �� �� �������*/
        Path file7 = Paths.get("/home/user/my_file.txt");
        try {
            List<String> lines = Files.readAllLines(file7);
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        /** 8 �������� ������ � ����..*/
        String text =  "text";
        try {
            Files.write(path, text.getBytes(), Files.exists(path) ? java.nio.file.StandardOpenOption.APPEND :
                    java.nio.file.StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }



        /** 9	���������� ���� � ������ ����������.*/
        Path sourceFile = Paths.get("/home/user/my_file.txt");
        Path destinationFile = Paths.get("/home/user/my_folder/my_file_copy.txt");
        try {
            Files.copy(sourceFile, destinationFile, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }



        /** 10 �������� ����� ��� �������� �� FileFilesPath.Path:*/
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
