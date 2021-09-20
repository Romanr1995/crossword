package crossword.example.service;

import java.util.List;

public interface SolvingCrossword {

    List<String> getOptions(String wordToGuess);
}
