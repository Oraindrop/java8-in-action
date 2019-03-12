package chapter4;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class DishTest {

    @Test
    public void findLowCalories() {
        List<Dish> menu =
                new ArrayList<>(Arrays.asList(
                        new Dish("a", 500),
                        new Dish("b", 300),
                        new Dish("c", 700),
                        new Dish("d", 100)));
        List<Dish> lowCaloricDishes = new ArrayList<>();    // garbage variable
        for (Dish d : menu) {
            if(d.getCalorie() < 400) {
                lowCaloricDishes.add(d);
            }
        }

        // sortWithAnonymousClass
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish d1, Dish d2) {
                return Integer.compare(d1.getCalorie(), d2.getCalorie());
            }
        });

        // getNameFromList
        List<String> lowCaloricDishesName = new ArrayList<>();
        for (Dish d : lowCaloricDishes) {
            lowCaloricDishesName.add(d.getName());
        }
        System.out.println(lowCaloricDishesName);
    }

    @Test
    public void useStream() {
        List<Dish> menu =
                new ArrayList<>(Arrays.asList(
                        new Dish("a", 500),
                        new Dish("b", 300),
                        new Dish("c", 700),
                        new Dish("d", 100)));

        List<String> lowCaloricDishesName = menu.parallelStream()
                .filter(d -> d.getCalorie() < 400)
                .sorted(Comparator.comparing(Dish::getCalorie))
                .map(Dish::getName)
                .collect(Collectors.toList());

        System.out.println(lowCaloricDishesName);
    }

    @Test
    public void startStream() {
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

        List<String> threeHighCaloricDishNames =
                menu.stream()
                .filter(d -> d.getCalorie() > 300)
                .map(Dish::getName)
                .limit(3)
                .collect(Collectors.toList());

        System.out.println(threeHighCaloricDishNames);

//        List<String> names = new ArrayList<>();
//        for (Dish d : menu) {
//            names.add(d.getName());
//        }
//
//        List<String> streamNames =
//                menu.stream()
//                .map(Dish::getName)
//                .collect(Collectors.toList());

        List<String> names =
                menu.stream()
                        .filter(d -> {
                            System.out.println("filtering" + d.getName());
                            return d.getCalorie() > 300;
                        })
                        .map(d -> {
                            System.out.println("mapping" + d.getName());
                            return d.getName();
                        })
                        .limit(3)
                        .collect(Collectors.toList());
        System.out.println(names);

    }
}