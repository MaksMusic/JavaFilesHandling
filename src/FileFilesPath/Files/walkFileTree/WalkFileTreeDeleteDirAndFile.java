package FileFilesPath.Files.walkFileTree;


import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class WalkFileTreeDeleteDirAndFile {
    public static void main(String[] args) throws IOException {
        //удаляет все содержимое папки и саму папку
        Path path = Paths.get("C:\\Users\\Admin\\IdeaProjects\\JavaFilesHandling\\src\\copyH1");
        Files.walkFileTree(path,new MyFileVisitorDelete());
    }
}

class MyFileVisitorDelete extends SimpleFileVisitor<Path> {
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println( " delete file -->" + file.getFileName());
        Files.delete(file);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        System.out.println("delete dir  --> " + dir);
        Files.delete(dir);
        return FileVisitResult.CONTINUE;
    }
}


