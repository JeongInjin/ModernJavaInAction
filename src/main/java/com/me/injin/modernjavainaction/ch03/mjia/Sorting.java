package com.me.injin.modernjavainaction.ch03.mjia;

import com.me.injin.modernjavainaction.ch03.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.me.injin.modernjavainaction.ch03.Color.GREEN;
import static com.me.injin.modernjavainaction.ch03.Color.RED;


public class Sorting {
    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();
        inventory.addAll(Arrays.asList(
                new Apple(80, GREEN),
                new Apple(155, GREEN),
                new Apple(120, RED)
        ));
    }
}
