package crossword.example.data;

import java.util.List;
import java.util.Map;

public interface WordReader {

    /**
     *
     * @return словарь рассортированный по длине слов
     *Integer - длина слов
     * List<String> - список слов с данной длиной
     */
    Map<Integer, List<String>> getWords();
}
