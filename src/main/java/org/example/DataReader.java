package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

//Sigue siendo un borrador
public class DataReader {
 public static Map<String, Pokemon> readCSV(String filePath, Map<String, Pokemon> pokemonMap) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Omitir encabezado
            StringBuilder output = new StringBuilder();

            while ((line = br.readLine()) != null) {
                if (line.isEmpty()) continue; // Ignorar líneas vacías

                String[] parts = line.split(",", -1);
                if (parts.length != 4) {
                    System.err.println("Línea inválida, se ignorará: " + line);
                    continue;
                }

                try {
                    String name = parts[0];
                    int number = Integer.parseInt(parts[1]);
                    String type = parts[2];
                    double weight = Double.parseDouble(parts[3]);
                    //Terminar 

                    pokemonMap.put(name, new Pokemon());//poner parametros
                } catch (NumberFormatException e) {
                    System.err.println("Error de formato en: " + line);
                }
            }

            // Imprimir en una sola operación
            pokemonMap.forEach((key, value) -> output.append(key).append(": ").append(value).append("\n"));
            System.out.print(output);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return pokemonMap;
    }



}
