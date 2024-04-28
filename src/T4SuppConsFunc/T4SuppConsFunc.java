package T4SuppConsFunc;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class T4SuppConsFunc {
    public static void main(String[] args) {
        // 1. Crea un predicado para comprobar si un número de entrada es mayor a 100.
        Predicate<Integer> mayorQue100 = num -> num > 100;

        // 2. Crea un predicado para comprobar si un número de entrada está entre 100 y 300.
        Predicate<Integer> entre100Y300 = num -> num >= 100 && num <= 300;

        // 3. Crea un predicado para comprobar si un número de entrada es mayor a 100 o es menor que 50.
        Predicate<Integer> mayor100Menor50 = num -> num > 100 || num < 50;

        // 4. Crea un predicado para comprobar que un número no sea igual a 100.
        Predicate<Integer> no100 = num -> num != 100;

        // 5. Crea un predicado para comprobar que dos String son iguales.
        BiPredicate<String, String> igual = (str1, str2) -> str1.equals(str2);

        // 6. Crea una lista con 10 enteros. Crea dos predicados para saber si algún número de la lista está entre 25 y 30. Imprime el resultado.
        List<Integer> numeros = Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80, 90, 100);
        Predicate<Integer> entre25Y30 = num -> num >= 25 && num <= 30;
        Predicate<List<Integer>> tieneEntre25Y30 = list -> list.stream().anyMatch(entre25Y30);
        System.out.println("¿Hay algún número entre 25 y 30 en la lista? " + tieneEntre25Y30.test(numeros));

        // 7. Crea una lista con 6 cadenas de texto. Crea predicados para saber si alguna cadena de texto empieza por A o si alguna tiene longitud 5.
        List<String> strings = Arrays.asList("Apple", "Banana", "Cherry", "Avocado", "Blueberry", "Almond");
        Predicate<String> empiezaPorA = str -> str.startsWith("A");
        Predicate<String> longitud5 = str -> str.length() == 5;

        // 8. Crea un predicado para encontrar elementos en la lista anterior que no empiecen por P.
        Predicate<String> noEmpiezaPorP = str -> !str.startsWith("P");

        // 9. Crea una lambda basada en Supplier que devuelva el String “Me gusta Java”. Imprime el resultado.
        Supplier<String> meGustaJava = () -> "Me gusta Java";
        System.out.println(meGustaJava.get());

        // 10. Crea una lista con 5 Strings con nombres de Ciudad. Crea una lambda basada en Supplier que devuelve aleatoriamente un nombre de la lista anterior. Imprime “me voy de viaje a…París”, donde la ciudad es la llamada a la lambda anterior
        List<String> ciudades = Arrays.asList("Paris", "London", "New York", "Tokyo", "Sydney");
        Supplier<String> ciudadAleatoria = () -> ciudades.get(new Random().nextInt(ciudades.size()));
        System.out.println("me voy de viaje a…" + ciudadAleatoria.get());

        // 11. Crea una lambda basada en Supplier que devuelva un String con la fecha actual. Busca información de cómo obtener la fecha y su formato
        Supplier<String> fechaActual = () -> LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        // 12. Crea una lambda basada en Supplier que devuelva String con el día de la semana actual
        Supplier<String> fechaActualSemana = () -> LocalDate.now().getDayOfWeek().toString();

        // 13. Con la lista del ejercicio 10, llama al método foreach y pasale una lambda que muestre por pantalla todas la ciudades en mayúsculas
        ciudades.forEach(ciudad -> System.out.println(ciudad.toUpperCase()));

        // 14. Crea una función que devuelva la longitud de una cadena. Imprime la longitud de la cadena “Programación” utilizando la función
        Function<String, Integer> tamanoString = str -> str.length();
        System.out.println(tamanoString.apply("Programación"));

        // 15. Crea una función que devuelva la potencia de dos de un número dado. Imprime la del número 4.
        Function<Integer, Integer> potenciaDeDos = num -> num * num;
        System.out.println(potenciaDeDos.apply(4));

        // 16. Crea una función que reciba un double y devuelva un string mostrando: “Resultado: numero”
        Function<Double, String> resultadoString = num -> "Resultado: " + num;

        // 17. Crea una lista con 4 textos de tipo List<String> inicializada con Arrays.asList. Crea un método convertirListaEnMap que se le pasan dos parámetros, uno la lista y otro será una función. El mapa será un HashMap<String, Integer> donde el string es cada elemento de la lista y el Integer depende de la función que le pasamos.
        List<String> textos = Arrays.asList("Texto1", "Texto2", "Texto3", "Texto4");
        Function<String, Integer> tamanoString1 = str -> str.length();
        Map<String, Integer> map = convertirListaEnMap(textos, tamanoString1);
        System.out.println(map);

        // a. Muestra la lista por pantalla
        textos.forEach(System.out::println);

        // b. Crea una función que devuelve un int con el tamaño de un String pasado como parámetro
        Function<String, Integer> tamanoString2 = str -> str.length();
        Map<String, Integer> map2 = convertirListaEnMap(textos, tamanoString2);

        // Muestra el Map por pantalla
        map.forEach((key, value) -> System.out.println("Key: " + key + ", Value: " + value));

        //c
        Function<String, Integer> contarA = str -> (int) str.chars().filter(ch -> ch == 'a').count();
        Map<String, Integer> mapearA = convertirListaEnMap(textos, contarA);
        mapearA.forEach((key, value) -> System.out.println("Key: " + key + ", Value: " + value));

        // 18. Transforma a su equivalente referencia a método las siguientes expresiones lambda
        List<String> lista = Arrays.asList("hello", "world", "java", "lambda");
        lista.forEach(System.out::println);

        lista.sort(String::compareTo);
    }

    //17
    public static Map<String, Integer> convertirListaEnMap(List<String> lista, Function<String, Integer> funcion) {
        Map<String, Integer> map = new HashMap<>();
        for (String text : lista) {
            map.put(text, funcion.apply(text));
        }
        return map;
    }
}