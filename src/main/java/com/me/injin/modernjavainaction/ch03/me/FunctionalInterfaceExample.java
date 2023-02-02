package com.me.injin.modernjavainaction.ch03.me;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        final List<Product> products = Arrays.asList(
                new Product(1L, "A", new BigDecimal("10.00")),
                new Product(2L, "B", new BigDecimal("20.00")),
                new Product(3L, "C", new BigDecimal("33.33")),
                new Product(4L, "D", new BigDecimal("8.00")),
                new Product(5L, "E", new BigDecimal("40.05"))
        );

        List<Product> result = new ArrayList<>();
        final BigDecimal twenty = new BigDecimal("20");
        for (final Product product : products) {
            if (product.getPrice().compareTo(twenty) >= 0) {
                result.add(product);
            }
        }
        System.out.println("result = " + result);
        System.out.println("=====================================");
        System.out.println(filter(products, p -> p.getPrice().compareTo(twenty) >= 0));
        System.out.println(filter(products, p -> p.getPrice().compareTo(new BigDecimal("10")) <= 0));
        System.out.println("=====================================");

    }

    private static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        final List<T> result = new ArrayList<>();
        for (T t : list) {
            if (predicate.test(t)) {
                result.add(t);
            }
        }
        return result;
    }
}

@AllArgsConstructor
@Data
class Product {
    private Long id;
    private String name;
    private BigDecimal price;
}
