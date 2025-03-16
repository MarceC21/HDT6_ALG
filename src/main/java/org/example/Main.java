package org.example;
import java.util.Map;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filePath = "pokemons.csv"; // Ruta del archivo CSV

        String tipo= "";

        System.out.println("Seleccione el tipo de Map a utilizar:");
        System.out.println("1. HashMap");
        System.out.println("2. TreeMap ");
        System.out.println("3. LinkedHashMap ");
        System.out.print("Ingrese el número de su elección: ");
        String op = scanner.nextLine();

            //Pasa la opción a String 
            if (op=="1") {
                tipo = "HashMap";
            } else if (op=="2") {
                tipo = "TreeMap";
            } else if (op=="3") {
                tipo = "LinkedHashMap";
            } else {
                System.out.println("Opción inválida, intente de nuevo.");
                return;
            }

        // Cargar Pokémon desde el archivo
        Map<String, Pokemon> pokemonMap = DataReader.readCSV(filePath, tipo);

        MiColeccion coleccion =new MiColeccion(pokemonMap);
        String opcion ="";

        while (opcion !="6"){
            System.out.println("MENU");
            System.out.println("1.Agregar un pokemon a la colección ");
            System.out.println("2.Mostrar los datos de un pokemon ");
            System.out.println("3.Mostrar el nombre y tipo1 en mi coleccion ");
            System.out.println("4.Mostrar el nombre y tipo1 de pokemones existentes ");
            System.out.print("5. Encontrar pokemon por habilidad ");
            System.out.println("6. Salir");
            System.out.print("Ingrese el número de su elección: ");
            opcion = scanner.nextLine();


            switch (opcion) {
                case "1":
                    // Lógica para agregar un pokemon
                    System.out.println("Agregar un pokemon a la colección");
                    System.out.println("Ingresa el nombre del Pokemon");
                    String nombre = scanner.nextLine();
                    coleccion.agregarPokemon(nombre);
                    break;
                case "2":
                    // Lógica para mostrar los datos de un pokemon
                    System.out.println("Opción 2 seleccionada: Mostrar los datos de un pokemon");
                    break;
                case "3":
                    // Lógica para mostrar el nombre y tipo1 en la colección
                    System.out.println("Opción 3 seleccionada: Mostrar el nombre y tipo1 en mi colección");
                    break;
                case "4":
                    // Lógica para mostrar el nombre y tipo1 de pokemones existentes
                    System.out.println("Opción 4 seleccionada: Mostrar el nombre y tipo1 de pokemones existentes");
                    break;
                case "5":
                    // Lógica para encontrar pokemon por habilidad
                    System.out.println("Opción 5 seleccionada: Encontrar pokemon por habilidad");
                    break;
                case "6":
                    System.out.println("Saliendo del programa");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
            


        }




    }
}