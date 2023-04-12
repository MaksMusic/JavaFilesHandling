package File;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class ClassFile {
    public static void main(String[] args) {

        // ������� 1 �������� ������� File, ��������������� ������� D://javaFile
        File dir1 = new File("D:\\javaFile");

        // ������� 2 �������� ������� File, ��������������� ���� "test.txt" � �������� dir
        File file1 = new File(dir1, "text1.txt");

        // ������� 3 �������� ������� File, ��������������� ���� "test.txt" � �������� "D://javaFile"
        File file2 = new File("D:\\javaFile", "text1.txt");


        File fileDir = new File("D:\\javaFile\\packege1\\p1");
        System.out.println(fileDir.mkdir() + " mkdir");     //������ true ���� ����� ���������
        System.out.println(fileDir.mkdirs() + " mkdirs");     //������ true ���� ����� ����������


        /**
         * � ������ �������, ����� ��������� ����������, ����:

         ������������, �� ����� �������� �������� ����������, �� ����� ���� �� ������ � ���������� "D:\javaFile",
         ���� �������� ��������� ����.

         ���� � ����� �� ������ ("file.txt") ��� ���������� � �������� ����������.

         ���� ��������� ���� � ����� �������, �� ��� ����� ����� ������� ���������� ��� ������ createNewFile().
         � ����� ������ ���������� ��������� ������������ ���������� ���� � �����.
         */

        //������� ����� ����
        File fileNew = new File("D:\\javaFile\\", "file.txt");
        try {
            System.out.println(fileNew.createNewFile());
        } catch (Exception e) {
            System.out.println("false add file");
        }


        //������������� ���� ��� ��������
        File currentsDir = new File("D:\\javaFile\\packege1\\p1");
        File editDir = new File("D:\\javaFile\\packege1\\catregory1");
        System.out.println(currentsDir.renameTo(editDir) + " rename");


        /** ������ � ������������*/


        //������ �� ����������
        File category = new File("D:\\javaFile\\packege1");

        // ���������� ������ ���� String �� ������ � ���������, �� ������ �� ��� ���� � ��������� ����������
        //category.list() ������ ���� String
        //String [] arrayStr = category.list();
        System.out.println(Arrays.toString(category.list()));


        // ���������� ������ ������ � ������������, ���� File
        //File [] arrayFile = category.listFiles();
        System.out.println(Arrays.toString(category.listFiles()));


        //�������� ������ ��� ��������
        File fileDir2 = new File("D:\\javaFile");
        File file = new File("D:\\javaFile\\file.txt");

        System.out.println(fileDir2.exists() + " exist");               //��������� ���� �� ���� ��� �����
        System.out.println(file.isFile() + " isFile");                  //��������� �������� �� ������
        System.out.println(fileDir2.isDirectory() + " isDirectory");    //��������� �������� �� ������
        System.out.println(fileDir2.isHidden() + " isHidden");          //��������� �������� �� ���� �������

        // ������ � ��������� � ������
        System.out.println(file.getName() + " getName");     //�������� ����� � ��� ���
        System.out.println(file.getParent() + " getParent"); // ������ ���� ����� ��� ��������� �����  String
        System.out.println(file.getParentFile());          // ������� ����� ��� ����� ��� ��������� ������� ��� ���� File
        System.out.println(file.lastModified());         // ���������� ����� ���������� ��������� ����� ���
        System.out.println(new SimpleDateFormat().format(file.lastModified()));  //����� ��������� �����


        //���������� ������ ����� � ������
        System.out.println(file.length());

        //���������� ������ ����� � ������
        System.out.println(new File("D:\\javaFile\\picaso.bmp").length());

        // ���� � ����� ��� ���������� � ���� ������
        System.out.println(file.getAbsolutePath());

        // ���� � ����� ��� ���������� � ���� ������
        System.out.println(new File("D:\\javaFile").getAbsoluteFile());

        searchFileType(new File("D:\\javaFile"));

    }

    //����� ����� �� ����������
    public static void searchFileType(File category) {
        for (File fileStr : category.listFiles()) {
            if ((fileStr != null) && (fileStr.getName().endsWith(".txt"))) {
                System.out.println(fileStr.getName());
            }
        }

    }

}
