package FileFilesPath.Files;

import java.io.IOException;
import java.nio.file.*;

public class DeleteFileAndDir {
    public static void main(String[] args) {
        /**
         * ���� ������ �� ���������� ���� �������� ������, �� ����� FileFilesPath.Files.delete(path)
         * �������� ���������� DirectoryNotEmptyException, ���� ����� �� �����.
         * ������� � ���� ������ �� ���������� ����� FileFilesPath.Files.delete(path), ����� ������� ����� � �� ����������.
         *
         * ���� ������ �� ���������� ���� �������� ������, �� �� ���������� ����� FileFilesPath.Files.deleteIfExists(path),
         * ����� ������� ����, ���� �� ����������. ���� ����� �� ����������, �� ����� �� ������ ������.
         * ����� ������ ��������� ������� ����� � ����� ��������� � ���������, �������� �� ��� � ����������.
         */

        Path path = Paths.get("/home/user/my_file.txt");

        /** �������� ����� ��� �������� �� FileFilesPath.Path:*/
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
