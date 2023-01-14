package tests;

import directories.RmDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirectoryTest {
    static Path path = Paths.get("Xdir");
    static void refreshXdir() throws Exception{
        if(Files.exists(path))
            RmDir.rmdir(path);
        if(!Files.exists(path))
            Files.createDirectory(path);
    }

    public static void main(String[] args) throws Exception {
        refreshXdir();
        Path variant = Paths.get("Xdir", "Sdir", "Wdir", "Bdir");
        Files.createDirectories(variant);
        Files.walk(path)
                .map(source -> {
                    try {
                        return Files.move(source, source.resolveSibling("photos"));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
    }
}
