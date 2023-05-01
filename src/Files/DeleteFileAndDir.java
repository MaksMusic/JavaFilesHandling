package Files;

import java.io.IOException;
import java.nio.file.*;

public class DeleteFileAndDir {
    public static void main(String[] args) {
        /**
         * ���� ������ �� ���������� ���� �������� ������, �� ����� Files.delete(path)
         * �������� ���������� DirectoryNotEmptyException, ���� ����� �� �����.
         * ������� � ���� ������ �� ���������� ����� Files.delete(path), ����� ������� ����� � �� ����������.
         *
         * ���� ������ �� ���������� ���� �������� ������, �� �� ���������� ����� Files.deleteIfExists(path),
         * ����� ������� ����, ���� �� ����������. ���� ����� �� ����������, �� ����� �� ������ ������.
         * ����� ������ ��������� ������� ����� � ����� ��������� � ���������, �������� �� ��� � ����������.
         */

        Path path = Paths.get("/home/user/my_file.txt");

        /** �������� ����� ��� �������� �� Path:*/
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
