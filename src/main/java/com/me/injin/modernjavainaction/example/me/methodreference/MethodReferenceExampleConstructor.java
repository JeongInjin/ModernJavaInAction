package com.me.injin.modernjavainaction.example.me.methodreference;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.function.Function;

public class MethodReferenceExampleConstructor {
    public static void main(String[] args) {
        final Section section1 = new Section(1);
        final Function<Integer, Section> sectionFactory = number -> new Section(number);
        final Section section1WithFunction = sectionFactory.apply(1);
        System.out.println(section1);
        System.out.println(section1WithFunction);
//        final Product product = new Product(1L, "A", new BigDecimal("100"));

    }
}

@AllArgsConstructor
@Data
class Section {
    private int number;
}

@AllArgsConstructor
@Data
class Product {
    private Long id;
    private String name;
    private BigDecimal price;
}
