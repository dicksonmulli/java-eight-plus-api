package com.study.javaeightplusapi.stream;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Reduce {
    /**
     * There are 3 types of reduce method, which differ by their signatures and returning types:
     * 1. identity - the initial value for an accumulator, or a default value if a stream is empty and there is
     * nothing to accumulate
     * 2. accumulator - a function which specifies the logic of the aggregation of elements.
     * As the accumulator creates a new value for every step of reducing, the quantity of new values
     * equals the stream’s size and only the last value is useful. This is not very good for the performance.
     * 3. combiner - a function which aggregates the results of the accumulator. We only call combiner in a parallel
     * mode to reduce the results of accumulators from different threads.
     */
    public static void main(String[] args) {
        reduceElements();
        reduceTwoParams();
        combiner();
    }

    /**
     * Accumulator
     */
    private static void reduceElements() {
//        OptionalInt reduced = IntStream.range(1, 4).reduce((a, b) -> a + b); // same as below
        OptionalInt reduced = IntStream.range(1, 4).reduce(Integer::sum);
        System.out.println("reduced " + reduced.getAsInt());
    }

    /**
     * Accumulator
     */
    private static void reduceTwoParams() {
        int reducedTwoParams = IntStream.range(1, 4).reduce(10, Integer::sum);
        System.out.println("reducedTwoParams " + reducedTwoParams);
    }

    /**
     * combiner
     */
    private static void combiner() {
        int reducedParams = Stream.of(1, 2, 3).reduce(10, (a, b) -> a + b, (a, b) -> {
                    log.info("combiner was called"); // No log is made here
                    return a + b;
                });

        // Here the reduction works by the following algorithm: the accumulator ran three times by adding every element of the stream to identity.
        // These actions are being done in parallel. As a result, they have (10 + 1 = 11; 10 + 2 = 12; 10 + 3 = 13;).
        // Now combiner can merge these three results. It needs two iterations for that (12 + 13 = 25; 25 + 11 = 36).
        int reducedParallel = Arrays.asList(1, 2, 3).parallelStream()
                .reduce(10, (a, b) -> a + b, (a, b) -> {
                    log.info("combiner was called on parallel");
                    return a + b;
                });

        System.out.println("reducedParams " + reducedParams);
        System.out.println("reducedParallel " + reducedParallel);
    }
}
