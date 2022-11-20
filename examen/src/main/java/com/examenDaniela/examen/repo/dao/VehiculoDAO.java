package com.examenDaniela.examen.repo.dao;

import com.examenDaniela.examen.modelo.Vehiculo;

import java.util.List;
/**
 * @author Daniela Carolina Silva Laguna.
 */
public interface VehiculoDAO {
    /**
     * Definición Método obtenerListaVehiculos obtiene la lista completa de vehiculos.
     *
     * @return Lista de Objetos tipo Vehiculo.
     */
    List<Vehiculo> obtenerListaVehiculos() throws Exception;

    /**
     * Definición Método obtenerVehiculoPorId obtiene vehiculos por id.
     *
     * @return Objeto tipo Vehiculo.
     */
    Vehiculo obtenerVehiculoPorId(Integer id) throws Exception;

    /**
     * Definición Método guardarVehiculo registra un vehiculo.
     */
    void guardarVehiculo(Vehiculo vehiculo) throws Exception;

    /**
     * Definición Método eliminarVehiculo elimina un vehiculo.
     */
    void eliminarVehiculo(Integer id) throws Exception;
}
