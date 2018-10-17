package com.jpadilla.java8.interfaces.types;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Examples {

    private static Integer cant;

    public static void printValidatePredicate(List<Integer> list, Predicate<Integer> predicate){
        cant = 0;
        list.forEach(x -> {
            if (predicate.test(x)) {
                cant++;
            }});
        System.out.println("Cant: " + cant);
    }

}
