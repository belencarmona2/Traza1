package org.example;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
public class Pais {
    private String nombre;

    @EqualsAndHashCode.Exclude
    private Set<Provincia> provincias = new HashSet<>();

    public Pais(String nombre) {
        this.nombre = nombre;
    }
}
