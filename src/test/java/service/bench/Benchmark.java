package service.bench;

import crossword.example.data.WordReaderImpl;
import crossword.example.service.SolvingCrossword;
import crossword.example.service.SolvingCrosswordImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { SolvingCrosswordImpl.class, WordReaderImpl.class })
public class Benchmark {

    public static final int SIZE = 5000;
    @Autowired
    SolvingCrossword solver;

    @Test
    public void bench() {
        long start = System.currentTimeMillis();

        for (int i = 0; i < SIZE; i++) {
            solver.getOptions("*бл**о");
        }

        System.out.println("Finished : " + (System.currentTimeMillis() - start) + " ms");
    }
}
