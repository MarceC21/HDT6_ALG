package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class DataReader {

    public static Map<String, Pokemon> readCSV(String filePath, String tipoMap) {
        // Se crea el Map con Factory
        Map<String, Pokemon> pokemonMap = new MapFactory<String, Pokemon>().crearMap(tipoMap);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Omitir encabezado

            while ((line = br.readLine()) != null) {
                if (line.isEmpty()) continue; // Ignorar líneas vacías

                String[] parts = line.split(",", -1);
                if (parts.length < 10) { // Verifica que haya suficientes columnas
                    System.err.println("Línea inválida, se ignorará: " + line);
                    continue;
                }

                try {
                    String name = parts[0].trim();
                    int pokedexNumber = Integer.parseInt(parts[1].trim());
                    String type1 = parts[2].trim();
                    String type2 = parts[3].trim();
                    String classi = parts[4].trim();
                    double altura = Double.parseDouble(parts[5].trim());
                    double peso = Double.parseDouble(parts[6].trim());
                    String habilidades = parts[7].trim();
                    int generation = Integer.parseInt(parts[8].trim());
                    boolean legenStatus = parts[9].trim().equalsIgnoreCase("true");

                    // Crear y agregar el Pokémon al Map
                    pokemonMap.put(name, new Pokemon(name, pokedexNumber, type1, type2, classi, altura, peso, habilidades, generation, legenStatus));

                } catch (NumberFormatException e) {
                    System.err.println("Error de formato en: " + line);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return pokemonMap;
    }
}
