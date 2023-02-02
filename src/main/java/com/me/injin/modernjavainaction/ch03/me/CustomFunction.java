package com.me.injin.modernjavainaction.ch03.me;

import java.math.BigDecimal;

public class CustomFunction {
    public static void main(String[] args) {
        prinLn(1, 2, 3, (i1, i2, i3) -> String.valueOf(i1 + i2 + i3));
        prinLn("Area is ", 3, 4, (message, length, width) -> message + (length * width));

        System.out.println("==============================");

        BigDecimalToCurrency bigDecimalToCurrency = bd -> "$" + bd;
        System.out.println(bigDecimalToCurrency.toCurrency(new BigDecimal("123.00")));

        System.out.println("==============================");

        InvalidFunctionalINterface anonymousClass = new InvalidFunctionalINterface() {
            @Override
            public <T> String mkString(T value) {
                return value.toString();
            }
        };
        System.out.println("annonymousClass = " + anonymousClass.mkString("abcd"));


        //Target method is generic
        //InvalidFunctionalINterface invalidFunctionalINterface = value -> value.toString();
    }

    private static <T1, T2, T3> void prinLn(T1 t1, T2 t2, T3 t3, Function<T1, T2, T3, String> function) {
        System.out.println(function.apply(t1, t2, t3));
    }
}

@FunctionalInterface
interface Function<T1, T2, T3, R> {
    R apply(T1 t1, T2 t2, T3 t3);
}

@FunctionalInterface
interface BigDecimalToCurrency {
    String toCurrency(BigDecimal value);
}

@FunctionalInterface
interface InvalidFunctionalINterface {
    <T> String mkString(T value);
}