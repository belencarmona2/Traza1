package org.example;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Sucursal {
    private String nombre;
    private Domicilio domicilio;


    public Sucursal(String nombre, Domicilio domicilio) {
        this.nombre = nombre;
        this.domicilio = domicilio;
    }

    @Override
    public String toString() {
        return "Sucursal{" + "nombre='" + nombre + '\'' + ", domicilio=" + domicilio + '}';
    }
}

