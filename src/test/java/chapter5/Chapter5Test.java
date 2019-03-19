package chapter5;
import chapter4.Dish;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.*;
public class Chapter5Test {
    List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH)
    );
    @Test
    public void predicateFilter() {
        List<Dish> vegetarianMenu = menu.stream()
                .filter(Dish::isVegetarian)
                .collect(Collectors.toList());
    }

    @Test
    public void uniqueFilter() {
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream().filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);
    }

    @Test
    public void limit() {
        List<Dish> dishes = menu.stream()
                .filter(d -> d.getCalorie() > 300)
                .limit(3)
                .collect(Collectors.toList());
    }

    @Test
    public void skip() {
        List<Dish> dishes = menu.stream()
                .filter(d -> d.getCalorie() > 300)
                .skip(2)
                .collect(Collectors.toList());
    }

    @Test
    public void mapName() {
        List<String> dishNames = menu.stream()
                .map(Dish::getName)
                .collect(Collectors.toList());
    }

    @Test
    public void mapLength() {
        List<String> words = Arrays.asList("Java8", "Lambda", "In", "Action");
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println(wordLengths);
    }

    @Test
    public void mapChaining() {
        List<Integer> dishNames = menu.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println(dishNames);
    }

    @Test
    public void stringMap() {
        List<String> words = Arrays.asList("Hello", "World");
        words.stream()
                .map(word -> word.split(""))
                .map(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
    }

    @Test
    public void streamMap() {
        String[] arrayOfWords = {"Goodbye", "World"};
        System.out.println(Arrays.stream(arrayOfWords));
    }

    @Test
    public void useFlatMap() {
        List<String> words = Arrays.asList("Hello", "World");
        List<String> list = words.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(list);
    }

    @Test
    public void powMap() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = list.stream()
                .map(i -> i*i)
                .collect(Collectors.toList());
    }

    @Test
    public void pairMap() {
        List<Integer> aList = Arrays.asList(1, 2, 3);
        List<Integer> bList = Arrays.asList(4, 5);
        List<int[]> list = aList.stream()
                .flatMap(i -> bList.stream()
                        .map(j -> new int[]{i, j}))
                .collect(Collectors.toList());
    }

    @Test
    public void pairConditionMap() {
        List<Integer> aList = Arrays.asList(1, 2, 3);
        List<Integer> bList = Arrays.asList(4, 5);
        List<int[]> list = aList.stream()
                .flatMap(i -> bList.stream()
                        .filter(j -> (i + j) % 3 == 0)
                        .map(j -> new int[]{i, j}))
                .collect(Collectors.toList());
    }

    @Test
    public void anyMatchTest() {
        if(menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("any");
        }

        if(menu.stream().allMatch(Dish::isVegetarian)) {
            System.out.println("all");
        }
    }

    @Test
    public void reduceTest() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers.stream().reduce(0, (a, b) -> a + b);
        int sum2 = numbers.stream().reduce(0, Integer::sum);
        Optional<Integer> max = numbers.stream().reduce(Integer::max);
        System.out.println(sum);
    }

    @Test
    public void primitiveStream() {
        int calories = menu.stream()
                .mapToInt(Dish::getCalorie)
                .sum();

        IntStream intStream = menu.stream().mapToInt(Dish::getCalorie);
        Stream<Integer> stream = intStream.boxed();

        OptionalInt maxCalories = menu.stream()
                .mapToInt(Dish::getCalorie)
                .max();
    }

    @Test
    public void range() {
        IntStream evenNumbers = IntStream.rangeClosed(1, 100)
                .filter(n -> n % 2 == 0);
    }
}
