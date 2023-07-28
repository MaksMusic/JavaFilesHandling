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
     * FileFilesPath.Files.write() - это стандартный метод Java для записи в файл, он записывает байты в файл через OutputStream.
     * Он позволяет добавлять данные в уже существующий файл, используя параметр
     * java.nio.file.StandardOpenOption.APPEND.
     * или StandardOpenOption.WRITE для перезаписывания данных в файл
     * Также он автоматически закрывает соединение с файлом после записи.
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
     * запись в файл символов
     */

    public class FileExample {
        public static void main(String[] args) {
            String filePath = "path/to/file.txt";
            String data = "Hello, World!";

            try {
                Path path = Path.of(filePath);

                // Записываем данные символами в файл
                Files.writeString(path, data, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.WRITE);

                System.out.println("Файл успешно записан.");
            } catch (Exception e) {
                System.out.println("Ошибка при записи файла: " + e.getMessage());
            }
        }
    }



}
