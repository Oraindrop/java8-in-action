package chapter4;

public class Dish {
    private String name;
    private boolean vegetarian;
    private int Calorie;
    private Type type;

    public Dish(String name, boolean vegetarian, int calorie, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        Calorie = calorie;
        this.type = type;
    }

    public Dish(int calorie) {
        Calorie = calorie;
    }

    public Dish(String name, int calorie) {
        this.name = name;
        Calorie = calorie;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalorie() {
        return Calorie;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public enum Type {
        MEAT, FISH, OTHER
    }
}
