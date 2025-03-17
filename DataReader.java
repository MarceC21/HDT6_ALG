import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class DataReader {

    public static Map<String, Pokemon> readCSV(String filePath, String tipoMap) {
        Map<String, Pokemon> pokemonMap = new MapFactory<String, Pokemon>().crearMap(tipoMap);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Omitir encabezado

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue; // Ignorar líneas vacías

                // Separar correctamente usando un método más preciso
                String[] parts = splitCSVLine(line);

                // Verifica que haya suficientes columnas antes de procesar
                if (parts.length < 10) {
                    System.err.println("Línea inválida, se ignorará: " + line);
                    continue;
                }

                try {
                    String name = parts[0];
                    int pokedexNumber = Integer.parseInt(parts[1]);
                    String type1 = parts[2];
                    String type2 = parts[3].isEmpty() ? "N/A" : parts[3];
                    String classi = parts[4];
                    double altura = Double.parseDouble(parts[5]);
                    double peso = Double.parseDouble(parts[6]);
                    String habilidades = parts[7];
                    int generation = Integer.parseInt(parts[8]);
                    boolean legenStatus = parts[9].equalsIgnoreCase("yes");

                    pokemonMap.put(name, new Pokemon(name, pokedexNumber, type1, type2, classi, altura, peso, habilidades, generation, legenStatus));

                } catch (NumberFormatException e) {
                    System.err.println("Error de formato en línea: " + line);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return pokemonMap;
    }

    /**
     * Método para dividir una línea CSV respetando comillas dobles y comas dentro de ellas.
     */
    private static String[] splitCSVLine(String line) {
        boolean insideQuotes = false;
        StringBuilder currentValue = new StringBuilder();
        String[] result = new String[10]; // Número esperado de columnas
        int index = 0;

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);

            if (c == '"') {
                insideQuotes = !insideQuotes; // Alternar el estado de las comillas
            } else if (c == ',' && !insideQuotes) {
                // Si encontramos una coma fuera de comillas, guardamos el valor actual
                result[index++] = currentValue.toString().trim();
                currentValue.setLength(0);
            } else {
                currentValue.append(c);
            }
        }

        result[index] = currentValue.toString().trim(); // Última columna
        return result;
    }
}

