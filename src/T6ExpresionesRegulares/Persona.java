package T6ExpresionesRegulares;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;

public class Persona {
    String nombre;
    String DNI;
    String telefono;
    String direccion;

    public Persona(String nombre, String DNI, String telefono, String direccion) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", DNI: " + DNI + ", Teléfono: " + telefono + ", Dirección: " + direccion;
    }

    public static void main(String[] args) {
        String texto = "Nombre: Juan, DNI: 12345678A, Teléfono: 123456789, Dirección: Calle 123\n" +
                "Nombre: María, DNI: 87654321B, Teléfono: 987654321, Dirección: Avenida XYZ\n" +
                "Nombre: Carlos, DNI: 98765432C, Teléfono: 987654321, Dirección: Calle 456";

        String regex = "Nombre: (.*?), DNI: (.*?), Teléfono: (.*?), Dirección: (.*?)\\n?";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);

        List<Persona> listaPersonas = new ArrayList<>();

        while (matcher.find()) {
            String nombre = matcher.group(1);
            String DNI = matcher.group(2);
            String telefono = matcher.group(3);
            String direccion = matcher.group(4);
            listaPersonas.add(new Persona(nombre, DNI, telefono, direccion));
        }

        listaPersonas.forEach(System.out::println);
    }
}