package org.example;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class MapFactory<k,v> {

    public Map<K> crearMap(String tipo) {
        return switch (tipo) {
            case "HashMap" -> new HashMap<>();
            case "TreeMap" -> new TreeMap<>();
            case "LinkedHashMap" -> new LinkedHashMap<>();
            default -> throw new IllegalArgumentException("Tipo de Map no válido: " + tipo);
        };
    }
}
