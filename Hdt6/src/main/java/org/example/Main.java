package org.example;
import java.util.Map;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String tipo= "";
        String op= "";

        while (true) { 
            System.out.println("Seleccione el tipo de Map a utilizar:");
            System.out.println("1. HashMap");
            System.out.println("2. TreeMap");
            System.out.println("3. LinkedHashMap");
            System.out.print("Ingrese el número de su elección: ");
            
            op = scanner.nextLine();
        
            if (op.equals("1")) {
                tipo = "HashMap";
                break; // Salimos del bucle si la opción es válida
            } else if (op.equals("2")) {
                tipo = "TreeMap";
                break;
            } else if (op.equals("3")) {
                tipo = "LinkedHashMap";
                break;
            } else {
                System.out.println("Opción inválida, intente de nuevo.");
            }
        }

        String filePath = "data.csv"; 
        // Cargar Pokémon desde el archivo
        Map<String, Pokemon> pokemonMap = DataReader.readCSV(filePath, tipo);

        
        MiColeccion coleccion =new MiColeccion(pokemonMap);
        String opcion ="";

        while (!opcion.equals("6")) {  // Usamos .equals() en lugar de !=
            System.out.println("MENU");
            System.out.println("1.Agregar un pokemon a la colección ");
            System.out.println("2.Mostrar los datos de un pokemon ");
            System.out.println("3.Mostrar el nombre y tipo1 en mi coleccion ");
            System.out.println("4.Mostrar el nombre y tipo1 de pokemones existentes ");
            System.out.println("5. Encontrar pokemon por habilidad ");
            System.out.println("6. Salir");
            System.out.print("Ingrese el número de su elección: ");
            opcion = scanner.nextLine();
        
            switch (opcion) {
                case "1":
                    System.out.println("Agregar un pokemon a la colección");
                    System.out.println("Ingresa el nombre del Pokemon");
                    String nombre = scanner.nextLine();
                    coleccion.agregarPokemon(nombre);
                    break;
                case "2":
                    System.out.print("Ingrese el nombre del Pokémon: ");
                    String nom = scanner.nextLine();
                    Pokemon encontrado = coleccion.buscarPokemon(nom);
                    if (encontrado != null) {
                        System.out.println("Datos del Pokémon encontrado: " + encontrado);
                    } else {
                        System.out.println("Pokémon no encontrado.");
                    }
                    break;
                case "3":
                    System.out.println("Mostrar el nombre y tipo1 en mi colección");
                    coleccion.ordenarPorTipo();
                    break;
                case "4":
                    System.out.println("Mostrar el nombre y tipo1 de pokemones existentes");
                    coleccion.ordenarPorTipoEnArchivo();
                    break;
                case "5":
                    System.out.print("Ingresa una habilidad del Pokémon: ");
                    String hab = scanner.nextLine();
                    String resultado = coleccion.buscarHabilidad(hab);
                    if (resultado != null) {
                        System.out.println("El Pokémon con esa habilidad es: " + resultado);
                    } else {
                        System.out.println("No se encontró un Pokémon con esa habilidad.");
                    }
                    break;
                case "6":
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
        
        scanner.close(); 
    }
}