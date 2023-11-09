package com.study.javaeightplusapi.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Sort {
    public static void main(String[] args) {
        List<Product> productList = Arrays.asList(
                new Product(23, "potatoes", 5, 2.2),
                new Product(23, "potatoes", 15, 2.2),
                new Product(14, "orange", 10, 2.0),
                new Product(13, "lemon", 5, 1.0),
                new Product(23, "bread", 2, 3.0),
                new Product(13, "sugar", 3, 4.0)
        );

        basicSort(productList);
        sortIntegers(productList);
        sortWithMultipleConditions(productList);
        sortUsingSortedToReturnList(productList);
        sortInReverseOrder();
        sortWithNullValues();
    }

    private static void basicSort(List<Product> productList) {
//        productList.sort((productA, productB) -> productA.getName().compareTo(productB.getName()));// Same as below
        productList.sort(Comparator.comparing(Product::getName));
        System.out.println(" sortedList: " + productList.stream().map(Product::getName).toList());
    }

    private static void sortIntegers(List<Product> productList) {
        List<Integer> sortedPrices = productList.stream().map(Product::getPrice).sorted().toList();
        System.out.println(" sortedPrices: " + sortedPrices);
    }

    private static void sortWithMultipleConditions(List<Product> productList) {
        productList.sort(Comparator.comparing(Product::getName).thenComparing(Product::getPrice)); // potatoes with higher lower price comes first
        System.out.println(" sortedNameWithMultipleConditions: " + productList.stream().map(Product::getName).toList());
        System.out.println(" sortedPriceWithMultipleConditions: " + productList.stream().map(Product::getPrice).toList());
    }

    private static void sortUsingSortedToReturnList(List<Product> productList) {
        List<Product> sortedProducts = productList.stream()
                .sorted(Comparator.comparing(Product::getName).thenComparing(Product::getPrice))
                .toList();

        System.out.println("Sorted products: " + sortedProducts.stream().map(Product::getName).toList());
    }

    private static void sortInReverseOrder() {
        List<String> letters = Arrays.asList("B", "A", "C");

        List<String> reverseSortedLetters = letters.stream()
                .sorted(Comparator.reverseOrder())
                .toList();

        System.out.println("reverseSortedLetters: " + reverseSortedLetters);
    }

    private static void sortWithNullValues() {
        List<Product> products = Arrays.asList(null, new Product(2, "SomeProduct", 12, 2.2), null);

        products.sort((h1, h2) -> {
            if (h1 == null) {
                return h2 == null ? 0 : 1;
            }
            else if (h2 == null) {
                return -1;
            }
            return h1.getName().compareTo(h2.getName());
        });

        System.out.println("sortedProductsWithNullValues: " + products.get(0).getName());
    }
}
