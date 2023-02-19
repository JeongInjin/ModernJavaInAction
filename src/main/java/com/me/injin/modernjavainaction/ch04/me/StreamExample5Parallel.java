package com.me.injin.modernjavainaction.ch04.me;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class StreamExample5Parallel {
    public static void main(String[] args) {

//        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "8");
//        ForkJoinPool pool = ForkJoinPool.commonPool();
//        System.out.println(pool.getParallelism());
//        System.out.println(pool.getPoolSize());
//        System.out.println(pool.getQueuedSubmissionCount());
//        System.out.println(pool.getQueuedTaskCount());
//        System.out.println(pool.getStealCount());


        final int[] sum1 = {0};
        IntStream.range(0, 100)
                .forEach(i -> sum1[0] += i);
        System.out.println("sum1[0] = " + sum1[0]);

        final int[] sum2 = {0};
        IntStream.range(0, 100)
                .parallel()
                .forEach(i -> sum2[0] += i);
        System.out.println("sum2[0] (with side-effect) = " + sum2[0]);

        System.out.println("no side-effect: " +
                IntStream.range(0, 100).sum()
        );

        System.out.println("no side-effect: " +
                IntStream.range(0, 100).parallel().sum()
        );

//        System.out.println("========================================");
//        System.out.println("Stream");
//
//        final long start = System.currentTimeMillis();
//        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8)
//                .stream()
//                .map(i -> {
//                    try {
//                        TimeUnit.SECONDS.sleep(1);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    return i;
//                })
//                .forEach(i -> System.out.println(i));
//        System.out.println(System.currentTimeMillis() - start);

        System.out.println("========================================");
        System.out.println("Parallel Stream (8 elements)");
        final long start2 = System.currentTimeMillis();
        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8)
                .parallelStream()
                .map(i -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return i;
                })
                .forEach(i -> System.out.println(i));
        System.out.println(System.currentTimeMillis() - start2);

        System.out.println("========================================");
        System.out.println("Parallel Stream (9 elements)");
        final long start3 = System.currentTimeMillis();
        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .parallelStream()
                .map(i -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return i;
                })
                .forEach(i -> System.out.println(i));
        System.out.println(System.currentTimeMillis() - start3);

        System.out.println("========================================");
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "3");
        System.out.println("getParallelism=" + ForkJoinPool.commonPool().getParallelism());

//        ForkJoinPool customThreadPool = new ForkJoinPool(20);
//        System.out.println("customThreadPool=" + customThreadPool.getParallelism());


        System.out.println("Parallel Stream (8 elements with parallelism 3)");
        final long start4 = System.currentTimeMillis();
        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8)
                .parallelStream()
                .map(i -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return i;
                })
                .forEach(i -> System.out.println(i));
        System.out.println(System.currentTimeMillis() - start4);
    }
}
