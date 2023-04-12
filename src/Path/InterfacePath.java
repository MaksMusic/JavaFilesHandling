package Path;

import java.nio.file.Path;
import java.nio.file.Paths;

public class InterfacePath {
    public static void main(String[] args) {
        // �������� ��� ���������� �� ����
        Path path = Paths.get("D:\\javaFile\\file.txt");
        Path directoryPath = Paths.get("D:\\javaFile");

        System.out.println(path.getFileName()); // ��� �����
        System.out.println(directoryPath.getFileName()); //��� ����������

        //�������� ���������� � ������� ��������� ���� �� ����������
        System.out.println(path.getParent()); // ���� �� �����
        System.out.println(directoryPath.getParent()); //���� �� ����������

        //�������� � ����� ���������� ���������� ���� ���� �� ����������
        System.out.println(path.getRoot());
        System.out.println(directoryPath.getRoot());

        //��������� ���� �� ����
        System.out.println(path.isAbsolute());
        System.out.println(directoryPath.isAbsolute());

        //������ ���� � ����� ��� ��������
        Path path2 = Paths.get("file.txt");
        System.out.println(path.toAbsolutePath());
        System.out.println(directoryPath.toAbsolutePath());

        //���� ���� �� ������ ������ ���������� � ������� ��������� � ��� ���� ��� ����� � ���
        System.out.println(path2.toAbsolutePath());


        // ����� �������� ��������� � ������� ��������� ���� �����
        //������� �������� ���������� ���� � ����� ������� getParent
        System.out.println(path.toAbsolutePath().getParent());

        // ����� �������� ��������� ��������� � ������� ��������� ���� �����
        //������� �������� ���������� ���� � ����� ������� getRoot
        System.out.println(directoryPath.toAbsolutePath().getRoot());


        //��������� ���� ���������� � ������ � ���� ������
        System.out.println(directoryPath.resolve("textJava.txt"));
        //��� ��������� ���� ���������� � ������ ����� ��� ������ Paths.get
        System.out.println(path.resolve(Paths.get("textJava.txt")));




    }
}
