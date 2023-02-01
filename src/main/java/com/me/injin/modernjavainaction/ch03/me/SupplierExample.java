package com.me.injin.modernjavainaction.ch03.me;

import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {
        printValid(0, getVeryExpensiveValue());
        printValid(-1, getVeryExpensiveValue());
        printValid(-2, getVeryExpensiveValue());
        System.out.println("================");
        printIfValidIndex(0, () -> getVeryExpensiveValue());
        printIfValidIndex(-1, () -> getVeryExpensiveValue());
        printIfValidIndex(-2, () -> getVeryExpensiveValue());
    }

    private static String getVeryExpensiveValue() {
        try {
            Thread.sleep(3_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Jeong";
    }

    private static void printIfValidIndex(int number, Supplier<String> valueSupplier) {
        if (number >= 0) {
            System.out.println(valueSupplier.get());
        } else {
            System.out.println("Invalid");
        }
    }

    private static void printValid(int number, String value) {
        if (number >= 0) {
            System.out.println("The value is " + value + ".");
        } else {
            System.out.println("Invalid");
        }
    }

}
