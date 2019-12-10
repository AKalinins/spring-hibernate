package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HappyFortuneService implements FortuneService {

    static List<String> fortunes = new ArrayList<>(3);

    static {
        fortunes.add("Today is your lucky day!");
        fortunes.add("It'a a good day for practice!");
        fortunes.add("Sweaty day today!");
    }

    @Override
    public String getFortune() {
        Random random = new Random();
        return fortunes.get(random.nextInt(fortunes.size()));
    }
}
