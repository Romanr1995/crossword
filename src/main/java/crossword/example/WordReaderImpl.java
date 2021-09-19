package crossword.example;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Component
public class WordReaderImpl implements WordReader {

    @Override
    public List<String> getWords() {
        List<String> woordbooks = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Администратор" +
                "\\Desktop\\Favorites" +
                "\\russian-words-master\\russian-words-master\\russian.txt",
                StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                woordbooks.add(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return woordbooks;
    }
}
