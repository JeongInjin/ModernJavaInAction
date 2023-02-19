package com.me.injin.modernjavainaction.ch04.me;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.*;

public class StreamExample3 {
    public static void main(String[] args) {
        final List<Integer> numbers = Arrays.asList(1, 3, 3, 5, 5);
        System.out.println(
                numbers.stream()
                        .filter(i -> i > 2)
                        .map(i -> i * 2)
                        .map(i -> "# " + i)
                        .collect(toList())
        );

        System.out.println(
                numbers.stream()
                        .filter(i -> i > 2)
                        .map(i -> i * 2)
                        .map(i -> "# " + i)
                        .collect(toSet())
        );

        System.out.println(
                numbers.stream()
                        .filter(i -> i > 2)
                        .map(i -> i * 2)
                        .map(i -> "# " + i)
                        .collect(joining(", "))
        );

        System.out.println(
                numbers.stream()
                        .filter(i -> i > 2)
                        .map(i -> i * 2)
                        .map(i -> "# " + i)
                        .collect(joining(", ", "[", "]"))
        );

        System.out.println(
                numbers.stream()
                        .filter(i -> i > 2)
                        .map(i -> i * 2)
                        .map(i -> "# " + i)
                        .distinct()
                        .collect(joining(", ", "[", "]"))
        );

        System.out.println(
                numbers.stream()
                        .filter(i -> i > 2)
                        .map(i -> i * 2)
                        .map(i -> "# " + i)
                        .distinct()
                        .collect(toList())
        );

        System.out.println("==============================");

        final Integer interger3 = 3;
        final Integer interger127 = 127;
        final Integer interger128 = 128;
        final Integer interger129 = 129;
        final List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5, 127, 128, 129);
        System.out.println(
                numbers2.stream()
                        .filter(i -> i == interger3)
                        .findFirst()
        );

        System.out.println(
                numbers2.stream()
                        .filter(i -> i == interger127)
                        .findFirst()
        );

        // Interger.valueOf
        System.out.println(
                numbers2.stream()
                        .filter(i -> i == interger128)
                        .findFirst()
        );

        System.out.println(
                numbers2.stream()
                        .filter(i -> i.equals(interger129))
                        .findFirst()
        );

        System.out.println(
                numbers2.stream()
                        .filter(i -> i > interger3)
                        .count()
        );


    }
}
