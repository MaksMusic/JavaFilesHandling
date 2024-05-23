package FileReaderFileWriter;

import java.io.FileReader;

public class JobFileReader {
    public static void main(String[] args) throws Exception {

        //прочитать файл
        //найти файл
        FileReader fileReader = new FileReader("C:\\Users\\maksm\\IdeaProjects\\JavaFiles\\src\\text.txt");

        // в с принимаем каждый символ из файла в формате числа из таблицы юникод
        //если нет символа вернет -1
        int c;

        while((c = fileReader.read()) != -1) {
            System.out.print((char)c);
        }
    }




}

