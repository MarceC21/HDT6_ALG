import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class MiColeccion {
    private List<Pokemon> pokemones;
    private Map<String, Pokemon> pokemonMap; // Mapa con los Pokémon cargados del archivo

    public MiColeccion(Map<String, Pokemon> pokemonMap) {
        this.pokemones = new ArrayList<>();
        this.pokemonMap = pokemonMap;
    }

    // Método para verificar si un Pokémon está en el archivo
    private boolean existeEnArchivo(String nombre) {
        return pokemonMap.containsKey(nombre);
    }

    // Agregar un Pokémon a la colección solo si existe en el archivo
    public void agregarPokemon(String nombre) {
        if (existeEnArchivo(nombre)) {
            pokemones.add(pokemonMap.get(nombre));
            System.out.println(nombre + " ha sido agregado a tu colección.");
        } else {
            System.err.println("Error: " + nombre + " no está en el archivo de Pokémon.");
        }
    }

    public void ordenarPorTipo() {
        if (pokemones.isEmpty()) {
            System.out.println("La colección está vacía.");
            return;
        }
    
        List<Pokemon> pokemonesOrdenados = new ArrayList<>(pokemones);
        pokemonesOrdenados.sort(Comparator.comparing(Pokemon::getType1));
    
        System.out.println("Pokémon ordenados por tipo:");
        for (Pokemon pok : pokemonesOrdenados) {
            System.out.println("Tipo: " + pok.getType1() + " - Nombre: " + pok.getName());
        }
    }    

    // Método para obtener la lista completa 
    public List<Pokemon> getPokemones() {
        return new ArrayList<>(pokemones); // Retorna una copia para evitar modificaciones externas
    }


    //-----------------Para manejar el archivo-------------

// Buscar un Pokémon por nombre en el archivo (Map)
public Pokemon buscarPokemon(String nombre) {
    return pokemonMap.getOrDefault(nombre, null); // Retorna null si no lo encuentra
}


// Buscar todos los Pokémon que tienen la habilidad especificada
public List<String> buscarHabilidad(String habilidad) {
    List<String> pokemonesConHabilidad = new ArrayList<>();

    for (Pokemon pok : pokemonMap.values()) {
        // Divide las habilidades por coma y elimina espacios extra
        String[] habilidades = pok.getHabilidades().split(",\\s*");

        for (String hab : habilidades) {
            if (hab.equalsIgnoreCase(habilidad)) {
                pokemonesConHabilidad.add(pok.getName());
                break; // Evita agregar el mismo Pokémon varias veces si tiene la habilidad repetida
            }
        }
    }

    return pokemonesConHabilidad;
}


// Ordenar todos los Pokémon del archivo por tipo
public void ordenarPorTipoEnArchivo() {
    if (pokemonMap.isEmpty()) {
        System.out.println("No hay Pokémon en el archivo.");
        return;
    }

    List<Pokemon> pokemonesOrdenados = new ArrayList<>(pokemonMap.values());
    pokemonesOrdenados.sort(Comparator.comparing(Pokemon::getType1));

    System.out.println("Pokémon en el archivo ordenados por tipo:");
    for (Pokemon pok : pokemonesOrdenados) {
        System.out.println("Tipo: " + pok.getType1() + " - Nombre: " + pok.getName());
    }
}


}
