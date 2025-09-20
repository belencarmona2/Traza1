package org.example;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
public class Provincia {
    private String nombre;

    @EqualsAndHashCode.Exclude
    private Pais pais;

    @EqualsAndHashCode.Exclude
    private Set<Localidad> localidades = new HashSet<>();

    public Provincia(String nombre, Pais pais) {
        this.nombre = nombre;
        this.pais = pais;
    }
}