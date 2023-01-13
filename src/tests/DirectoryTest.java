package tests;

import directories.RmDir;

import java.io.IOException;
import java.nio.file.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class DirectoryTest {
    static Path path = Paths.get("Xdir");
    static Path variant = Paths.get("Xdir", "Sdir", "Wdir", "Bdir");

    static void refreshXdir() throws Exception {
        if (Files.exists(path)) {
            RmDir.rmdir(path);
        }
        if (!Files.exists(path)) {
            Files.createDirectory(path);
        }
    }

    static void refreshVariant() throws Exception {
        if (Files.exists(variant)) {
            RmDir.rmdir(variant);
        }
        if (!Files.exists(variant)) {
            Files.createDirectories(variant);
        }
    }

    public static void main(String[] args) throws Exception {
        refreshXdir();
        refreshVariant();

        //clear if Sieg exists
        if (Files.exists(Paths.get("Power")))
            RmDir.rmdir(Paths.get("Power"));


        //rename all dirs and subdirs:

        List<String> names = Arrays.asList("Sieg", "Heil", "White", "Power");
        Iterator<String> namesIt = names.iterator();

        Files.walkFileTree(path,
                new SimpleFileVisitor<Path>() {
                    @Override
                    public FileVisitResult postVisitDirectory(Path dir, IOException exc)
                            throws IOException {
                        Files.move(dir, dir.resolveSibling(namesIt.next()));
                        return FileVisitResult.CONTINUE;
                    }
                });

        path = Paths.get("Power");

        //test streams:
        //use try of resources, because of file-manipulations
        try(Stream<Path> entries =   Files.walk(path)){
            entries.limit(4)
                    .forEach(pp -> {
                        try {
                            Files.createFile(pp.resolve("test.txt"));
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        }
    }
}
