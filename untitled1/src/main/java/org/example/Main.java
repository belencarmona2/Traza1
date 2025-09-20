package org.example;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        EmpresaService empresaService = new EmpresaService();

        Pais argentina = new Pais("Argentina");

        Provincia bsAs = new Provincia("Buenos Aires", argentina);
        Provincia cordoba = new Provincia("Córdoba", argentina);
        argentina.getProvincias().add(bsAs);
        argentina.getProvincias().add(cordoba);

        Localidad caba = new Localidad("Caba", bsAs);
        Domicilio domCaba = new Domicilio("Av. Corrientes", "123", "Caba");
        caba.setDomicilio(domCaba);

        Localidad laPlata = new Localidad("La Plata", bsAs);
        Domicilio domLaPlata = new Domicilio("Calle 10", "45", "La Plata");
        laPlata.setDomicilio(domLaPlata);

        bsAs.getLocalidades().add(caba);
        bsAs.getLocalidades().add(laPlata);

        Localidad cbaCapital = new Localidad("Córdoba Capital", cordoba);
        Domicilio domCbaCapital = new Domicilio("Bv. San Juan", "500", "Córdoba Capital");
        cbaCapital.setDomicilio(domCbaCapital);

        Localidad carlosPaz = new Localidad("Villa Carlos Paz", cordoba);
        Domicilio domCarlosPaz = new Domicilio("Av. San Martín", "200", "Villa Carlos Paz");
        carlosPaz.setDomicilio(domCarlosPaz);

        cordoba.getLocalidades().add(cbaCapital);
        cordoba.getLocalidades().add(carlosPaz);

        Sucursal suc1 = new Sucursal("Sucursal 1 - Caba", domCaba);
        Sucursal suc2 = new Sucursal("Sucursal 2 - La Plata", domLaPlata);
        Sucursal suc3 = new Sucursal("Sucursal 3 - Córdoba Capital", domCbaCapital);
        Sucursal suc4 = new Sucursal("Sucursal 4 - Villa Carlos Paz", domCarlosPaz);

        Empresa empresa1 = new Empresa("Empresa 1 SRL", "20-11111111-1");
        empresa1.addSucursal(suc1);
        empresa1.addSucursal(suc2);

        Empresa empresa2 = new Empresa("Empresa 2 SA", "30-22222222-2");
        empresa2.addSucursal(suc3);
        empresa2.addSucursal(suc4);

        empresaService.addEmpresa(empresa1);
        empresaService.addEmpresa(empresa2);

        System.out.println("=== Todas las empresas ===");
        empresaService.listAll().forEach(System.out::println);

        System.out.println("\n=== Buscar por ID ===");
        Long idBuscada = empresa1.getId();
        Optional<Empresa> encontrada = empresaService.findById(idBuscada);
        encontrada.ifPresentOrElse(
                e -> System.out.println("Encontrada: " + e),
                () -> System.out.println("No se encontró empresa con id " + idBuscada)
        );

        System.out.println("\n=== Buscar por nombre 'Empresa 2 SA' ===");
        empresaService.findByName("Empresa 2 SA").forEach(System.out::println);

        System.out.println("\n=== Actualizar CUIL de Empresa 1 ===");
        boolean actualizado = empresaService.updateCuilById(empresa1.getId(), "20-99999999-9");
        System.out.println("Actualizado? " + actualizado);
        empresaService.findById(empresa1.getId()).ifPresent(System.out::println);

        System.out.println("\n=== Eliminar Empresa 2 ===");
        boolean eliminado = empresaService.deleteById(empresa2.getId());
        System.out.println("Eliminado? " + eliminado);

        System.out.println("\n=== Empresas tras eliminación ===");
        empresaService.listAll().forEach(System.out::println);
    }
}