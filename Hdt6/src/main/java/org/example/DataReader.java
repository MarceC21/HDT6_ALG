package org.example;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

public class DataReader {
    public static Map<String, Pokemon> readCSV(String filePath, String tipoMap) {
        Map<String, Pokemon> pokemonMap = new MapFactory<String, Pokemon>().crearMap(tipoMap);

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] parts;
            reader.readNext(); // Omitir encabezado

            while ((parts = reader.readNext()) != null) {
                try {
                    String name = parts[0].trim();
                    int pokedexNumber = Integer.parseInt(parts[1].trim());
                    String type1 = parts[2].trim();
                    String type2 = parts[3].trim().isEmpty() ? "N/A" : parts[3].trim();
                    String classi = parts[4].trim();
                    double altura = Double.parseDouble(parts[5].trim());
                    double peso = Double.parseDouble(parts[6].trim());
                    String habilidades = parts[7].trim();
                    int generation = Integer.parseInt(parts[8].trim());
                    boolean legenStatus = parts[9].trim().equalsIgnoreCase("yes");

                    pokemonMap.put(name, new Pokemon(name, pokedexNumber, type1, type2, classi, altura, peso, habilidades, generation, legenStatus));
                } catch (Exception e) {
                    System.err.println("Error de formato en línea: " + String.join(",", parts));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return pokemonMap;
    }
}

