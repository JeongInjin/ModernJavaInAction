package com.me.injin.modernjavainaction.example.me.methodreference;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class MethodReferenceExamples2 {
    public static void main(String[] args) {
        methodReference();
    }

    private static void methodReference() {
        /**
         * First Class Function
         * A Function can be passed as a parameter to another function.
         */
        // Using Lambda Expression
        System.out.println(testFirstClassFunction(3, i -> String.valueOf(i * 2)));

        // Using Method Reference
        System.out.println(testFirstClassFunction(3, MethodReferenceExamples2::doubleThenToString));

        System.out.println("===================================================================");
        /**
         * A Function can be returned as the result of another function.
         */
        // Using Lambda Expression
        Function<Integer, String> fl = getDoubleThenToStringUsingLambdaExpression();
        String resultFromFl = fl.apply(3);
        System.out.println(resultFromFl);
        // Using Method Reference
        final Function<Integer, String> fmr = getDoubleThenToStringUsingMethodReference();
        final String resultFromFmr = fmr.apply(3);
        System.out.println(resultFromFmr);
        System.out.println("===================================================================");
        /**
         * A Function can be stored in the data structure.
         */
        // Using Lambda Expression
        final List<Function<Integer, String>> fsL = Arrays.asList(i -> String.valueOf(i * 2));
        for (Function<Integer, String> f : fsL) {
            final String result = f.apply(3);
            System.out.println(result);
        }

        // Using Method Reference
        final List<Function<Integer, String>> fsMr = Arrays.asList(MethodReferenceExamples2::doubleThenToString);
        for (Function<Integer, String> f : fsMr) {
            final String result = f.apply(3);
            System.out.println(result);
        }
        System.out.println("===================================================================");

        // Using Lambda Expression
        final Function<Integer, String> fl2 = i -> String.valueOf(i * 2);
        final String resultFl2 = fl2.apply(3);
        System.out.println(resultFl2);

        // Using Method Reference
        final Function<Integer, String> fmr2 = MethodReferenceExamples2::doubleThenToString;
        String resultFm42 = fmr2.apply(3);
        System.out.println(resultFm42);

        System.out.println("===================================================================");
        // Both Lambda Expression and Method Reference
        List<Function<Integer, String>> fsBoth = Arrays.asList(i -> String.valueOf(i * 2), MethodReferenceExamples2::doubleThenToString);

        for (Function<Integer, String> f : fsBoth) {
            System.out.println(f.apply(4));
        }
    }

    private static Function<Integer, String> getDoubleThenToStringUsingMethodReference() {
        return MethodReferenceExamples2::doubleThenToString;
    }

    private static String doubleThenToString(int i) {
        return String.valueOf(i * 2);
    }

    private static String testFirstClassFunction(int n, Function<Integer, String> f) {
        return "The result is " + f.apply(n);
    }

    private static Function<Integer, String> getDoubleThenToStringUsingLambdaExpression() {
        return i -> String.valueOf(i * 2);
    }
}
