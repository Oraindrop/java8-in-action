package chpater3;

import chapter1.Apple;
import org.junit.Test;

import java.util.function.BiFunction;
import java.util.function.Function;

public class ConstructReferTest {
    @Test
    public void apple() {
        Double d = 300.0;
        Apple a1 = new Apple(d);

        Function<Double, Apple> c2 = Apple::new;
        Function<Double, Apple> c3 = (weight) -> new Apple(weight);

        Apple a2 = c2.apply(110.0);
        Apple a3 = c3.apply(110.0);
    }

    @Test
    public void apple2() {
        BiFunction<String, Double, Apple> c4 = Apple::new;
        Apple a4 = c4.apply("green", 10.0);

        BiFunction<String, Double, Apple> c5 = (s, d) -> new Apple(s, d);
        Apple a5 = c5.apply("red", 20.0);
    }
}
