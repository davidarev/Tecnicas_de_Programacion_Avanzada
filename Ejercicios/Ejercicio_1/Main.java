public class Main {
    public static void main(String[] args) {
        suma(1, 2, 3);

        Coche miCoche = new Coche(1);
        miCoche.incrementarPuertas();
        System.out.println("El coche tiene " + miCoche.puertas + " puertas");
    }

    public static void suma(int a, int b, int c){
        int suma = a + b + c;
        System.out.println("La suma es: " + suma);
    }
}
