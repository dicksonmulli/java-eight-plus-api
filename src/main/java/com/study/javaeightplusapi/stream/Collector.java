package com.study.javaeightplusapi.stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The collect() method
 */
public class Collector {
    public static void main(String[] args) {
        List<Product> productList = Arrays.asList(
                new Product(23, "potatoes", 5, 2.2),
                new Product(14, "orange", 10, 2.0),
                new Product(13, "lemon", 5, 1.0),
                new Product(23, "bread", 2, 3.0),
                new Product(13, "sugar", 3, 4.0)
        );

        collectToList(productList);
        collectToString(productList);
        collectWithAverage(productList);
        collectWithSum(productList);
        collectWithStatistics(productList);
    }

    private static void collectToList(List<Product> productList) {
//        List<String> collectorCollection = productList.stream().map(Product::getName).collect(Collectors.toList());// Same as below
        List<String> collectorCollection = productList
                .stream()
                .map(Product::getName)
                .toList();
        System.out.println("CollectorCollection: " + collectorCollection);
    }

    /**
     *
     * @param productList
     */
    private static void collectToString(List<Product> productList) {
        String listToString = productList.stream()
                .map(Product::getName)
                .collect(Collectors.joining(", ", "(", ")")); // join with;- delimiter, prefix and suffix

        System.out.println("listToString: " + listToString);
    }

    /**
     * Processing the average value of all numeric elements of the stream
     */
    private static void collectWithAverage(List<Product> productList) {
        double averagePrice = productList.stream()
                .collect(Collectors.averagingDouble(Product::getPrice));

        System.out.println("averagePrice: " + averagePrice);
    }

    /**
     * Processing the average value of all numeric elements of the stream
     */
    private static void collectWithSum(List<Product> productList) {
//        int summingPrice = productList.stream().mapToInt(Product::getPrice).sum(); // same as below
        int summingPrice = productList.stream()
                .collect(Collectors.summingInt(Product::getPrice));

        System.out.println("averagePrice: " + summingPrice);
    }

    /**
     *
     */
    private static void collectWithStatistics(List<Product> productList) {
        IntSummaryStatistics statistics = productList.stream()
                .collect(Collectors.summarizingInt(Product::getPrice));

        System.out.println("statistics: " + statistics);
    }
}
