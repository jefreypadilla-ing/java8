package com.jpadilla.java8;

import com.jpadilla.java8.bean.Person;
import com.jpadilla.java8.functional.MethodFuntional;
import com.jpadilla.java8.interfaces.ITPersona;
import com.jpadilla.java8.interfaces.PersonaJava7Impl;
import com.jpadilla.java8.interfaces.PersonaJava8Impl;
import com.jpadilla.java8.interfaces.types.Examples;
import com.jpadilla.java8.operations.Operacion;
import com.jpadilla.java8.operations.OperacionPerson;

import java.util.Arrays;
import java.util.List;

/**
 * Lambdas
 * @author ing_jefreypadilla@hotmail.com
 */
public class App 
{

    public static void main( String[] args )
    {
        //App.executeListas();
        //App.executeFunctionalInterface();
        App.executeExampleFuntional();
    }

    public static void executeExampleFuntional(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);

        Examples.printValidatePredicate(list, (x) -> x > 5);
    }

    public static void executeFunctionalInterface(){
        Operacion operacion = MethodFuntional::methodStaticClass;
        operacion.method();

        MethodFuntional methodFuntional = new MethodFuntional();
        Operacion operacion1 = methodFuntional::methodClass;
        operacion1.method();
        operacion1.defaultMethod();

        System.out.println(methodFuntional.methodStaticClassVar(2, 2));

        String[] nombres = {"D", "Z", "A"};
        Operacion operacion2 = () -> MethodFuntional.sortListString(nombres);
        operacion2.method();

        OperacionPerson itPersona = Person::new;
        Person person = itPersona.createPerson("Persona", 10, 10);
        System.out.println(person);

        /*OperacionPerson itPersona2 = (name, age, id) -> {return new Person(name, age, id);};
        Person person2 = itPersona2.createPerson("Persona", 10, 10);
        System.out.println(person2);*/

    }

    public static void executeListas(){
        App app = new App();
        List<Person> list = app.getListPerson();
        System.out.println(" ::: List data ::: ");
        list.forEach(System.out::println);
        System.out.println("\n");

        // Java 7
        System.out.println(" ::: Java 7 ::: ");
        List<Person> listJava7 = list;
        ITPersona java7 = new PersonaJava7Impl();
        System.out.println(" ** Lista Ordenada Java 7 ** ");
        java7.printList(java7.sortList(listJava7));
        System.out.println("Person By Id: " + java7.getPersonaById(listJava7, 1));
        System.out.println("Person By Name: ");
        java7.printList(java7.getFilterByName(listJava7, "Java"));

        System.out.println("\n");

        // Java 8
        System.out.println(" ::: Java 8 ::: ");
        List<Person> listJava8 = list;
        ITPersona java8 = new PersonaJava8Impl();
        System.out.println(" ** Lista Ordenada Java 8 ** ");
        java8.printList(java8.sortList(listJava8));
        System.out.println("Person By Id: " + java8.getPersonaById(listJava8, 1));
        System.out.println("Person By Name: ");
        java7.printList(java8.getFilterByName(listJava8, "Java"));
    }

    private List<Person> getListPerson(){
        return Arrays.asList(
                new Person("Java", 10, 1),
                new Person("Java", 12, 4),
                new Person("Python", 11, 2),
                new Person("Ruby", 5, 3));
    }

}
