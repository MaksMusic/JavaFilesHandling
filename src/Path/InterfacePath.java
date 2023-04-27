package Path;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class InterfacePath {
    public static void main(String[] args) {
        // �������� ��� ���������� �� ����
        Path path = Paths.get("D:\\javaFile\\file.txt");
        Path directoryPath = Paths.get("D:\\javaFile");
        Path directoryPath2 = Paths.get("D:\\javaFile\\packege1\\catregory1\\categoryNext");

         File file =  path.toFile(); //������� ����� ��� ������ File
         File file2 =  new File(path.toUri());  //������� ���� ��� ������ Url

        //�������� ������������� ����� ��� �������� �� Path
        boolean exists = Files.exists(path);

        //��������� �������������� ���� �� ������ ���� �� �������
        Path relative = directoryPath.relativize(directoryPath2);
        System.out.println(relative +" relative");


        System.out.println(path.getFileName()); // ��� �����
        System.out.println(directoryPath.getFileName()); //��� ����������
        //���
        Path pathFileName = path.getFileName();
        Path pathDirName = directoryPath.getFileName();


        //�������� ���������� � ������� ��������� ���� ��� ����������
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
        System.out.println(path2.toAbsolutePath());
        System.out.println(directoryPath.toAbsolutePath());



        //��������� ���������� ��������� � ����
        int count = path.getNameCount();
        System.out.println(count +" count");

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
