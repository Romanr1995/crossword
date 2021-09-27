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

        OUT:
        for (String s : wordBook) {
            if (s.length() != wordToGuess.length()) continue;

            for (int i = 0; i < wordToGuess.length(); i++) {
                char letter = wordToGuess.charAt(i);

                if (letter == '*') continue;

                if (s.charAt(i) != letter) {
                    continue OUT;
                }
            }
            result.add(s);
        }
        return result;
    }
}
