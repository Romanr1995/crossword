package crossword.example.data;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@Component
public class WordReaderImpl implements WordReader {

    private final List<String> words;

    public WordReaderImpl() throws IOException{
        this.words = readWordsFile();
    }

    @Override
    public List<String> getWords() {
       return words;
    }

    private List<String > readWordsFile() throws IOException {
        final List<String> words = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(getClass().getClassLoader()
                .getResource("russian.txt").getFile(), Charset.forName("windows-1251")))) {
            String line;
            while ((line = reader.readLine()) != null) {
                words.add(line);
            }

        }
        return words;
    }
}
