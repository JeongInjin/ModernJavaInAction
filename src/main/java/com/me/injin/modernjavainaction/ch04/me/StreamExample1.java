package com.me.injin.modernjavainaction.ch04.me;

import java.util.stream.IntStream;

public class StreamExample1 {
    public static void main(String[] args) {
        IntStream.range(0, 10).forEach(System.out::println);
        IntStream.rangeClosed(0, 10).forEach(System.out::println);
    }
}
