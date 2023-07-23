package RandomAssessFile;

import java.io.RandomAccessFile;

/**
 * RandomAccessFile для чтения и записи в файл указывая куда именно записать
 */

public class Main {
    public static void main(String[] args) {
        String file = "C:\\Users\\Admin\\IdeaProjects\\JavaFilesHandling\\src\\RandomAssessFile\\text.txt";

        // rw означает запись и чтение
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw")) {
            //прочитать один символ
            char ch = (char) randomAccessFile.read();
            //прочитать строку
            String line = randomAccessFile.readLine();

            //переместить поинтер на позицию 20
            randomAccessFile.seek(20);
            //вывести строку с 20 символа
            System.out.println(randomAccessFile.readLine());

            //получить число текущего поинтера
            Long point = randomAccessFile.getFilePointer();

            // записать по верх старых байтов строку туда где сейчас поинтер
            randomAccessFile.writeBytes("Hello");
            randomAccessFile.seek(randomAccessFile.length()-1);

            //дописать строку в конец текста
            randomAccessFile.writeBytes("\nЗавершение диалога");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
