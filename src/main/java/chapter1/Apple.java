package chapter1;

import chapter2.Predicate;

import java.util.ArrayList;
import java.util.List;

public class Apple {
    private String color;
    private Double weight;

    public Apple() {
    }

    public Apple(Double weight) {
        this.weight = weight;
    }

    public Apple(String color, double weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public Double getWeight() {
        return weight;
    }

    public static List<Apple> filter(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if(p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Apple apple = (Apple) o;

        if (Double.compare(apple.weight, weight) != 0) return false;
        return color != null ? color.equals(apple.color) : apple.color == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = color != null ? color.hashCode() : 0;
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
