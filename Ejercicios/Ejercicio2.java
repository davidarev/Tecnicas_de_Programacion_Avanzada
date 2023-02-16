public class Ejercicio2 {
    public static void main(String[] args) {
        int num = 1;

        // if
        if(num == 0) {
            System.out.println("El número es 0");
        } else if(num > 0) {
            System.out.println("El número es positivo");
        } else {
            System.out.println("El número es negativo");
        }

        // while
        while(num < 3) {
            num++;
            System.out.println(num);
        }

        // do while
        do {
            num++;
            System.out.println(num);
        } while(num < 3);

        // for
        for(int i = 0; i <= 3; i++) {
            System.out.println(i);
        }

        // switch
        String estacion = "Verano";
        switch(estacion) {
            case "Verano":
                System.out.println("Estamos en verano");
                break;
            case "Otoño":
                System.out.println("Estamos en otoño");
                break;
            case "Invierno":
                System.out.println("Estamos en invierno");
                break;
            case "Primavera":
                System.out.println("Estamos en primavera");
                break;
            default:
                System.out.println("No es una estación");
        }
    }
}
