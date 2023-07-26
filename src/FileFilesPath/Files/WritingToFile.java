package FileFilesPath.Files;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class WritingToFile {

    public static void main(String[] args) {

    }

    /**
     * FileFilesPath.Files.write() - ��� ����������� ����� Java ��� ������ � ����, �� ���������� ����� � ���� ����� OutputStream.
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
     * ������ � ���� ��������
     */

    public class FileExample {
        public static void main(String[] args) {
            String filePath = "path/to/file.txt";
            String data = "Hello, World!";

            try {
                Path path = Path.of(filePath);

                // ���������� ������ ��������� � ����
                Files.writeString(path, data, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.WRITE);

                System.out.println("���� ������� �������.");
            } catch (Exception e) {
                System.out.println("������ ��� ������ �����: " + e.getMessage());
            }
        }
    }



}
