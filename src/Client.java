import java.util.Arrays;

public class Client {
    public static IVector cartesianToPolar(IPolar2D vector) {
        double r = vector.abs();
        double angle = vector.getAngle();

        return new Vector2D(r, angle);
    }

    public static IVector cartesianToPolar(Vector2DPolarInheritance vector) {
        double r = vector.abs();
        double angle = vector.getAngle();

        return new Vector2D(r, angle);
    }

    public static String cartesianToPolar(Vector3DDecorator vector) {
        return "Podany wektor jest trojwymiarowy, ma wiec wspolrzedne cylindryczne a nie biegunowe";
    }

    public static void main(String[] args) {
        Vector2D vector1 = new Vector2D(3, Math.sqrt(3));
        Polar2DAdapter vector1Polar = new Polar2DAdapter(vector1);
        Vector2DPolarInheritance vector2 = new Vector2DPolarInheritance(Math.sqrt(2), 2);
        Vector3DDecorator vector3 = new Vector3DDecorator(3, 1, 0.5);
        Vector3DInheritance vector4 = new Vector3DInheritance(1, 0.5, 0.25);

        System.out.println("Wspolrzedne wektorow w ukladzie kartezjanskim: ([x,y,z])");
        System.out.println("vector 1: " + Arrays.toString(vector1.getComponents()));
        System.out.println("vector 2: " + Arrays.toString(vector2.getComponents()));
        System.out.println("vector 3: " + Arrays.toString(vector3.getComponents()));

        System.out.println("Wspolrzedne wektorow w ukladzie biegunowym: ([r, angle])");
        System.out.println("vector 1: " + Arrays.toString(cartesianToPolar(vector1Polar).getComponents()));
        System.out.println("vector 2: " + Arrays.toString(cartesianToPolar(vector2).getComponents()));
        System.out.println("vector 3: " + cartesianToPolar(vector3));

        System.out.println("Wyniki iloczynu skalarnego: ");
        System.out.println("1 * 2: " + vector1.cdot(vector2));
        System.out.println("1 * 3: " + vector1.cdot(vector3));
        System.out.println("1 * 4: " + vector1.cdot(vector4));
        System.out.println("2 * 3: " + vector2.cdot(vector3));

        System.out.println("Wyniki iloczynu wektorowego: ");
        System.out.println("3 x 1: " + Arrays.toString(vector3.cross(vector1).getComponents()));
        System.out.println("3 x 2: " + Arrays.toString(vector3.cross(vector2).getComponents()));
        System.out.println("3 x 4: " + Arrays.toString(vector3.cross(vector4).getComponents()));
        System.out.println("4 x 1: " + Arrays.toString(vector4.cross(vector1).getComponents()));
        System.out.println("4 x 2: " + Arrays.toString(vector4.cross(vector2).getComponents()));
        System.out.println("4 x 3: " + Arrays.toString(vector4.cross(vector3).getComponents()));
    }


    /* Zalety i wady użytych wzorców projektowych:
        Adapter - Przy pomocy adaptera opakowujemy niekompatybilny interfejs takiej biblioteki w nowy i dzięki temu
            nie musimy modyfikować naszego kodu.
        Dekorator - Wzorzec ten pozwala na dodanie lub zmianę zachowania klasy, bez potrzeby jej dziedziczenia.
            Zaletą wykorzystania tego wzorca jest bardzo duża elastyczność poprzez rozbicie funkcjonalności na wiele
            mniejszych klas, które mogą dynamicznie zmieniać działanie klasy bazowej.
            Wadą natomiast jest rozbicie projektu na małe klasy, które często są do siebie bardzo podobne.

     */


}
