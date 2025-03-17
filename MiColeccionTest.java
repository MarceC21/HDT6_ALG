import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

class MiColeccionTest {
    private MiColeccion miColeccion;
    private Map<String, Pokemon> pokemonMap;

    @BeforeEach
    void setUp() {
        pokemonMap = new HashMap<>();
        // Agregando un Pokémon con los parámetros correctos
        pokemonMap.put("Bulbasaur", new Pokemon("Bulbasaur", 1, "Grass", "Poison", "Seed Pokémon", 0.7, 6.9, "Overgrow, Chlorophyll", 1, false));
        miColeccion = new MiColeccion(pokemonMap);
    }

    @Test
    void testAgregarPokemonExistente() {
        // Cambié el valor del constructor para que coincida con la firma del constructor de Pokémon
        miColeccion.agregarPokemon("Pikachu");
        assertEquals(1, miColeccion.getPokemones().size());
        assertEquals("Pikachu", miColeccion.getPokemones().get(0).getName());
    }

    @Test
    void testAgregarPokemonNoExistente() {
        // Intentando agregar a "Bulbasaur" que ya existe en el mapa, entonces no se debería agregar
        miColeccion.agregarPokemon("Bulbasauuiiuyir");
        assertEquals(1, miColeccion.getPokemones().size());
    }

    @Test
    void testOrdenarPorTipo() {
        // Agregando Pokémon adicionales para ordenar
        miColeccion.agregarPokemon("Pikachu");
        miColeccion.agregarPokemon("Charmander");

        miColeccion.ordenarPorTipo(); // Método de ordenación por tipo
        List<Pokemon> ordenados = miColeccion.getPokemones();
        // Esperamos que el tipo "Fuego" venga antes que "Eléctrico"
        assertEquals("Fire", ordenados.get(0).getType1());
        assertEquals("Electric", ordenados.get(1).getType1());
    }

    @Test
    void testBuscarPokemonExistente() {
        // Buscando el Pokémon existente
        Pokemon resultado = miColeccion.buscarPokemon("Pikachu");
        assertNotNull(resultado);
        assertEquals("Pikachu", resultado.getName());
    }

    @Test
    void testBuscarPokemonNoExistente() {
        // Buscando un Pokémon no existente
        Pokemon resultado = miColeccion.buscarPokemon("Bulbasaur");
        assertNull(resultado);
    }

    @Test
    void testBuscarHabilidad() {
        // Buscando habilidad "Estática"
        List<String> pokemones = miColeccion.buscarHabilidad("Static");
        assertEquals(1, pokemones.size());
        assertEquals("Pikachu", pokemones.get(0));
    }

    @Test
    void testBuscarHabilidadInexistente() {
        // Buscando habilidad que no existe
        List<String> pokemones = miColeccion.buscarHabilidad("Swift Swim");
        assertEquals(0, pokemones.size());
    }
}
