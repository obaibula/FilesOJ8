package readingwritingfiles;

import java.nio.file.*;

public class ReadLineStream {
    public static void
    main(String[] args) throws Exception {
        Files.lines(Paths.get("src\\paths\\PathInfo.java"))
                .skip(13)
                .findFirst()
                .ifPresent(System.out::println);
    }
}

