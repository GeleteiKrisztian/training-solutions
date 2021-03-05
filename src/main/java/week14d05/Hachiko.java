package week14d05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Hachiko {

    public static final String FILE = "src/main/resources/hachiko.srt";
    private final String WORD_TO_FIND = "hachiko";

    public long countHachiko() {
        long wordCounter = 0;
        Path path = Path.of(FILE);
        try {
            Stream<String> fileLines = Files.lines(path);
          List<List<String>> lineWords = fileLines.filter(line -> line.toLowerCase().contains(WORD_TO_FIND)).map(s -> s.toLowerCase().split(" ")).map(strings -> Arrays.asList(strings)).collect(Collectors.toList());
          wordCounter = lineWords.stream().flatMap(l -> l.stream()).filter(word -> word.contains(WORD_TO_FIND)).count();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return wordCounter;
    }
}
