package com.jpadilla.java8;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author ing_jefreypadilla@hotmail.com
 * https://www.callicoder.com/java-8-completablefuture-tutorial/
 */
public class App 
{
    public static void main( String[] args )
    {
        App.testCompletableFuture();
        //System.out.println("Current thread execution");
    }



    public static void testCompletableFuture(){
        try {

            ExecutorService service = Executors.newFixedThreadPool(4);

                CompletableFuture<String> welcomeText = CompletableFuture.supplyAsync(() -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        throw new IllegalStateException(e);
                    }
                    return "I2Betianos";
                }, service).thenApply(name -> {
                    return "Hello " + name;
                }).thenApply(greeting -> {
                    return greeting + ", Welcome to the Java 8 topics";
                });

                System.out.println(welcomeText.get());

        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
