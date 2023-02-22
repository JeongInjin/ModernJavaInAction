package com.me.injin.modernjavainaction.ch03.mjia;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        final List<String> listOfStrings = Arrays.asList("a", "", "c", "d", "e");
        final List<String> nonEmpty = filter(listOfStrings, nonEmptyStringPredicate);
        System.out.println("nonEmpty = " + nonEmpty);
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> results = new ArrayList<>();
        for (T t : list) {
            if (p.test(t)) {
                results.add(t);
            }
        }
        return results;
    }

    static Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();

}
