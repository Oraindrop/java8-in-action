package chpater3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionalInterfaceTest {
    @Test
    public void functionalInterfaces() {
        Predicate<String> nonEmptyStringPredicate = (s) -> !s.isEmpty();
        predicateExample(Arrays.asList("a", "b", "c", "", "e"), nonEmptyStringPredicate);
        consumerExample(Arrays.asList(1, 2, 3, 4, 5), (Integer i) -> System.out.println("hello" + i));
    }

    private static void predicateExample(List<String> ss, Predicate<String> p) {
        for (String s : ss) {
            if(p.test(s)) System.out.println(s);
        }
    }

    private static void consumerExample(List<Integer> ii, Consumer<Integer> c) {
        for (Integer i : ii) {
            c.accept(i);
        }
    }

    @Test
    public void functionTest() {
        System.out.println(map(Arrays.asList("lambda", "in", "action"), (String s) -> s.length()));
    }

    private static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(f.apply(t));
        }
        return result;
    }
}
