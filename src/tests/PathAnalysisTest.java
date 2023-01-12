package tests;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathAnalysisTest {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("file1.txt").toAbsolutePath();
        System.out.println(Files.size(path));
        System.out.println(Files.isWritable(path));
        System.out.println(Files.getLastModifiedTime(path));
    }
}
