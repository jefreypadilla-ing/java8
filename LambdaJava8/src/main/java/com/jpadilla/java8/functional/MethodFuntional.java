package com.jpadilla.java8.functional;

import com.jpadilla.java8.operations.OperacionMat;

import java.util.Arrays;
import java.util.List;

public class MethodFuntional {

    private static int var;

    public static void methodStaticClass(){
        System.out.println("Reference method static class");
    }

    public void methodClass(){
        System.out.println("Reference method class");
    }

    public double methodStaticClassVar(double a, double b){
        OperacionMat operacionMat = (x, y) -> {
            var = 1;
            return (a + b) / var;
        };
        return operacionMat.method(a, b);
    }

    public static void sortListString(String[] nombres){
        Arrays.sort(nombres, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(nombres));
    }

}
