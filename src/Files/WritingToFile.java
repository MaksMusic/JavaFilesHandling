package Files;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WritingToFile {

    public static void main(String[] args) {

    }

    /**
     * Files.write() - ��� ����������� ����� Java ��� ������ � ����, �� ���������� ����� � ���� ����� OutputStream.
     * �� ��������� ��������� ������ � ��� ������������ ����, ��������� ��������
     * java.nio.file.StandardOpenOption.APPEND.
     * ��� StandardOpenOption.WRITE ��� ��������������� ������ � ����
     * ����� �� ������������� ��������� ���������� � ������ ����� ������.
     */
    public void write(Path path, String text) {
        try {
            Files.write(path, text.getBytes(), Files.exists(path) ? java.nio.file.StandardOpenOption.APPEND :
                    java.nio.file.StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /** rec
     * FileWriter - ����� �� ���������� java.io, ������� ����� ������������ ��� ������ ������ � ����.
     * �� ����� ������ ��� ������ ��������� ����� � ����,
     * ��� ��� �� ��������� ���������� ������ ��� �������������� � �����,
     * � ����� ��������� ������� � ��� ������������ �������
     */
    public void write2(String text1) {
        try {
            // ��������������� �������� true, ��� ��������, ��� ����� ������ ����� ������������ � ����� �����.
            // ���� �� �������� ���� false, �� ���� �� ��������������� ������ ��� ���������� ������
            FileWriter writer = new FileWriter("listUser.txt", false);    //������� ����� ����
            writer.write(text1);    //�������� ������
            writer.flush();         // �������� ��� ��������� � ����

            writer.append('=');     //�������� ������ �� �� �� ������
            writer.flush();         // �������� ��� ��������� � ����
            writer.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
