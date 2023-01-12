package tests;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PartsOfPathsTest {
    public static void main(String[] args) {
        Path path = Paths.get("file1.txt").toAbsolutePath();
        System.out.println(path);
        for (int i = 0; i < path.getNameCount(); i++) {
            System.out.print(i + ": " + path.getName(i) + "\n");
        }
        System.out.println(path.endsWith("file1.txt"));
        System.out.println(path.startsWith("C:\\"));

    }
}
