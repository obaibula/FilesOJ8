package tests;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathInfoTest {
    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));
        Path path = Paths.get("file1.txt");
        path = path.toAbsolutePath();
        System.out.println(path);
        System.out.println(Files.exists(path));
        System.out.println(Files.isRegularFile(path));
        System.out.println(Files.isDirectory(path));
        System.out.println(path.isAbsolute());
        System.out.println(path.getFileName());
        System.out.println(path.getRoot());
        System.out.println(path.toUri());
        System.out.println(Files.exists(Paths.get(path.toUri())));
    }
}
