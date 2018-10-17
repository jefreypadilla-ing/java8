package com.jpadilla.java8.interfaces.types;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Examples {

    private static Integer cant;

    public static void printValidatePredicate(List<Integer> list, Predicate<Integer> predicate){
        cant = 0;
        list.forEach(x -> {
            if (predicate.test(x)) {
                cant++;
            }});
        System.out.println("Cant: " + cant);
    }

    public static void printMetodoReferencia(){
        List<Transaccion> transacciones = Arrays.asList(
                new Transaccion(new Proveedor("Cali"), 10),
                new Transaccion(new Proveedor("Cali"), 20),
                new Transaccion(new Proveedor("Barranquilla"), 10)
        );

        int sum = transacciones.stream().
                filter(t -> t.getProveedor().getCiudad().equals("Cali")).
                mapToInt(Transaccion::getPrecio).
                sum();

        System.out.println(sum);
    }

    static class Transaccion {

        private Proveedor proveedor;
        private int precio;

        public Transaccion(){}

        public Transaccion(Proveedor proveedor, int precio){
            this.proveedor = proveedor;
            this.precio = precio;
        }

        public Proveedor getProveedor() {
            return proveedor;
        }

        public void setProveedor(Proveedor proveedor) {
            this.proveedor = proveedor;
        }

        public int getPrecio() {
            return precio;
        }

        public void setPrecio(int precio) {
            this.precio = precio;
        }
    }

    static class Proveedor{
        private String ciudad;

        public Proveedor(){}

        public Proveedor(String ciudad){
            this.ciudad = ciudad;
        }

        public String getCiudad() {
            return ciudad;
        }

        public void setCiudad(String ciudad) {
            this.ciudad = ciudad;
        }
    }

}
