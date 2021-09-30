package crossword.example.service;

import crossword.example.data.WordReader;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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
        List<String> wordBook = wordReader.getWords().get(wordToGuess.length());

        OUT:
        for (String s : wordBook) {

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
