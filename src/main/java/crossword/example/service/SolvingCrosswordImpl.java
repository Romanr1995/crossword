package crossword.example.service;

import crossword.example.data.WordReader;
import org.springframework.stereotype.Component;

import java.util.*;
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

        if (wordToGuess.length() == 0) {
            throw new RuntimeException("Введено некорректное значение");
        }
        List<String> wordBook = wordReader.getWords();

        List<String> filter1 = wordBook.stream().filter(s -> s.length() == wordToGuess.length())
                .collect(Collectors.toList());

        Map<Integer, Character> letters = new HashMap<>();
        for (int i = 0; i < wordToGuess.length(); i++) {

            if (wordToGuess.charAt(i) != '*') {
                letters.put(i, wordToGuess.charAt(i));
            }
        }
        OUT:
        for (String s : filter1) {
            for (Map.Entry<Integer, Character> m : letters.entrySet()) {
                Integer index = m.getKey();
                Character letter = m.getValue();

                if (s.charAt(index) != letter) {
                    continue OUT;
                }
            }
            result.add(s);
        }
        return result;
    }
}
