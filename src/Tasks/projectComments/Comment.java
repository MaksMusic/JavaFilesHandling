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
        System.out.println("Введите имя:");
        String name = scanner.nextLine();
        System.out.println("Введите комментарий:");
        while (!(input = scanner.nextLine()).equals("стоп")) {
            Calendar date = Calendar.getInstance();
            comments.add(new Comment(name, input, date));
            Path file = Paths.get("comments.txt");
            String content = String.format("Имя: %s%nКомментарий: %s%nДата: %s%n%n", name, input, date.getTime());
            try {
                Files.write(file, content.getBytes(), Files.exists(file) ? java.nio.file.StandardOpenOption.APPEND :
                        java.nio.file.StandardOpenOption.CREATE);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Введите комментарий или 'стоп':");
        }
    }
}

/**
 * Данная строка отвечает за запись комментария в файл.
 *   Files.write(file, content.getBytes(), Files.exists(file) ? java.nio.file.StandardOpenOption.APPEND :
 *                         java.nio.file.StandardOpenOption.CREATE);
 *
 - Files.write() - метод для записи байтов в файл
 - file - объект типа Path представляющий путь до файла, в который будет производиться запись
 - content.getBytes() - преобразование строки content в байты для записи
 - Files.exists(file) - проверка существования файла по указанному пути file
 - java.nio.file.StandardOpenOption.APPEND - опция указывающая не перезаписывать содержимое файла, а добавлять новые данные в конец файла
 - java.nio.file.StandardOpenOption.CREATE - опция указывающая, что если файл не существует, то он будет создан.

 Таким образом, если файл уже существует, то метод Files.write() добавит новый комментарий в конец файла. Если файла еще нет, то он будет создан, и в него будет записан первый комментарий.
 */