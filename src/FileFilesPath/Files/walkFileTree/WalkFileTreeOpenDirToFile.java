package FileFilesPath.Files.walkFileTree;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/** ����� �� ������ ���� Path */
public class WalkFileTreeOpenDirToFile{
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C:\\Users\\Admin\\IdeaProjects\\JavaFilesHandling\\src\\h1");
        Files.walkFileTree(path,new MyFileVisitor());
    }
}

class MyFileVisitor implements FileVisitor<Path> {
    @Override//����������� ����� ���������� �� ���� ��������� �����
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        System.out.println("Enter to Directory -> " + dir);
        return FileVisitResult.CONTINUE; // �������� ���������� ������
    }

    @Override // ����������� ��� ��������� � �����
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println("file name -> " + file.getFileName());
        return FileVisitResult.CONTINUE; // �������� ���������� ������
    }

    @Override // ����������� ����� ���� �� ����� ���� �������� �� ��������
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.out.println("error while visiting file -> " + file.getFileName());
        return  FileVisitResult.TERMINATE; //������������
    }

    @Override //����������� ����� ��������� �� ���� ��������� �����
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        System.out.println("Exit from directory xxx-> "+ dir);
        return FileVisitResult.CONTINUE; // �������� ���������� ������
    }
}
