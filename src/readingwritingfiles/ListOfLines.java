package readingwritingfiles;

import java.util.*;
import java.nio.file.*;

public class ListOfLines {
    public static void
    main(String[] args) throws Exception {
        Files.readAllLines(
                        Paths.get("Cheese.dat"))
                .stream()
                .filter(line -> !line.startsWith("//"))
                .map(line ->
                        line.substring(0, line.length()/2))
                .forEach(System.out::println);
    }
}

