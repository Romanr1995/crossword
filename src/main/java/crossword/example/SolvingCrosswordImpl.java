package crossword.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SolvingCrosswordImpl implements SolvingCrossword {

    private final static List<String> woordbooks1 = new ArrayList<>();

    public static void main(String[] args) {
    SolvingCrosswordImpl s1 = new SolvingCrosswordImpl();
        BufferedReader br;

        {
            try {
                br = new BufferedReader(new FileReader("C:\\Users\\Администратор\\Desktop\\Favorites" +
                        "\\russian-words-master\\russian-words-master\\russian.txt",
                        Charset.forName("windows-1251")));
                String line;
                while ((line = br.readLine()) != null) {
                    woordbooks1.add(br.readLine());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(woordbooks1.get(20) + " " + woordbooks1.get(20).length());
    }

    @Override
    public  List<String> getOptions(String wordToGuess,List<String> woordbook) {
        List<String> result = new ArrayList<>();

        List<String> filter1 = woordbook.stream().filter(s -> s.length() == wordToGuess.length())
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
