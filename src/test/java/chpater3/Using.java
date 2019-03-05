package chpater3;

import chapter1.Apple;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import static java.util.Comparator.*;

public class Using {
    @Test
    public void test() {
        List<Apple> inventory = new ArrayList<>();
        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple a1, Apple a2) {
                return a1.getWeight().compareTo(a2.getWeight());
            }
        });

        inventory.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));
        inventory.sort((a1, a2) -> a1.getWeight().compareTo(a2.getWeight()));
        inventory.sort(Comparator.comparing(a -> a.getWeight()));
        inventory.sort(comparing(Apple::getWeight));

    }
}
