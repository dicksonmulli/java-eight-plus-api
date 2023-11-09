package com.study.javaeightplusapi.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Filter {
    public static void main(String[] args) {
        List<Product> productList = Arrays.asList(
                new Product(23, "potatoes", 5, 2.2),
                new Product(14, "orange", 10, 2.0),
                new Product(13, "lemon", 5, 1.0),
                new Product(23, "bread", 2, 3.0),
                new Product(13, "sugar", 3, 4.0),
                new Product(13, "Papaya", 20, 3.1),
                new Product(13, "Pineaple", 11, 3.3)
        );

        filterWithStartsWith(productList);
        filterWithGreaterThan(productList);
        filterProductWithGreaterThan(productList);
    }

    private static void filterWithStartsWith(List<Product> productList) {
        List<String> listThatStartsWithLowerCaseP = productList.stream()
                .map(Product::getName)
                .filter(name -> name.startsWith("p"))
                .toList(); // upper and lower case matters

        List<String> listThatStartsWithUpperCaseP = productList.stream()
                .map(Product::getName)
                .filter(name -> name.startsWith("P"))
                .toList();

        System.out.println("listThatStartsWithLowerCaseP: " + listThatStartsWithLowerCaseP);
        System.out.println("listThatStartsWithUpperCaseP: " + listThatStartsWithUpperCaseP);
    }

    private static void filterWithGreaterThan(List<Product> productList) {
        List<Integer> filterList = productList.stream()
                .map(Product::getPrice)
                .filter(price -> price > 5)
                .toList();

        System.out.println("filterPriceWithGreaterThan: " + filterList);
    }

    private static void filterProductWithGreaterThan(List<Product> productList) {
        List<Product> filterList = productList.stream()
                .filter(product -> product.getPrice() > 5)
                .toList();
        System.out.println("filterPriceWithGreaterThan: " + filterList);
    }


    // To be deleted
    private static void sum(List<Product> productList) {
        productList.stream().collect(Collectors.summingInt(Product::getPrice));
        productList.stream().mapToInt(product -> product.getPrice()).sum();
    }

}
