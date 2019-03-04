package chapter2;

import chapter1.Apple;

public interface Predicate<T> {
    boolean test(T t);
}
