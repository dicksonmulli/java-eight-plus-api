package com.study.javaeightplusapi.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Stream.max() returns the maximum element of the stream based on the provided Comparator.
 * A Comparator is a comparison function, which imposes a total ordering on some collection of objects.
 * max() is a terminal operation which combines stream elements and returns a summary result.
 * So, max() is a special case of reduction.
 */
public class MaxAndMin {
    public static void main(String[] args) {
        List<Product> productList = Arrays.asList(
                new Product(23, "potatoes", 5, 2.2),
                new Product(14, "orange", 10, 2.0),
                new Product(13, "lemon", 5, 1.0),
                new Product(23, "bread", 2, 3.0),
                new Product(13, "sugar", 3, 4.0)
        );

        maxIntWithCompareTo(productList);
        maxIntWithCompare(productList);
        maxDoubleWithCompare(productList);
        maxIntUsingNaturalOrderComparator(productList);
        minDoubleWithCompare(productList);
        minIntUsingReverseOrder(productList);
        maxIntUsingComparatorOnInt(productList);
    }

    public static void maxIntWithCompareTo(List<Product> productList) {
//        Integer maxInt = productList.stream()
//                .map(Product::getQuantity)
//                .max((quantityA, quantityB) -> quantityA.compareTo(quantityB)) // Same as below
//                .orElse(0);

        int maxInt = productList.stream()
                .map(Product::getQuantity)
                .max(Integer::compareTo) // compareTo;- compares 2 Integer objects
                .orElse(0);

        System.out.println("maxInt: " + maxInt);
    }

    public static void maxIntWithCompare(List<Product> productList) {
//        Integer maxInt = productList.stream()
//                .map(Product::getQuantity)
//                .max((quantityA, quantityB) -> Integer.compare(quantityA, quantityB)) // Same as below
//                .orElse(0);

        int maxIntSol2 = productList.stream()
                .map(Product::getQuantity)
                .max(Integer::compare) // compare;- Compares two int values
                .orElse(0);

        System.out.println("maxIntSol2: " + maxIntSol2);
    }

    public static void maxDoubleWithCompare(List<Product> productList) {
//        double maxDouble = productList.stream()
//                .map(Product::getQualityStandard)
//                .max((quantityA, quantityB) -> Double.compare(quantityA, quantityB)) // Same as below
//                .orElse(0.0);

        double maxDouble = productList.stream()
                .map(Product::getQualityStandard)
                .max(Double::compare) // compare;- Compares two int values
                .orElse(0.0);

        System.out.println("maxDouble: " + maxDouble);
    }

    public static void productWithMaxQualityStandard(List<Product> productList) {
//        Product productWithMaxQuality = productList.stream()
//                .max((productA, productB) -> Double.compare(productA.getQualityStandard(), productB.getQualityStandard())) // Same as below
//                .orElse(null);

        Product productWithMaxQuality = productList.stream()
                .max(Comparator.comparingDouble(Product::getQualityStandard))
                .orElse(null);

        System.out.println("productWithMaxQualityStandard: " + productWithMaxQuality);
    }

    public static void maxIntUsingNaturalOrderComparator(List<Product> productList) {
        int maxIntWithComparator = productList.stream()
                .map(Product::getPrice)
                .max(Comparator.naturalOrder())
                .orElse(0);

        System.out.println("minPriceUsingNaturalOrder: " + maxIntWithComparator);
    }

    public static void maxIntUsingComparatorOnInt(List<Product> productList) {
        int maxIntWithComparator = productList.stream()
                .map(Product::getPrice)
                .max(Comparator.comparing(Integer::intValue))
                .orElse(0);

        System.out.println("minPriceUsingComparatorOnIntValue: " + maxIntWithComparator);
    }

    public static void minDoubleWithCompare(List<Product> productList) {
//        double maxDouble = productList.stream()
//                .map(Product::getQualityStandard)
//                .min((quantityA, quantityB) -> Double.compare(quantityA, quantityB)) // Same as below
//                .orElse(0.0);

        double minDouble = productList.stream()
                .map(Product::getQualityStandard)
                .min(Double::compare) // compare;- Compares two int values
                .orElse(0.0);

        System.out.println("minDouble: " + minDouble);
    }

    public static void minIntUsingReverseOrder(List<Product> productList) {
        int minIntWithReverse = productList.stream()
                .map(Product::getPrice)
                .max(Comparator.reverseOrder()) // Same as min
                .orElse(0);

        System.out.println("minPriceUsingReverseOrder: " + minIntWithReverse);
    }
}
