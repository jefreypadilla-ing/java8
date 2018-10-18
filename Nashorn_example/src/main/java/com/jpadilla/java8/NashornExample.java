package com.jpadilla.java8;

import jdk.nashorn.api.scripting.ScriptObjectMirror;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.FileReader;

/**
 * @author ing_jefreypadilla@hotmail.com
 * https://www.adictosaltrabajo.com/2015/09/21/introduccion-a-nashorn-el-motor-de-javascript-de-java-8/
 * https://www.baeldung.com/java-nashorn
 */
public class NashornExample {

    private static final String NASHORN_ENGINE_NAME = "nashorn";

    private final ScriptEngine engine;

    private Invocable invoker;

    public NashornExample() {
        final ScriptEngineManager manager = new ScriptEngineManager();
        engine = manager.getEngineByName(NASHORN_ENGINE_NAME);
        invoker = (Invocable) engine;
    }

    public void example01() throws Exception {
        engine.eval("print('Hola mundo')");
    }

    public void example02() throws Exception {
        engine.eval(new FileReader("src/main/resources/example02.js"));
    }

    public void example03() throws Exception {
        engine.eval(new FileReader("src/main/resources/example03.js"));
        // la siguiente linea invoca la función "greeter" con parámetro "I2B"
        final String greetingMessage = (String)invoker.invokeFunction("greeter", "I2B");
        System.out.println(greetingMessage);
    }

    public void example04() throws Exception {
        engine.eval(new FileReader("src/main/resources/example04.js"));
        final Object vehiculos = engine.get("vehiculos");
        final String[] vehiculosSeleccionados = ((ScriptObjectMirror)invoker.invokeMethod(vehiculos, "slice", 0, 2))
                .to(String[].class);

        System.out.println("Vehiculos seleccionados: ");
        for (final String vehiculo : vehiculosSeleccionados) {
            System.out.println("* " + vehiculo);
        }
    }

    public void example05() throws Exception {
        engine.eval(new FileReader("src/main/resources/Finance.js"));
        engine.eval("var finance = new Finance();");
        final Object finance = engine.get("finance");

        // calcula la cuota mensual de un prestamo de 100.000 euro; al 5.5% anual durante 30 anos
        // (360 meses, ya que el ultimo parametro indica que este valor esta expresado en meses)
        final double cuotaMensual = (Double)invoker.invokeMethod(finance, "AM", 100000, 5.5, 360, 1);

        System.out.println("La cuota mensual es: " + cuotaMensual);

        /* Example use in Javascript
            var Finance = require('financejs');
            var finance = new Finance();
            // To calculate Amortization
            finance.AM(20000, 7.5, 5, 0);
            // => 400.76
         */

    }

    public void example06() throws Exception {
        engine.eval(new FileReader("src/main/resources/example06.js"));
        final Object runnerjs = engine.get("runnerImpl");
        final Runnable runner = invoker.getInterface(runnerjs, Runnable.class);

        final Thread thread = new Thread(runner);

        thread.start();
        thread.join();
    }

    /*
    Comando para prueba example07, example08(Lambdas, Streams) -> Ejecutar clases de java en Javascript
    $ jjs example07.js
    $ jjs example08.js
     */

}
