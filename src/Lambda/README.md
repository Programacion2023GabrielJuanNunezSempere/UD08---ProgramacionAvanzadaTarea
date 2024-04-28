# 1. Las librerías de Java poseen muchas interfaces como List, que define una serie de métodos. Podemos usar las expresiones lambda en vez de instancias las interfaces e implementarlas como clases anónimas si queremos usarlas. Dada una interfaz específica, 
# ¿Cómo podemos saber si podemos usar una expresión lambda para mapearla?
#### Respuesta: Podemos usar una expresión lambda para mapear una interfaz si esta tiene un solo método abstracto, es decir, si es una interfaz funcional.
# ¿Podríamos usar expresiones lambda para mapear métodos de la interfaz List? Consulta la API
#### Respuesta: No, no podemos usar expresiones lambda para mapear métodos de la interfaz List, ya que esta interfaz tiene más de un método abstracto.

# 2. A partir de tu respuesta anterior, ¿podríamos entonces usar una expresión lambda para representar una instancia de la interfaz java.util.concurrent.Callable? Razona tu respuesta.
#### Respuesta: Sí, podemos usar una expresión lambda para representar una instancia de la interfaz java.util.concurrent.Callable, ya que esta interfaz tiene un solo método abstracto, por lo que es una interfaz funcional.

# 3. Se podría crear una expresión lambda de la interfaz java.util.Comparator? Razona tu respuesta
#### Respuesta: Sí, se puede crear una expresión lambda de la interfaz java.util.Comparator, ya que esta interfaz tiene un solo método abstracto, por lo que es una interfaz funcional.

# 4. Transforma la siguiente clase anónima en una expresión lambda y crea código de prueba para usarla.
```java
Runnable runnable = new Runnable() {
        @Override
        public void run() {
            String texto = "Vamos a crear un array";
            String[] partes = texto.split(" ");
            for (String parte: partes) {
                System.out.println(part);
            }
        }
};
```
#### Respuesta:
```java
Runnable runnable = () -> {
    String texto = "Vamos a crear un array";
    String[] partes = texto.split(" ");
    for (String parte: partes) {
        System.out.println(part);
    }
};
```

# 5. Transforma en expresión lambda las siguientes clases anónimas
```java
OperacionUnitariaEntera operacion = new OperacionUnitariaEntera() {
        @Override
        public int operar(int x) {
            return x + x;
        }
};
```
#### Respuesta:
```java
OperacionUnitariaEntera operacion = x -> x + x;
```
### --
```java
OperaciónBinariaDecimal operacion = new OperaciónBinariaDecimal(){
        @Override
        public double operar(double valor) {
            return valor*valor;
        }
 };
```
#### Respuesta:
```java
OperaciónBinariaDecimal operacion = valor -> valor*valor;
```
### --
```java
OperacionBinariaEntera operacion = new OperacionBinariaEntera() {
        @Override
        public int operar(int x, int y){
            return x * y;
        }
};
```
#### Respuesta:
```java
OperacionBinariaEntera operacion = (x, y) -> x * y;
```
### --
```java
Saludable sal = new Saludable() {
        @Override
        public void saludar() {
            System.out.println("hola mundo");
        }
 };
```
#### Respuesta:
```java
Saludable sal = () -> System.out.println("hola mundo");
```
# 6. Completa el método abstracto el cual determina a la expresión lambda:

```java
@FunctionalInterface
public interface Predicate{
    boolean test(Integer valor);
}
```
```java
@FunctionalInterface
public interface UnaryOperator{
    Integer apply(Integer valor);
}
```
```java
@FunctionalInterface
public interface Consumer{
    void accept(Integer valor);
}
```
```java
@FunctionalInterface
public interface BinaryOperator{
    Integer apply(Integer valor1, Integer valor2);
}
```
```java
@FunctionalInterface
public interface Predicate{
    boolean test(Integer valor);
}
```
# 7. Transforma el siguiente método en una expresión lambda:
```java
public static String caracteresPares(String texto) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < texto.length(); i++) {
        if (i % 2 == 0) {
            sb.append(texto.charAt(i));
        }
    }
    return sb.toString();
}
```
#### Respuesta:
```java
@FunctionalInterface
public interface StringFunction {
    String apply(String texto);
}

StringFunction caracteresPares = (texto) -> {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < texto.length(); i++) {
        if (i % 2 == 0) {
            sb.append(texto.charAt(i));
        }
    }
    return sb.toString();
};
```

# 8. Escribe código para ejecutar la función del ejercicio anterior si se le pasa el siguiente texto:”1234567890”
```java
    String texto = "1234567890";
    System.out.println(caracteresPares.apply(texto));
```
# 9. En relación con el ejercicio anterior, ahora, en vez de ejecutar la función directamente, imagina que quieres pasársela a un método. Escribe un método llamado “paresEjecuta” que acepte la función lambda como parámetro y la ejecute con el texto “1234567890”. Debe devolver el resultado de la función lambda. Llama al método que has creado en el main e imprime el resultado.
```java
public static String paresEjecuta(StringFunction sf) {
    String texto = "1234567890";
    return sf.apply(texto);
}

public static void main(String[] args) {
    System.out.println(paresEjecuta(caracteresPares));
}
```

# 10. Dada la siguiente lista de ciudades: 
```java
List<String> ciudades = Arrays.asList(
"elche",
"alicante",
"elda",
"petrer",
"aspe",
"crevillente",
"alcoy",
"ibi",
"benidorm",
"matola"
);
```

## Escribe código para imprimir los elementos de la lista ordenados y con la primera letra en mayúsculas. Utiliza expresiones lambda para realizarlo. Recuerda Comparator y foreach
```java
ciudades.sort((a, b) -> a.compareTo(b));
ciudades.forEach(ciudad -> System.out.println(ciudad.substring(0, 1).toUpperCase() + ciudad.substring(1)));
```