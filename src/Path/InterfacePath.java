package Path;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class InterfacePath {
    public static void main(String[] args) {
        // получить им€ директории по пути
        Path path = Paths.get("D:\\javaFile\\file.txt");
        Path directoryPath = Paths.get("D:\\javaFile");
        Path directoryPath2 = Paths.get("D:\\javaFile\\packege1\\catregory1\\categoryNext");

         File file =  path.toFile(); //вернуть пусть как объект File
         File file2 =  new File(path.toUri());  //вернуть путь как объект Url

        //ѕроверка существовани€ файла или каталога по Path
        boolean exists = Files.exists(path);

        //ѕолучение относительного пути от одного пути до другого
        Path relative = directoryPath.relativize(directoryPath2);
        System.out.println(relative +" relative");


        System.out.println(path.getFileName()); // им€ файла
        System.out.println(directoryPath.getFileName()); //им€ директории
        //или
        Path pathFileName = path.getFileName();
        Path pathDirName = directoryPath.getFileName();


        //получить директорию в которой находитс€ файл или директори€
        System.out.println(path.getParent()); // путь до файла
        System.out.println(directoryPath.getParent()); //путь до директории

        //получить с какой директории начинаетс€ путь файл ли директори€
        System.out.println(path.getRoot());
        System.out.println(directoryPath.getRoot());

        //проверить есть ли путь
        System.out.println(path.isAbsolute());
        System.out.println(directoryPath.isAbsolute());

        //полный путь к файлу или каталогу
        Path path2 = Paths.get("file.txt");
        System.out.println(path2.toAbsolutePath());
        System.out.println(directoryPath.toAbsolutePath());



        //ѕолучение количества элементов в пути
        int count = path.getNameCount();
        System.out.println(count +" count");

        //если путь не указан вернет директорию в которой находитс€ и сам файл как будто в ней
        System.out.println(path2.toAbsolutePath());

        // чтобы получить категорию в которой находитс€ файл нужно
        //сначала получить абсолютный путь и после вызвать getParent
        System.out.println(path.toAbsolutePath().getParent());

        // чтобы получить начальную категорию в которой находитс€ файл нужно
        //сначала получить абсолютный путь и после вызвать getRoot
        System.out.println(directoryPath.toAbsolutePath().getRoot());


        //соединить путь директории с файлом в виде строки
        System.out.println(directoryPath.resolve("textJava.txt"));
        //или соединить путь директории с другим путем или файлом Paths.get
        System.out.println(path.resolve(Paths.get("textJava.txt")));





    }
}
