package crossword.example.data;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class WordReaderImpl implements WordReader {

    private final Map<Integer, List<String>> words;

    public WordReaderImpl() throws IOException {
        this.words = readWordsFile();
    }

    @Override
    public Map<Integer, List<String>> getWords() {
        return words;
    }

    private Map<Integer, List<String>> readWordsFile() throws IOException {
        final List<String> words = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(getClass().getClassLoader()
                .getResource("russian.txt").getFile(), Charset.forName("windows-1251")))) {
            String line;
            while ((line = reader.readLine()) != null) {
                words.add(line);
            }

        }
        Map<Integer, List<String>> wordsJoinLength = words.stream()
                .collect(
                        Collectors.groupingBy(
                                word -> word.length()
                        )
                );
        return wordsJoinLength;
    }
}
