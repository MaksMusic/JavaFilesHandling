package Files;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WritingToFile {

    public static void main(String[] args) {

    }

    /**
     * Files.write() - это стандартный метод Java для записи в файл, он записывает байты в файл через OutputStream.
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
     * FileWriter - класс из библиотеки java.io, который также используется для записи данных в файл.
     * Он более удобен для записи текстовых строк в файл,
     * так как он позволяет записывать строки без преобразования в байты,
     * а также добавлять символы к уже существующим строкам
     */
    public void write2(String text1) {
        try {
            // Устанавливается значение true, что означает, что новые данные будут дописываться в конец файла.
            // Если бы значение было false, то файл бы перезаписывался заново при выполнении записи
            FileWriter writer = new FileWriter("listUser.txt", false);    //создать новый файл
            writer.write(text1);    //добавить строку
            writer.flush();         // добавить все изменения в файл

            writer.append('=');     //добавить смивол на ту же строку
            writer.flush();         // добавить все изменения в файл
            writer.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
