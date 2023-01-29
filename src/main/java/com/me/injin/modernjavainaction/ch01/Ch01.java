package com.me.injin.modernjavainaction.ch01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

public class Ch01 {

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red")
        );

        //[Apple{color='green', weight=80}, Apple{color='green', weight=155}]
        System.out.println(filterApples(inventory, Ch01::isGreenApple));
        //[Apple{color='green', weight=155}]
        System.out.println(filterApples(inventory, Ch01::isHeavyApple));

        System.out.println("===");

        //람다형식으로
        //[Apple{color='green', weight=80}, Apple{color='green', weight=155}]
        System.out.println(filterApples(inventory, (Apple a) -> "green".equals(a.getColor())));
        //[Apple{color='green', weight=155}]
        System.out.println(filterApples(inventory, (Apple a) -> a.getWeight() > 150));
        //[Apple{color='red', weight=120}]
        System.out.println(filterApples(inventory, (Apple a) -> a.getWeight() < 80 || "red".equals(a.getColor())));

        System.out.println("===");

        //스트림 순차 처리 방식
        List<Apple> collect = inventory.stream().filter((Apple a) -> a.getWeight() > 150).collect(toList());
        System.out.println("collect = " + collect);
        //스트림 병렬 처리 방식
        List<Apple> collect2 = inventory.parallelStream().filter((Apple a) -> a.getWeight() > 150).collect(toList());
        System.out.println("collect2 = " + collect2);
    }

    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterHeavyApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getWeight() > 150) {
                result.add(apple);
            }
        }
        return result;
    }

    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }
    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) result.add(apple);
        }
        return result;
    }

    public static class Apple {

        private int weight = 0;
        private String color = "";

        public Apple(int weight, String color) {
            this.weight = weight;
            this.color = color;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        @SuppressWarnings("boxing")
        @Override
        public String toString() {
            return String.format("Apple{color='%s', weight=%d}", color, weight);
        }

    }
}
