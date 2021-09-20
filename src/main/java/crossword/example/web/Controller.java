package crossword.example.web;

import crossword.example.service.SolvingCrossword;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    private final SolvingCrossword solvingCrossword;

    public Controller(SolvingCrossword solvingCrossword) {
        this.solvingCrossword = solvingCrossword;
    }

    @PostMapping("/crossword")
    public List<String> crossword(@RequestBody String word) {
        return solvingCrossword.getOptions(word);
    }
}
