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

        System.out.println("��� �����: " + filePath.getFileName());
        System.out.println("������: " + attr.size());
        System.out.println("����� ��������: " + attr.creationTime());
        System.out.println("����� ���������� �������: " + attr.lastAccessTime());
        System.out.println("����� ��������� �����������: " + attr.lastModifiedTime());
        System.out.println("��� ����������: " + attr.isDirectory());
        System.out.println("��� ������� ����: " + attr.isRegularFile());
        System.out.println("��� ������������� ������: " + attr.isSymbolicLink());
        System.out.println("���� �����: " + attr.fileKey());
    }
}
