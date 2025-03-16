package org.example;

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

    // Buscar un Pokémon por nombre y que retorne sus datos
    public Pokemon buscarPokemon(String nombre) {
        for (Pokemon pok : pokemones) {
            if (pok.getName().equalsIgnoreCase(nombre)) {
                return pok;
            }
        }
        return null; // Retorna null si no lo encuentra
    }

    // Retornar los nombres de los pokemones pero ordenados de acuerdo al Tipo1
    public void ordenarPorTipo() {
        if (pokemones.isEmpty()) {
            System.out.println("La colección está vacía.");
        }
        else{
            List<Pokemon> pokemonesOrdenados = new ArrayList<>(pokemones); //Copia 
            pokemonesOrdenados.sort(Comparator.comparing(Pokemon::getType1)); //los ordena
            List<String> nombresOrdenados = new ArrayList<>();
            for (Pokemon pok : pokemonesOrdenados) {
                nombresOrdenados.add(pok.getName());
            }
            return nombresOrdenados;

        }
    }


    // Buscar un Pokémon por su habilidad y retorna su nombre
    public String buscarHabilidad(String habilidad) {
        for (Pokemon pok : pokemones) {
            if (pok.getHabilidades().equalsIgnoreCase(habilidad)) {
                return pok.getName();
            }
        }
        return null; // Retorna null si no lo encuentra
    }


    // Método para obtener la lista completa 
    public List<Pokemon> getPokemones() {
        return new ArrayList<>(pokemones); // Retorna una copia para evitar modificaciones externas
    }
}
