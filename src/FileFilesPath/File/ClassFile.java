package FileFilesPath.File;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class ClassFile {
    public static void main(String[] args) {

        // вариант 1 Создание объекта FileFilesPath.File, представляющего каталог D://javaFile
        File dir1 = new File("D:\\javaFile");

        // вариант 2 Создание объекта FileFilesPath.File, представляющего файл "test.txt" в каталоге dir
        File file1 = new File(dir1, "text1.txt");

        // вариант 3 Создание объекта FileFilesPath.File, представляющего файл "test.txt" в каталоге "D://javaFile"
        File file2 = new File("D:\\javaFile", "text1.txt");


        File fileDir = new File("D:\\javaFile\\packege1\\p1");
        System.out.println(fileDir.mkdir() + " mkdir");     //вернут true если папка создастся
        System.out.println(fileDir.mkdirs() + " mkdirs");     //вернут true если папки создадутся


        /**
         * В данном примере, может произойти исключение, если:

         Пользователь, от имени которого запущено приложение, не имеет прав на запись в директорию "D:\javaFile",
         куда пытается создаться файл.

         Файл с таким же именем ("file.txt") уже существует в заданной директории.

         Если указанный путь к файлу неверен, то это также может вызвать исключение при вызове createNewFile().
         В таком случае необходимо проверить правильность указанного пути к файлу.
         */

        //создать новый файл
        File fileNew = new File("D:\\javaFile\\", "file.txt");
        try {
            System.out.println(fileNew.createNewFile());
        } catch (Exception e) {
            System.out.println("false add file");
        }


        //переименовать файл или категоию
        File currentsDir = new File("D:\\javaFile\\packege1\\p1");
        File editDir = new File("D:\\javaFile\\packege1\\catregory1");
        System.out.println(currentsDir.renameTo(editDir) + " rename");


        /** Работа с директориями*/


        //ссылка на директорию
        File category = new File("D:\\javaFile\\packege1");

        // возвращает массив типа String из файлов и категорий, но только те что есть в указанной директории
        //category.list() Массив типа String
        //String [] arrayStr = category.list();
        System.out.println(Arrays.toString(category.list()));


        // возвращает массив файлов и подкаталогов, типа FileFilesPath.File
        //FileFilesPath.File [] arrayFile = category.listFiles();
        System.out.println(Arrays.toString(category.listFiles()));


        //проверки файлов или катлогов
        File fileDir2 = new File("D:\\javaFile");
        File file = new File("D:\\javaFile\\file.txt");

        System.out.println(fileDir2.exists() + " exist");               //проверить есть ли файл или папка
        System.out.println(file.isFile() + " isFile");                  //проверить является ли файлом
        System.out.println(fileDir2.isDirectory() + " isDirectory");    //проверить является ли папкой
        System.out.println(fileDir2.isHidden() + " isHidden");          //проверить является ли файл скрытым

        // данные о каталогах и файлах
        System.out.println(file.getName() + " getName");     //название файла и его тип
        System.out.println(file.getParent() + " getParent"); // полный путь папки где находится папка  String
        System.out.println(file.getParentFile());          // каталог папки или файла где находится каталог или файл FileFilesPath.File
        System.out.println(file.lastModified());         // возвращает время последнего изменения файла или
        System.out.println(new SimpleDateFormat().format(file.lastModified()));  //время изменения файла


        //возвращает размер файла в байтах
        System.out.println(file.length());

        //возвращает размер файла в байтах
        System.out.println(new File("D:\\javaFile\\picaso.bmp").length());

        // путь к файлу или директории в виде строки
        System.out.println(file.getAbsolutePath());

        // путь к файлу или директории в виде строки
        System.out.println(new File("D:\\javaFile").getAbsoluteFile());

        searchFileType(new File("D:\\javaFile"));

    }

    //поиск файла по расширению
    public static void searchFileType(File category) {
        for (File fileStr : category.listFiles()) {
            if ((fileStr != null) && (fileStr.getName().endsWith(".txt"))) {
                System.out.println(fileStr.getName());
            }
        }

    }

}
