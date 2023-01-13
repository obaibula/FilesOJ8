package directories;

import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.io.IOException;

/*The Files utility class contains most of the operations you’ll need for directory and
file manipulation. For some reason, however, they did not include a tool to delete
directory trees, so we’ll create one and add it to the onjava library.*/

public class RmDir {
    public static void rmdir(Path dir)
            throws IOException {
        Files.walkFileTree(dir,
                new SimpleFileVisitor<Path>() {
                    @Override public FileVisitResult
                    visitFile(Path file, BasicFileAttributes attrs)
                            throws IOException {
                        Files.delete(file);
                        return FileVisitResult.CONTINUE;
                    }
                    @Override public FileVisitResult
                    postVisitDirectory(Path dir, IOException exc)
                            throws IOException {
                        Files.delete(dir);
                        return FileVisitResult.CONTINUE;
                    }
                });
    }
}

