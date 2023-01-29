package com.me.injin.modernjavainaction.ch02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static com.me.injin.modernjavainaction.ch02.Ch02.Color.GREEN;
import static com.me.injin.modernjavainaction.ch02.Ch02.Color.RED;

public class Ch02 {

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(80, Color.GREEN),
                new Apple(155, Color.GREEN),
                new Apple(120, RED));

        // [Apple{color=GREEN, weight=80}, Apple{color=GREEN, weight=155}]
        List<Apple> greenApples = filterApplesByColor(inventory, Color.GREEN);
        System.out.println(greenApples);

        // [Apple{color=RED, weight=120}]
        List<Apple> redApples = filterApplesByColor(inventory, RED);
        System.out.println(redApples);

        // [Apple{color=GREEN, weight=80}, Apple{color=GREEN, weight=155}]
        List<Apple> greenApples2 = filterApples(inventory, new AppleColorPredicate());
        System.out.println(greenApples2);

        // [Apple{color=GREEN, weight=155}]
        List<Apple> heavyApples = filterApples(inventory, new AppleWeightPredicate());
        System.out.println(heavyApples);

        // []
        List<Apple> redAndHeavyApples = filterApples(inventory, new AppleRedAndHeavyPredicate());
        System.out.println(redAndHeavyApples);

        System.out.println("====");

        prettyPrintApple(inventory, new AppleSimpleFormatter());
        System.out.println("====");
        prettyPrintApple(inventory, new AppleFancyFormatter());

        System.out.println("======================");

        //thread
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world");
            }
        });
        thread.run();
        //lambda
        Thread t = new Thread(() -> System.out.println("Hello world"));
        t.run();
        //Callable
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> threadName = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return Thread.currentThread().getName();
            }
        });
        System.out.println("threadName = " + threadName);

        //Callable lambda
        Future<String> threadName2 = executorService.submit(() -> Thread.currentThread().getName());
        System.out.println("threadName2 = " + threadName2);

    }

    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (GREEN.equals(apple.getColor())) result.add(apple);
        }
        return result;
    }

    public static List<Apple> filterApplesByColor(List<Apple> inventory, Color color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getColor() == color) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getWeight() > weight) {
                result.add(apple);
            }
        }
        return result;
    }


    enum Color {
        RED, GREEN,
    }

    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) result.add(apple);
        }
        return result;
    }

    interface ApplePredicate {
        boolean test(Apple a);
    }

    public static class AppleWeightPredicate implements ApplePredicate {
        @Override
        public boolean test(Apple apple) {
            return apple.getWeight() > 150;
        }

    }

    public static class AppleColorPredicate implements ApplePredicate {
        @Override
        public boolean test(Apple a) {
            return a.getColor() == GREEN;
        }
    }

    public static class AppleRedAndHeavyPredicate implements ApplePredicate {
        @Override
        public boolean test(Apple a) {
            return a.getColor() == RED && a.getWeight() > 150;
        }
    }


    public static class Apple {

        private int weight = 0;
        private Color color;

        public Apple(int weight, Color color) {
            this.weight = weight;
            this.color = color;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }

        @SuppressWarnings("boxing")
        @Override
        public String toString() {
            return String.format("Apple{color=%s, weight=%d}", color, weight);
        }

    }

    //quiz 2-1

    public static void prettyPrintApple(List<Apple> inventory, AppleFormatter formatter) {
        for (Apple apple : inventory) {
            String output = formatter.accept(apple);
            System.out.println(output);
        }
    }

    public interface AppleFormatter {
        String accept(Apple a);

    }

    public static class AppleFancyFormatter implements AppleFormatter {
        public String accept(Apple apple) {
            String characteristic = apple.getWeight() > 150 ? "heavy" : "light";
            return "A " + characteristic + " " + apple.getColor() + " apple";
        }

    }

    public static class AppleSimpleFormatter implements AppleFormatter {
        public String accept(Apple apple) {
            return "An apple of " + apple.getWeight() + "g";
        }

    }

}
