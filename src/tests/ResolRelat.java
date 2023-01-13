package tests;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ResolRelat {
    public static void main(String[] args) {
        Path path = Paths.get("file1.txt").toAbsolutePath();
        System.out.println(path);
        path = path.resolve(Paths.get("file1.txt"));
        System.out.println(path);
        path = path.relativize(Paths.get("C:\\Users\\kuznetsov.aa"));
    }
}
