package com.me.injin.modernjavainaction.ch03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.me.injin.modernjavainaction.ch03.Color.GREEN;

public class Lambdas {
    public static void main(String[] args) {
        Runnable r = () -> System.out.println("Hello");
        r.run();

        List<Apple> inventory = Arrays.asList(
                new Apple(80, GREEN),
                new Apple(155, GREEN),
                new Apple(120, Color.RED)
        );

        List<Apple> greenApples = filter(inventory, (Apple a) -> GREEN.equals(a.getColor()));
        //[Apple{color=GREEN, weight=80}, Apple{color=GREEN, weight=155}]
        System.out.println(greenApples);


    }

    public static List<Apple> filter(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    interface ApplePredicate {

        boolean test(Apple a);

    }
}
