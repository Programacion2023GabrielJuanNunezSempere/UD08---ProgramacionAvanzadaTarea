package T6ExpresionesRegulares;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class T6ExpresionesRegulares {


    public static void main(String[] args) {
        //1.
        String regex = "He ido al .*\\.";
        String texto1 = "He ido al cine.";
        String texto2 = "He ido al supermercado.";

        System.out.println(texto1.matches(regex));
        System.out.println(texto2.matches(regex));

        //2.
        Pattern patron = Pattern.compile(regex);
        Matcher matcher1 = patron.matcher(texto1);
        Matcher matcher2 = patron.matcher(texto2);

        System.out.println(matcher1.matches());
        System.out.println(matcher2.matches());

        //3.
        String texto = "Ciclo+$+formativo+$$+Desarrollo+$$$$+de+$$+aplicaciones+$+multiplataforma.";
        String reemplazo = texto.replaceAll("\\+\\$+\\+", "_");
        System.out.println(reemplazo);

        //4.
        String regex2 = "a*b+c+d{3}e.*";
        String string = "sssdd aaabcccccccdddefffg ffffccc aaabcccccccdddefffg";

        System.out.println(string.matches(".*" + regex2 + ".*"));

        Pattern pattern2 = Pattern.compile(regex2);
        Matcher matcher = pattern2.matcher(string);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        System.out.println(count);

        //5.
        String regex3 = "^[a-zA-Z]+\\.\\d+$";
        String string2 = "abcdge.1234";

        System.out.println(string2.matches(regex3));

        //6.
        String regex4 = "^[a-zA-Z]+\\.(\\d+)$";
        String string3 = "abcde.1234jd.6tjuk.000";

        Pattern patron3 = Pattern.compile(regex4);
        Matcher macheado = patron3.matcher(string3);

        while (macheado.find()) {
            System.out.println(macheado.group(1));
        }

        //7.
        String log = "192.168.1.10 - - [11/Apr/2024:12:00:00] \"GET /pagina1 HTTP/1.1\" 200 1234\n" +
                "192.168.3.40 - - [11/Apr/2024:12:01:00] \"GET /pagina2 HTTP/1.1\" 200 3456\n" +
                "192.168.4.60 - - [12/Apr/2024:12:02:00] \"GET /pagina3 HTTP/1.1\" 200 6789\n" +
                "192.168.1.20 - - [14/Apr/2024:12:03:00] \"GET /pagina4 HTTP/1.1\" 200 9876\n" +
                "192.168.3.50 - - [14/Apr/2024:12:04:00] \"GET /pagina5 HTTP/1.1\" 200 5432\n" +
                "192.168.4.70 - - [18/Apr/2024:12:05:00] \"GET /pagina6 HTTP/1.1\" 200 8765\n" +
                "192.168.1.30 - - [18/May/2024:12:06:00] \"GET /pagina7 HTTP/1.1\" 200 2345";

        String regex5 = "(192\\.168\\.1\\.[1-9][0-9]{0,2}) - - (\\[.*?\\])";
        Pattern patron4 = Pattern.compile(regex5);
        Matcher macheado2 = patron4.matcher(log);

        while (macheado2.find()) {
            System.out.println("IP: " + macheado2.group(1) + ", Fecha: " + macheado2.group(2));
        }
    }
}
