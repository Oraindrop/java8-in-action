package chpater3;

import chapter1.Apple;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class Lambda {
    @FunctionalInterface
    public interface F3{
        void test(int x, int y);
    }

    @FunctionalInterface
    public interface F4{
        int test();
    }

    @Test
    public void comparator() {
        Comparator<Apple> byWeight = new Comparator<Apple>() {
            @Override
            public int compare(Apple a1, Apple a2) {
                return a1.getWeight().compareTo(a2.getWeight());
            }
        };
        // use lambda
        Comparator<Apple> byWeightUseLambda = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());

        // use intellij
        Comparator<Apple> byWeightUseIntellij = Comparator.comparing(Apple::getWeight);
    }

    @Test
    public void lambdaExpressions() {
        Function<String, Integer> f1 = (String s) -> s.length();
        Function<Apple, Boolean> f2 = (Apple a) -> a.getWeight() > 150;
        F3 f3 = (x, y) -> {
            System.out.println("Result:");
            System.out.println(x+y);
        };
        F4 f4 = () -> 42;

        Comparator<Apple> byWeightUseLambda = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
    }

    @Test
    public void filterTest() {
        List<Apple> inventory = new ArrayList<>();
        List<Apple> greenApples = Apple.filter(inventory, (Apple a) -> "green".equals(a.getColor()));
    }

    @Test
    public void runnableTest() {
        // use Lambda
        Runnable r1 = () -> System.out.println("Hello World 1");

        // use Anonymous Class
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World 2");
            }
        };
        process(r1);
        process(r2);
        process(()-> System.out.println("Hello World 3"));
    }

    private static void process(Runnable r) {
        r.run();
    }
}
