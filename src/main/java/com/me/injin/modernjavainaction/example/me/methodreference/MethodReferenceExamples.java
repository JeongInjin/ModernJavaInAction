package com.me.injin.modernjavainaction.example.me.methodreference;

import java.math.BigDecimal;
import java.util.Arrays;

import static java.util.stream.Collectors.toList;

public class MethodReferenceExamples {
    public static void main(String[] args) {
        Arrays.asList(1, 2, 3, 4, 5)
                .forEach(i -> System.out.println(i));

        Arrays.asList(1, 2, 3, 4, 5)
                .forEach(System.out::println);

        System.out.println("=========================================");
        System.out.println(
                Arrays.asList(new BigDecimal("10.0"), new BigDecimal("13"), new BigDecimal("5"))
                        .stream()
                        .sorted()
                        .collect(toList())
        );

        System.out.println(
                Arrays.asList(new BigDecimal("10.0"), new BigDecimal("13"), new BigDecimal("5"))
                        .stream()
//                        .sorted((bd1, bd2) -> bd1.compareTo(bd2))
                        .sorted(BigDecimalUtil::compare)
                        .collect(toList())
        );

        System.out.println(
                Arrays.asList(new BigDecimal("10.0"), new BigDecimal("13"), new BigDecimal("5"))
                        .stream()
                        .sorted(BigDecimalUtil::compare)
                        .collect(toList())
        );

        System.out.println("=========================================");

        System.out.println(
                Arrays.asList("a", "b", "c", "d")
                        .stream()
                        .anyMatch(x -> x.equals("c"))
        );

        final String targetString = "c";
        System.out.println(
                Arrays.asList("a", "b", "c", "d")
                        .stream()
                        .anyMatch(targetString::equals)
        );
    }
}

class BigDecimalUtil {
    public static int compare(BigDecimal bd1, BigDecimal bd2) {
        return bd1.compareTo(bd2);
    }
}