package com.jpadilla.java8.interfaces;

import com.jpadilla.java8.bean.Person;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Lambdas
 * @author ing_jefreypadilla@hotmail.com
 */
public class PersonaJava8Impl implements ITPersona {

    @Override
    public List<Person> sortList(List<Person> list) {
        list.sort(((o1, o2) -> o1.getName().compareTo(o2.getName())));
        return list;
    }

    @Override
    public List<Person> getFilterByName(List<Person> list, String name) {
        return list.stream()
                .filter(x -> name.equals(x.getName()))
                .map(x -> new Person(x.getName(), x.getAge(), x.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public Person getPersonaById(List<Person> list, int id) {
        Optional<Person> result = list.stream()
                .filter(x -> x.getId() == id)
                .findFirst();
        if (!result.isPresent()) System.out.println("Not Present");
        return result.orElse(new Person());
    }

    @Override
    public void printList(List<Person> list) {
        list.forEach(System.out::println);
    }

}
