package com.jpadilla.java8.operations;

@FunctionalInterface
public interface Operacion {
    void method();
    default public void defaultMethod(){
        System.out.println("This is a default method from Operacion");
    }
}
