package org.example;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String opcion ="";
        String tipo= "";


        System.out.println("Seleccione el tipo de Map a utilizar:");
        System.out.println("1. ");
        System.out.println("2. ");
        System.out.println("3. ");
        System.out.print("Ingrese el número de su elección: ");
        String op = scanner.nextLine();

            //Pasa la opción a String 
            if (op=="1") {
                tipo = "";
            } else if (op=="2") {
                tipo = "";
            } else if (op=="3") {
                tipo = "";
            } else {
                System.out.println("Opción inválida, intente de nuevo.");
                return;
            }

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
                    System.out.println("Opción 1 seleccionada: Agregar un pokemon a la colección");
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
                    // Lógica para salir
                    System.out.println("Saliendo del programa");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
            


        }




    }
}