package Tasks.projectComments;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Comment {
    private String name;
    private String text;
    private Calendar date;

    public Comment(String name, String text, Calendar date) {
        this.name = name;
        this.text = text;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public Calendar getDate() {
        return date;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Comment> comments = new ArrayList<>();
        String input;
        System.out.println("������� ���:");
        String name = scanner.nextLine();
        System.out.println("������� �����������:");
        while (!(input = scanner.nextLine()).equals("����")) {
            Calendar date = Calendar.getInstance();
            comments.add(new Comment(name, input, date));
            Path file = Paths.get("comments.txt");
            String content = String.format("���: %s%n�����������: %s%n����: %s%n%n", name, input, date.getTime());
            try {
                Files.write(file, content.getBytes(), Files.exists(file) ? java.nio.file.StandardOpenOption.APPEND :
                        java.nio.file.StandardOpenOption.CREATE);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("������� ����������� ��� '����':");
        }
    }
}

/**
 * ������ ������ �������� �� ������ ����������� � ����.
 *   Files.write(file, content.getBytes(), Files.exists(file) ? java.nio.file.StandardOpenOption.APPEND :
 *                         java.nio.file.StandardOpenOption.CREATE);
 *
 - Files.write() - ����� ��� ������ ������ � ����
 - file - ������ ���� Path �������������� ���� �� �����, � ������� ����� ������������� ������
 - content.getBytes() - �������������� ������ content � ����� ��� ������
 - Files.exists(file) - �������� ������������� ����� �� ���������� ���� file
 - java.nio.file.StandardOpenOption.APPEND - ����� ����������� �� �������������� ���������� �����, � ��������� ����� ������ � ����� �����
 - java.nio.file.StandardOpenOption.CREATE - ����� �����������, ��� ���� ���� �� ����������, �� �� ����� ������.

 ����� �������, ���� ���� ��� ����������, �� ����� Files.write() ������� ����� ����������� � ����� �����. ���� ����� ��� ���, �� �� ����� ������, � � ���� ����� ������� ������ �����������.
 */