package Streams;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Empleado implements Comparable<Empleado> {
    private String nombre;
    private String apellido;
    private double sueldo;
    private LocalDate fechaEntrada;
    private Departamento departamento;

    public enum Departamento {
        INFORMATICA,
        CONTABILIDAD,
        RRHH
    }

    public Empleado(String nombre, String apellido, double sueldo, LocalDate fechaEntrada, Departamento departamento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.sueldo = sueldo;
        this.fechaEntrada = fechaEntrada;
        this.departamento = departamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", sueldo=" + sueldo +
                ", fechaEntrada=" + fechaEntrada +
                ", departamento=" + departamento +
                '}';
    }

    @Override
    public int compareTo(Empleado o) {
        return this.apellido.compareTo(o.getApellido());
    }

    public static void main(String[] args) {
        List<Empleado> empleados = new ArrayList<>();
        empleados.add(new Empleado("Juan", "García", 35000, LocalDate.of(2020, 3, 15), Empleado.Departamento.INFORMATICA));
        empleados.add(new Empleado("María", "Martínez", 20000, LocalDate.of(2019, 8, 10), Empleado.Departamento.CONTABILIDAD));
        empleados.add(new Empleado("Luis", "López", 28000, LocalDate.of(2022, 1, 20), Empleado.Departamento.RRHH));
        empleados.add(new Empleado("Ana", "González", 37000, LocalDate.of(2023, 5, 5), Empleado.Departamento.INFORMATICA));
        empleados.add(new Empleado("Carlos", "Rodríguez", 32000, LocalDate.of(2022, 12, 1), Empleado.Departamento.CONTABILIDAD));

        // 2. Crea un stream que muestre por pantalla los empleados con sueldo mayor de 30000
        empleados.stream()
                .filter(empleado -> empleado.getSueldo() > 30000)
                .forEach(System.out::println);

        // 3. Crea un stream que muestre por pantalla los empleados de Informática
        empleados.stream()
                .filter(empleado -> empleado.getDepartamento() == Empleado.Departamento.INFORMATICA)
                .forEach(System.out::println);

        // 4. Crea un stream que muestre por pantalla los empleados de Contabilidad con sueldo mayor de 30000 ordenado por sueldo. Utiliza peek para ver los resultados intermedios
        empleados.stream()
                .filter(empleado -> empleado.getDepartamento() == Empleado.Departamento.CONTABILIDAD && empleado.getSueldo() > 30000)
                .sorted(Comparator.comparing(Empleado::getSueldo))
                .peek(System.out::println)
                .forEach(System.out::println);

        // 5. Crea un stream que devuelva una lista de String con los nombres del departamento de informática. Imprímela por pantalla
        List<String> nombresInformatica = empleados.stream()
                .filter(empleado -> empleado.getDepartamento() == Empleado.Departamento.INFORMATICA)
                .map(Empleado::getNombre)
                .collect(Collectors.toList());

        System.out.println(nombresInformatica);

        // 6. Crea un stream que devuelva un array de String con nombre+ sueldo, ordenada por sueldo. Imprimir por pantalla
        String[] nombresSueldos = empleados.stream()
                .sorted(Comparator.comparing(Empleado::getSueldo))
                .map(empleado -> empleado.getNombre() + " " + empleado.getSueldo())
                .toArray(String[]::new);

        Arrays.stream(nombresSueldos).forEach(System.out::println);

        // 7. Crea un stream que ordena por departamento y por apellido e imprime Departamento+apellido
        empleados.stream()
                .sorted(Comparator.comparing(Empleado::getDepartamento)
                        .thenComparing(Empleado::getApellido))
                .forEach(empleado -> System.out.println(empleado.getDepartamento() + " " + empleado.getApellido()));

        // 8. Crea un stream que imprime los empleados que entraron a la empresa el 2022
        empleados.stream()
                .filter(empleado -> empleado.getFechaEntrada().getYear() == 2022)
                .forEach(System.out::println);

        // 9. Crea un stream que imprima la fecha de entrada de los empleados en formato local (12 abril 2023)
        empleados.stream()
                .map(empleado -> empleado.getFechaEntrada().format(DateTimeFormatter.ofPattern("d MMMM yyyy", new Locale("es", "ES"))))
                .forEach(System.out::println);

        // 10. Crea un stream que imprima el empleado con sueldo máximo
        empleados.stream()
                .max(Comparator.comparing(Empleado::getSueldo))
                .ifPresent(System.out::println);

        // 11. Crea un stream que nos diga el número total de empleados de Informática, imprime el resultado
        long totalInformatica = empleados.stream()
                .filter(empleado -> empleado.getDepartamento() == Empleado.Departamento.INFORMATICA)
                .count();

        System.out.println("Total employees in Informatics: " + totalInformatica);
    }
}