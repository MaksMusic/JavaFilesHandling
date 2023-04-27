package Files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * ������ � ������� Files
 */
public class ClassFiles {
    public static void main(String[] args) {


        // �������� ��� ���������� �� ����
        Path path = Paths.get("D:\\javaFile\\file.txt");
        Path directoryPath = Paths.get("D:\\javaFile");
        Path directoryPath2 = Paths.get("D:\\javaFile\\packege1\\catregory1\\categoryNext");


        //C������� ����� �� ���������� ���� ���� ���� �� ������� ���� ���� � ����
        Path pathNew = Paths.get("D:\\JavaTest\\java2\\text.tet");
        try {
            if (Files.notExists(path)) {
                Files.createDirectories(path.toAbsolutePath().getParent());
                Files.createFile(path);
                System.out.println("File created at path: " + pathNew);
            } else {
                System.out.println("File already exists at path: " + pathNew);
            }
        } catch (IOException e) {
            System.out.println("Unable to create file at path: " + pathNew);
            e.printStackTrace();
        }


        //�������� ����� ��� �������� �� Path:
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
