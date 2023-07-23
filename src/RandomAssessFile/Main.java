package RandomAssessFile;

import java.io.RandomAccessFile;

/**
 * RandomAccessFile ��� ������ � ������ � ���� �������� ���� ������ ��������
 */

public class Main {
    public static void main(String[] args) {
        String file = "C:\\Users\\Admin\\IdeaProjects\\JavaFilesHandling\\src\\RandomAssessFile\\text.txt";

        // rw �������� ������ � ������
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw")) {
            //��������� ���� ������
            char ch = (char) randomAccessFile.read();
            //��������� ������
            String line = randomAccessFile.readLine();

            //����������� ������� �� ������� 20
            randomAccessFile.seek(20);
            //������� ������ � 20 �������
            System.out.println(randomAccessFile.readLine());

            //�������� ����� �������� ��������
            Long point = randomAccessFile.getFilePointer();

            // �������� �� ���� ������ ������ ������ ���� ��� ������ �������
            randomAccessFile.writeBytes("Hello");
            randomAccessFile.seek(randomAccessFile.length()-1);

            //�������� ������ � ����� ������
            randomAccessFile.writeBytes("\n���������� �������");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
