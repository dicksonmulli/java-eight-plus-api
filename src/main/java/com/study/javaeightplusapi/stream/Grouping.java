package com.study.javaeightplusapi.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Grouping {
    public static void main(String[] args) {
        List<Product> productList = Arrays.asList(
                new Product(23, "potatoes", 5, 2.2),
                new Product(23, "potatoes", 15, 2.2),
                new Product(10, "orange", 10, 2.0),
                new Product(13, "lemon", 5, 1.0),
                new Product(23, "bread", 2, 2.0),
                new Product(15, "sugar", 3, 4.0)
        );

        groupByQualityAndCountQuantity(productList);
    }

    private static void groupByQualityAndCountQuantity(List<Product> productList) {
        Map<Double, Integer> productCount = productList.stream()
                .collect(
                        Collectors.groupingBy(
                                Product::getQualityStandard,
                                Collectors.summingInt(Product::getQuantity)
                        )
                );

        productCount.forEach((quality, quantity) -> System.out.println("*** quality = " + quality + " quantity = " + quantity));
    }
}
