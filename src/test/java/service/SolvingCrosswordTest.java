package service;

import crossword.example.data.WordReaderImpl;
import crossword.example.service.SolvingCrossword;
import crossword.example.service.SolvingCrosswordImpl;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolvingCrosswordTest {

    SolvingCrossword solvingCrossword = new SolvingCrosswordImpl(new WordReaderImpl());

    public SolvingCrosswordTest() throws IOException {

    }

    @Test
    public void проверитьСловоИзНачалаСловаря() {
        assertEquals(List.of("абажурчикам", "абажурчиках", "абажурчиков", "абажурчиком"), solvingCrossword.getOptions("абажурчик**"));
    }

    @Test
    public void проверитьСловоИзСерединыСловаря() {
        assertEquals(List.of("педали", "педаль"), solvingCrossword.getOptions("педал*"));
    }

    @Test
    public void проверитьСловоИзКонцаСловаря() {
        assertEquals(List.of("посмурневшие", "посмурневший"), solvingCrossword.getOptions("*осмурневши*"));
    }

    @Test
    public void пустойЗапрос() {
        Assertions.assertThrows(
                RuntimeException.class,
                () -> solvingCrossword.getOptions("")
        );
    }

    @Test
    public void несуществующееСлово() {

        assertEquals(List.of(), solvingCrossword.getOptions("пывпы*пыапыапып****вапвыпвып"));
    }
}
