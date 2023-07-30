package FileFilesPath.Files.walkFileTree;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/** обход по дереву пути Path */
public class WalkFileTreeOpenDirToFile{
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C:\\Users\\Admin\\IdeaProjects\\JavaFilesHandling\\src\\h1");
        Files.walkFileTree(path,new MyFileVisitorOpen());
    }
}

class MyFileVisitorOpen implements FileVisitor<Path> {
    @Override//срабатывает перед обращением ко всем элементам папки
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        System.out.println("Enter to Directory -> " + dir);
        return FileVisitResult.CONTINUE; // означает продолжать работу
    }

    @Override // срабатывает при обращении к файлу
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println("file name -> " + file.getFileName());
        return FileVisitResult.CONTINUE; // означает продолжать работу
    }

    @Override // срабатывает когда файл по каким либо причинам не доступен
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.out.println("error while visiting file -> " + file.getFileName());
        return  FileVisitResult.TERMINATE; //остановиться
    }

    @Override //срабатывает после обращения ко всем элементам папки
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        System.out.println("Exit from directory xxx-> "+ dir);
        return FileVisitResult.CONTINUE; // означает продолжать работу
    }
}
