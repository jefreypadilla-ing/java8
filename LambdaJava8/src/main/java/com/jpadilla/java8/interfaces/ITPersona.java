package com.jpadilla.java8.interfaces;

import com.jpadilla.java8.bean.Person;

import java.util.List;

public interface ITPersona {
    List<Person> sortList(List<Person> list);
    List<Person> getFilterByName(List<Person> list, String name);
    Person getPersonaById(List<Person> list, int id);
    void printList(List<Person> list);
}
