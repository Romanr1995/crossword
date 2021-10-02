package crossword.example.service;

import java.util.List;

public interface SolvingCrossword {

    /**
     *
     * @param wordToGuess - слово с пропущенными буквами по которому мы ищем совпадающие слова
     * @return список слов,которые соответствуют длине wordToGuess и значения
     * букв которых совпадают с известными буквами wordToGuess
     */
    List<String> getOptions(String wordToGuess);
}
