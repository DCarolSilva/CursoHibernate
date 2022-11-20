package com.examenDaniela.examen.servicio;

import com.examenDaniela.examen.modelo.Vehiculo;
import com.examenDaniela.examen.repo.crud.VehiculoCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/**
 * @author Daniela Carolina Silva Laguna.
 */
@Service
public class VehiculoServicio {
    private final VehiculoCrud vehiculoCrud;

    @Autowired
    public VehiculoServicio(VehiculoCrud vehiculoCrud) {
        this.vehiculoCrud = vehiculoCrud;
    }

    /**
     * Método obtenerListaVehiculos, encargado de invocar a la implementacion DAO del método obtenerListaVehiculos.
     *
     * @return lista de objetos tipo vehiculo.
     */
    public List<Vehiculo> obtenerListaVehiculos() throws Exception {
        return vehiculoCrud.obtenerListaVehiculos();
    }

    /**
     * Método obtenerListaVehiculos, encargado de invocar a la implementacion DAO del método obtenerVehiculoPorId.
     *
     * @return objeto tipo vehiculo.
     */
    public Vehiculo obtenerVehiculoPorId(final Integer id) throws Exception {
        return vehiculoCrud.obtenerVehiculoPorId(id);
    }

    /**
     * Método guardarVehiculo, encargado de invocar a la implementacion DAO del método guardarVehiculo.
     */
    public void obtenerListaVehiculos(final Vehiculo vehiculo) throws Exception {
        vehiculoCrud.guardarVehiculo(vehiculo);
    }

    /**
     * Método eliminarVehiculo, encargado de invocar a la implementacion DAO del método eliminarVehiculo.
     *
     * @return lista de objetos tipo vehiculo.
     */
    public void eliminarVehiculo(final Integer id) throws Exception {
        vehiculoCrud.eliminarVehiculo(id);
    }


    // metodos crud (crud repository)

    /**
     * Método guardar, encargado guardar un vehiculo por medio del método save de crud.
     */
    public void guardar(Vehiculo vehiculo) {
        vehiculoCrud.save(vehiculo);
    }

    /**
     * Método lista, encargado consultar lista de vehiculos por medio del método findAll de crud.
     *
     * @return Lista de objetos tipo vehiculo.
     */
    public List<Vehiculo> lista() {
        return (List<Vehiculo>) vehiculoCrud.findAll();
    }

    /**
     * Método obtenerPorId, encargado cpnsultar un vehiculo por medio del método findById de crud.
     *
     * @return objeto tipo vehiculo.
     */
    public Optional<Vehiculo> obtenerPorId(Integer id) {
        return vehiculoCrud.findById(id);
    }

    /**
     * Método eliminar, encargado eliminar un vehiculo por medio del método deleteById de crud.
     */
    public void eliminar(Integer id) {
        vehiculoCrud.deleteById(id);
    }
}
