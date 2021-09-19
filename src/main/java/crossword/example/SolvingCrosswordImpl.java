package crossword.example;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class SolvingCrosswordImpl implements SolvingCrossword {

    private final WordReader wordReader;

    public SolvingCrosswordImpl(WordReader wordReader) {
        this.wordReader = wordReader;
    }

    @Override
    public List<String> getOptions(String wordToGuess) {
        List<String> result = new ArrayList<>();

        List<String> woordBook = wordReader.getWords();
        List<String> filter1 = woordBook.stream().filter(s -> s.length() == wordToGuess.length())
                .collect(Collectors.toList());

        Map<Integer, Character> letters = new HashMap<>();
        for (int i = 0; i < wordToGuess.length(); i++) {

            if (wordToGuess.charAt(i) != '*') {
                letters.put(i, wordToGuess.charAt(i));
            }
        }
        List<String> filter2 = new ArrayList<>();
        for (Map.Entry<Integer, Character> m : letters.entrySet()) {
            Integer index = m.getKey();
            Character letter = m.getValue();

            filter2 = filter1.stream().filter(s -> s.charAt(index) == letter)
                    .collect(Collectors.toList());
        }
        result.addAll(filter2);
        return result;
    }
}
