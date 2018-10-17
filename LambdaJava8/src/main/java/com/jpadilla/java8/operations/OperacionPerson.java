package com.jpadilla.java8.operations;

import com.jpadilla.java8.bean.Person;

@FunctionalInterface
public interface OperacionPerson {
    Person createPerson(String name, int age, int id);
}
