package Path;

import java.nio.file.Path;
import java.nio.file.Paths;

public class InterfacePath {
    public static void main(String[] args) {
        // получить имя директории по пути
        Path path = Paths.get("D:\\javaFile\\file.txt");
        Path directoryPath = Paths.get("D:\\javaFile");

        System.out.println(path.getFileName()); // имя файла
        System.out.println(directoryPath.getFileName()); //имя директории

        //получить директорию в которой находится файл ли директория
        System.out.println(path.getParent()); // путь до файла
        System.out.println(directoryPath.getParent()); //путь до директории

        //получить с какой директории начинается путь файл ли директория
        System.out.println(path.getRoot());
        System.out.println(directoryPath.getRoot());

        //проверить есть ли путь
        System.out.println(path.isAbsolute());
        System.out.println(directoryPath.isAbsolute());

        //полный путь к файлу или каталогу
        Path path2 = Paths.get("file.txt");
        System.out.println(path.toAbsolutePath());
        System.out.println(directoryPath.toAbsolutePath());

        //если путь не указан вернет директорию в которой находится и сам файл как будто в ней
        System.out.println(path2.toAbsolutePath());


        // чтобы получить категорию в которой находится файл нужно
        //сначала получить абсолютный путь и после вызвать getParent
        System.out.println(path.toAbsolutePath().getParent());

        // чтобы получить начальную категорию в которой находится файл нужно
        //сначала получить абсолютный путь и после вызвать getRoot
        System.out.println(directoryPath.toAbsolutePath().getRoot());


        //соединить путь директории с файлом в виде строки
        System.out.println(directoryPath.resolve("textJava.txt"));
        //или соединить путь директории с другим путем или файлом Paths.get
        System.out.println(path.resolve(Paths.get("textJava.txt")));




    }
}
