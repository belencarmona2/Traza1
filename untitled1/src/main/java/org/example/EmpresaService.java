package org.example;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class EmpresaService {
    private Set<Empresa> empresas = new HashSet<>();

    public void addEmpresa(Empresa e) {
        empresas.add(e);
    }

    public Set<Empresa> listAll() {
        return new HashSet<>(empresas);
    }

    public Optional<Empresa> findById(Long id) {
        return empresas.stream().filter(e -> e.getId().equals(id)).findFirst();
    }

    public Set<Empresa> findByName(String nombre) {
        Set<Empresa> resultado = new HashSet<>();
        for (Empresa e : empresas) {
            if (e.getNombre() != null && e.getNombre().equalsIgnoreCase(nombre)) resultado.add(e);
        }
        return resultado;
    }

    public boolean updateCuilById(Long id, String nuevoCuil) {
        Optional<Empresa> opt = findById(id);
        if (opt.isPresent()) {
            opt.get().setCuil(nuevoCuil);
            return true;
        }
        return false;
    }

    public boolean deleteById(Long id) {
        return empresas.removeIf(e -> e.getId().equals(id));
    }
}
