package com.jpadilla.java8.interfaces;

import com.jpadilla.java8.bean.Person;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Lambdas
 * @author ing_jefreypadilla@hotmail.com
 */
public class PersonaJava7Impl implements ITPersona {

    @Override
    public List<Person> sortList(List<Person> list) {
        list.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return list;
    }

    @Override
    public List<Person> getFilterByName(List<Person> list, String name) {
        List<Person> newListFilter = new LinkedList<>();
        for(Person p: list){
            if(name.equals(p.getName())){
                newListFilter.add(p);
            }
        }
        return newListFilter;
    }

    @Override
    public Person getPersonaById(List<Person> list, int id) {
        for(Person p : list){
            if(id == p.getId()){
                return p;
            }
        }
        return null;
    }

    @Override
    public void printList(List<Person> list) {
        for(Person p: list){
            System.out.println(p);
        }
    }

}
