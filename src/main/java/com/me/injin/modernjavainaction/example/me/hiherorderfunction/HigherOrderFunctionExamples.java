package com.me.injin.modernjavainaction.example.me.hiherorderfunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class HigherOrderFunctionExamples {
    public static void main(String[] args) {
        final Function<Function<Integer, String>, String> f = g -> g.apply(10);

        System.out.println(f.apply(i -> "#" + i));

        final Function<Integer, Function<Integer, Integer>> f2 = i -> i2 -> i + i2;
        System.out.println(f2.apply(1).apply(9));

        final List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(map(list, i -> "#" + i));
        System.out.println(
                list.stream()
                        .map(i -> "#" + i)
                        .toList()
        );

        Function<Integer, Function<Integer, Function<Integer, Integer>>> f3 = i1 -> i2 -> i3 -> i1 + i2 + i3;
//        final Function<Integer, Function<Integer, Integer>> applied1 = f3.apply(1);
//        final Function<Integer, Integer> applied2 = applied1.apply(2);
        System.out.println(f3.apply(1).apply(2).apply(3));

        Function<Integer, Function<Integer, Integer>> plus10 = f3.apply(10);
        System.out.println(plus10.apply(1).apply(1));
    }

    private static <T, R> List<R> map(List<T> list, Function<T, R> mapper) {
        final List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(mapper.apply(t));
        }
        return result;
    }
}
