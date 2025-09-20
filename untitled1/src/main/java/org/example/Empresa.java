package org.example;

import lombok.Data;
import lombok.ToString;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

@Data
public class Empresa {
    private static final AtomicLong COUNTER = new AtomicLong(0);

    private Long id;
    private String nombre;
    private String cuil;
    @ToString.Exclude
    private Set<Sucursal> sucursales = new HashSet<>();

    public Empresa() {
        this.id = COUNTER.incrementAndGet();
    }

    public Empresa(String nombre, String cuil) {
        this();
        this.nombre = nombre;
        this.cuil = cuil;
    }

    public void addSucursal(Sucursal s) {
        if (s != null) sucursales.add(s);
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", cuil='" + cuil + '\'' +
                ", sucursales=" + sucursales +
                '}';
    }
}
