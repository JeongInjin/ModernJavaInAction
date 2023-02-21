package com.me.injin.modernjavainaction.example.me.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamExample2 {
    public static void main(String[] args) {
//        Stream.of(1, 2, 3, 4, 5).forEach(i -> System.out.print(i + " "));
//        System.out.println();
        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer result = null;
        for (Integer number : numbers) {
            if (number > 3 && number < 9) {
                final int newNumber = number * 2;
                if (newNumber > 10) {
                    result = newNumber;
                    break;
                }
            }
        }
        System.out.println("result = " + result);

        Optional<Integer> first = numbers.stream()
                .filter(number -> number > 3)
                .filter(number -> number < 9)
                .map(number -> number * 2)
                .filter(number -> number > 10)
                .findFirst();
        System.out.println("Functional Result: " + first);

    }
}
