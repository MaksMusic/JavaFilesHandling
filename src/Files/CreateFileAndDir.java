package Files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreateFileAndDir {
    public static void main(String[] args) {
        // �������� ��� ���������� �� ����
        Path path = Paths.get("D:\\javaFile\\file.txt");
        Path directoryPath = Paths.get("D:\\javaFile");
        Path directoryPath2 = Paths.get("D:\\javaFile\\packege1\\catregory1\\categoryNext");




        /**  5. ������� ����� ���������� ��� ���������� �� ���������� ����..*/
        Path dirPath2 = Paths.get("D:\\JavaTest\\java2\\text.tet");
        try {
            Path newDir = Files.createDirectory(dirPath2);
            System.out.println("���� ������: " + dirPath2);
        } catch (IOException e) {
            e.printStackTrace();
        }



        /**  1	������� ����� ���� �� ���������� ����.*/
        Path file5 = Paths.get("D:\\JavaTest\\java2\\text2.tet");
        try {
            Path newFile = Files.createFile(file5);
        } catch (IOException e) {
            e.printStackTrace();
        }


        /** C������� ����� �� ���������� ���� ���� ���� �� ��������� ��������� � ��� ����*/
        Path pathNew = Paths.get("d:\\Users\\Admin\\Desktop\\2\\e\\text.txt");//����
        try {
            if (Files.notExists(pathNew)) {
                Files.createDirectories(path.toAbsolutePath().getParent());
                Files.createFile(pathNew);
                System.out.println("File created at path: " + pathNew);
            } else {
                System.out.println("File already exists at path: " + pathNew);
            }
        } catch (IOException e) {
            System.out.println("Unable to create file at path: " + pathNew);
            e.printStackTrace();
        }





    }
}
