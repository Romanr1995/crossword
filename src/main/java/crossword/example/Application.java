package crossword.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext("crossword.example");

        SolvingCrossword bean = context.getBean(SolvingCrossword.class);

        bean.getOptions("абажурчик**");
    }
}
