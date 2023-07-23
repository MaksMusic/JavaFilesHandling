package FileFilesPath.Files;

import java.io.IOException;
import java.nio.file.*;


public class CopyFileToDir {
    /**
     StandardCopyOption.REPLACE_EXISTING - ��� �����, ������� ��������� ������ ����������� ������,
     ��� ����� �������� ��� ������������ ����, ���� �� ����.

     ��������, ���� �� ������ ����������� ���� �� ����� ���������� � ������,
     � ������ ���������� ��� �������� ���� � ����� �� ������,
     �� ��� ������������� ����� REPLACE_EXISTING ����� ����������� �������� ���������� FileAlreadyExistsException.
     ������, ���� �� �������� ��� �����, �� ��� ������������ ���� ����� ������� ����� ������.

     */

    public static void main(String[] args) {
        /**  4.	���������� ���� � ������ ����������.*/

        Path sourceFile = Paths.get("/home/user/my_file.txt");
        Path destinationFile = Paths.get("/home/user/my_folder/my_file_copy.txt");
        try {
            Files.copy(sourceFile, destinationFile, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
