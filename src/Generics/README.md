# 2. Escribe una clase genérica Conjunto con un parámetro de tipo T. La clase usa un array de 10 elementos de tipo T (inicialmente almacena todos los valores NULL):
```java
    private static final int TAM = 10;
    private T[] array = (T[]) new Object[TAM];
```

# La clase gestiona las siguientes operaciones:
### a. boolean insert(T element) - inserta un elemento en el conjunto(set). Se inserta un elemento en el primer lugar vacío del array. Si el array está lleno; simplemente no hagas nada si no puede insertar un elemento, devuelve false. Puede haber duplicados
### b. boolean delete (T element): elimina un elemento igual a element (utiliza el método equals, no ==, para determinar la igualdad). Devuelve cierto si elimina el elemento.
### c. T get(int pos): devuelve el elemento en la posición o null
### d. int find(T element): devuelve la posición del elemento o negativo si no se encuentra.
### e. Prueba el código en un método main creando un Conjunto de cadenas (Conjunto<String>) y un Conjunto <Integer>. Utiliza las operaciones insert, find and delete. No hagas un cast en los elementos devueltos por get: los tipos genéricos no requieren casting.
### f. ¿Puedes insertar una cadena en un conjunto de enteros? Explica lo que sucede cuando lo intentas.

#### Respuesta: No se puede insertar una cadena en un conjunto de enteros ya que el compilador no permite la conversión de tipos de datos incompatibles y lanzará un error de compilación.

```java
public class Conjunto<T> {
    private static final int TAM = 10;
    private T[] array = (T[]) new Object[TAM];

    public boolean insert(T element) {
        for(int i = 0; i < TAM; i++) {
            if(array[i] == null) {
                array[i] = element;
                return true;
            }
        }
        return false;
    }

    public boolean delete(T element) {
        for(int i = 0; i < TAM; i++) {
            if(array[i] != null && array[i].equals(element)) {
                array[i] = null;
                return true;
            }
        }
        return false;
    }

    public T get(int pos) {
        return array[pos];
    }

    public int find(T element) {
        for(int i = 0; i < TAM; i++) {
            if(array[i] != null && array[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Conjunto<String> conjuntoString = new Conjunto<>();
        conjuntoString.insert("Hola");
        conjuntoString.insert("Mundo");
        conjuntoString.insert("Hola");
        System.out.println(conjuntoString.find("Hola"));
        System.out.println(conjuntoString.find("Mundo"));
        System.out.println(conjuntoString.find("Adiós"));
        System.out.println(conjuntoString.delete("Hola"));
        System.out.println(conjuntoString.delete("Hola"));
        System.out.println(conjuntoString.delete("Hola"));
        System.out.println(conjuntoString.find("Hola"));

        Conjunto<Integer> conjuntoInteger = new Conjunto<>();
        conjuntoInteger.insert(1);
        conjuntoInteger.insert(2);
        conjuntoInteger.insert(3);
        System.out.println(conjuntoInteger.find(1));
        System.out.println(conjuntoInteger.find(2));
        System.out.println(conjuntoInteger.find(3));
        System.out.println(conjuntoInteger.delete(1));
        System.out.println(conjuntoInteger.delete(1));
        System.out.println(conjuntoInteger.delete(1));
        System.out.println(conjuntoInteger.find(1));
    }
}
```

# 3. Escribe un método equals para la clase Conjunto (dos conjuntos son iguales si sus arrays contienen los mismos elementos en el mismo orden). ¿Puedes usar la instancia de T en tu método de igualdad? Crea dos conjuntos y usa el método equals para compararlos.

#### Respuesta: No se puede usar la instancia de T en el método de igualdad ya que el compilador no permite la comparación de tipos de datos incompatibles y lanzará un error de compilación.

```java
public boolean equals(Conjunto<T> conjunto) {
    for(int i = 0; i < TAM; i++) {
        if(array[i] == null && conjunto.get(i) != null) {
            return false;
        }
        if(array[i] != null && !array[i].equals(conjunto.get(i))) {
            return false;
        }
    }
    return true;
}

public static void main(String[] args) {
    Conjunto<String> conjuntoString1 = new Conjunto<>();
    conjuntoString1.insert("Hola");
    conjuntoString1.insert("Mundo");
    conjuntoString1.insert("Hola");

    Conjunto<String> conjuntoString2 = new Conjunto<>();
    conjuntoString2.insert("Hola");
    conjuntoString2.insert("Mundo");
    conjuntoString2.insert("Hola");

    System.out.println(conjuntoString1.equals(conjuntoString2));
}
```