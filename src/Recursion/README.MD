# 2. ¿Qué imprime el siguiente código si llamamos al método con la expresión mystery(0);?

```java
public void mystery (int n) {
    System.out.println(n + " ");
    if(n <= 5) {
        mystery (n + 1);
    }
}
```
#### Respuesta: imprime los números del 0 al 5, ya que el método se llama a sí mismo mientras `n` sea menor o igual a 5.

# ¿ Y con mystery(100);?

#### Respuesta: imprime el número 100, ya que el método se llama a sí mismo mientras `n` sea menor o igual a 5.

# 3. ¿Qué imprime el siguiente código si llamamos al método con mystery(5);?
```java
public void mystery (int n) {
    System.out.println(n + " ");
    if(n <= 5) {
    m   ystery (n - 1) ;
    }
}
```
#### Respuesta: imprime los números del 5 al 0, ya que el método se llama a sí mismo mientras `n` sea menor o igual a 5.

# 4. ¿Qué hace el siguiente algoritmo? Realiza una traza cualquiera.
```java
public static int fun(int x, int y) {
   if (y == 0) {
       return 0;
   }
   return (x + fun(x, y-1));
}
```
#### Respuesta: El método `fun` suma `x` tantas veces como `y` lo permita, si `y` es 5 entonces `x` se sumará 5 veces.

# 5. Escribe una función recursiva para realizar el cálculo del exponente: xe, sabiendo que todo número elevado a 0 = 1.
```java
   public static int exponente(int x, int e) {
   }
```
#### Respuesta:
```java
   public static int exponente(int x, int e) {
       if(e == 0) {
           return 1;
       }
       return x * exponente(x, e - 1);
   }
```

# 6. Dado el ejercicio anterior, escribe la versión iterativa del método del cálculo del exponente.
#### Respuesta:
```java
   public static int exponente(int x, int e) {
       int result = 1;
       for(int i = 0; i < e; i++) {
           result *= x;
       }
       return result;
   }
```

# 7. La sucesión de Fibonacci tiene una definición claramente recursiva. Crea una función recursiva que calcule la sucesión de Fibonacci hasta un número dado y la muestre por pantalla
#### Respuesta:
```java
   public static int fibonacci(int n) {
       if(n == 0) {
           return 0;
       }
       if(n == 1) {
           return 1;
       }
       return fibonacci(n - 1) + fibonacci(n - 2);
   }
```
