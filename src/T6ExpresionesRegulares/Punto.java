package T6ExpresionesRegulares;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;

public class Punto {
    int x;
    int y;

    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "{" + x + "," + y + "}";
    }

    public static void main(String[] args) {
        String puntos = "{0,2}, {1,5}, {20,3}, {300,4}";
        String regex = "\\{(.*?)\\}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(puntos);

        List<Punto> listaPuntos = new ArrayList<>();

        while (matcher.find()) {
            String[] xy = matcher.group(1).split(",");
            int x = Integer.parseInt(xy[0].trim());
            int y = Integer.parseInt(xy[1].trim());
            listaPuntos.add(new Punto(x, y));
        }

        listaPuntos.forEach(System.out::println);
    }
}