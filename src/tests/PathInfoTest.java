package tests;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathInfoTest {
    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));
        Path path = Paths.get("D:\\Desktop\\MyTXT.txt");
        System.out.println(Files.exists(path));
    }
}
