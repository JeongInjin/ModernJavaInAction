package com.me.injin.modernjavainaction.example.me.stream;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class StreamExample4 {
    public static void main(String[] args) {
        final List<Product> products =
                Arrays.asList(
                        new Product(1L, "A", new BigDecimal("100.50")),
                        new Product(2L, "B", new BigDecimal("23.00")),
                        new Product(3L, "C", new BigDecimal("31.45")),
                        new Product(4L, "D", new BigDecimal("80.20")),
                        new Product(5L, "E", new BigDecimal("7.50"))
                );

        BigDecimal bigDecimal30 = new BigDecimal("30");
        BigDecimal bigDecimal01 = new BigDecimal(0.1);
        BigDecimal bigDecimal02 = new BigDecimal("0.1");
        System.out.println(bigDecimal02.equals("0.1"));

        System.out.println(
                products.stream()
                        .filter(p -> p.getPrice().compareTo(bigDecimal30) >= 0)
                        .collect(toList())
        );

        System.out.println("=====================\n" +
                products.stream()
                        .filter(p -> p.getPrice().compareTo(bigDecimal30) >= 0)
                        .map(p -> p.toString())
                        .collect(joining("\n"))
        );

        System.out.println("=====================\n" +
                IntStream.of(1, 2, 3, 4, 5).sum()
        );

        System.out.println("=====================\n" +
                products.stream()
                        .map(p -> p.getPrice())
                        .reduce(BigDecimal.ZERO, (p1, p2) -> p1.add(p2))
        );

        System.out.println("=====================\n" +
                products.stream()
                        .filter(p -> p.getPrice().compareTo(bigDecimal30) >= 0)
                        .map(p -> p.getPrice())
                        .reduce(BigDecimal.ZERO, (p1, p2) -> p1.add(p2))
        );

        System.out.println("=====================\n" +
                products.stream()
                        .filter(p -> p.getPrice().compareTo(bigDecimal30) >= 0)
                        .count()
        );

        System.out.println("==================================================================");

        final OrderedItem item1 = new OrderedItem(1L, products.get(0), 1);
        final OrderedItem item2 = new OrderedItem(2L, products.get(2), 3);
        final OrderedItem item3 = new OrderedItem(3L, products.get(4), 10);

        final Order order = new Order(1L, Arrays.asList(item1, item2, item3));
        System.out.println("order.totalPrice() = " + order.totalPrice());
    }
}

@AllArgsConstructor
@Data
class Product {
    private Long id;
    private String name;
    private BigDecimal price;
}

@AllArgsConstructor
@Data
class OrderedItem {
    private Long id;
    private Product product;
    private int quantity;

    public BigDecimal getItemTotal() {
        return product.getPrice().multiply(new BigDecimal(quantity));
    }
}

@AllArgsConstructor
@Data
class Order {
    private Long id;
    private List<OrderedItem> items;

    public BigDecimal totalPrice() {
        return items.stream()
                .map(item -> item.getItemTotal())
                .reduce(BigDecimal.ZERO, (p1, p2) -> p1.add(p2));
    }

}

