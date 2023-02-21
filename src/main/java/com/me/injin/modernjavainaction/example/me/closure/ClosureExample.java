package com.me.injin.modernjavainaction.example.me.closure;

public class ClosureExample {
    private final int number = 888;

    public static void main(String[] args) {
        test();
    }

    private static void test() {
        int number = 100;
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(number);
            }
        };
        runnable.run();

        Runnable runnable1 = () -> System.out.println(number);
        runnable1.run();
    }
}
