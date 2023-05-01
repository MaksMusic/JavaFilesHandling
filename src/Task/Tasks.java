package Task;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.stream.Stream;

public class Tasks {
    public static void main(String[] args) {
        /** 1.	������� ��������� ������ Path, ������ ���� � ����� ��� ����������.*/
        Path path = Paths.get("C:/Users/user/Documents/my_file.txt");


        /** 2 . ���������, ���������� �� ���� ��� ���������� �� ���������� ����.*/
        Path file = Paths.get("/home/user/my_file.txt");
        if (Files.exists(file)) {
            System.out.println("���� ����������");
        } else {
            System.out.println("���� �� ����������");
        }

      /** �������� ������ ���� ������ � ���������� �� ���������� ����.*/
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

        /**  1	������� ����� ���� �� ���������� ����.*/
        Path file5 = Paths.get("/home/user/new_file.txt");
        try {
            Path newFile = Files.createFile(file5);
        } catch (IOException e) {
            e.printStackTrace();
        }


        /**  3.	��������� ������ �� �����.������� �� �� �������*/
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
