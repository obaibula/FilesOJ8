package tests;

import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class FindTesting {
    public static void main(String[] args) {
        Path path = Paths.get("C:\\Users\\kuznetsov.aa.HITED1UA\\IdeaProjects\\FilesOJ8");
        System.out.println(path);
        PathMatcher pathMatcher = FileSystems.getDefault()
                .getPathMatcher("glob:**/*.{tmp,txt}");

        try(Stream<Path> entries = Files.walk(path)){
            entries/*.filter(Files::isRegularFile)
                    .map(Path::getFileName)*/
                    .filter(pathMatcher::matches)
                    .forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
