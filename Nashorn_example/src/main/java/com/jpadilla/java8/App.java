package com.jpadilla.java8;

/**
 * @author ing_jefreypadilla@hotmail.com
 * https://www.adictosaltrabajo.com/2015/09/21/introduccion-a-nashorn-el-motor-de-javascript-de-java-8/
 * https://www.baeldung.com/java-nashorn
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            NashornExample nashornExample = new NashornExample();
            nashornExample.example01();
            nashornExample.example02();
            nashornExample.example03();
            nashornExample.example04();
            nashornExample.example05();
            nashornExample.example06();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
