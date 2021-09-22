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

    @Override
    public List<String> getWords() {
        List<String> wordboks = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(getClass().getClassLoader()
                .getResource("russian.txt").getFile(), Charset.forName("windows-1251")))) {
            String line;
            while (reader.ready()) {
                wordboks.add(reader.readLine());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordboks;
    }
}
