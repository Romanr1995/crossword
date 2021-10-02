package crossword.example.data;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface WordReader {


    Map<Integer, List<String>> getWords();
}
