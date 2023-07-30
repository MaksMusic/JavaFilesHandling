package FileFilesPath.Files.walkFileTree;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class WalkFileTreeCopyDirAndFile {
    public static void main(String[] args) throws IOException {
        Path source = Paths.get("C:\\Users\\Admin\\IdeaProjects\\JavaFilesHandling\\src\\h1");
        Path destination = Paths.get("C:\\Users\\Admin\\IdeaProjects\\JavaFilesHandling\\src\\copyH1");
        Files.walkFileTree(source,new MyFileVisitorCopy(source,destination));

    }
}

class MyFileVisitorCopy extends SimpleFileVisitor<Path> {
    private Path source;
    private Path destination;

    public MyFileVisitorCopy(Path source, Path destination) {
        this.source = source;
        this.destination = destination;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        Path newDestination = destination.resolve(source.relativize(dir));//создание папки в новом пути
        Files.copy(dir, newDestination,StandardCopyOption.REPLACE_EXISTING);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        Path newDestination = destination.resolve(source.relativize(file));//создание папки в новом пути
        Files.copy(file, newDestination,StandardCopyOption.REPLACE_EXISTING);
        return FileVisitResult.CONTINUE;
    }

}
