var frutas = ["Manzana", "Pera", "Platano"];

var frutasJavaArray = Java.to(frutas);

var frutasJava = new java.util.ArrayList();
frutasJava.addAll(java.util.Arrays.asList(frutasJavaArray));

print(frutasJava);

var frutasP = frutasJava.stream().filter(function(fruta){
    return fruta.startsWith("P");
}).collect(java.util.stream.Collectors.toList());

print("Frutas con P")
print(frutasP);