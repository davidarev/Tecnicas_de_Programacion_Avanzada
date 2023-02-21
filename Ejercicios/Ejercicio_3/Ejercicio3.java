public class Ejercicio3 {
    public static void main(String[] args) {
        Persona persona = new Persona();

        persona.setEdad(30);
        persona.setNombre("Juan");
        persona.setTelefono("555-1234");

        System.out.println("Edad: " + persona.getEdad());
        System.out.println("Nombre: " + persona.getNombre());
        System.out.println("Teléfono: " + persona.getTelefono());
    }
}
