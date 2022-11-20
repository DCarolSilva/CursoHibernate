package com.examenDaniela.examen.repo.daoImpl;

import com.examenDaniela.examen.conexionApi.ClienteConexionApi;
import com.examenDaniela.examen.modelo.Vehiculo;
import com.examenDaniela.examen.repo.dao.VehiculoDAO;
import com.google.gson.Gson;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
/**
 * @author Daniela Carolina Silva Laguna.
 */
@Repository
public class VehiculoDAOImpl implements VehiculoDAO {
    /**
     * @return lista de objetos tipo Vehiculo.
     * @throws Exception control de excepciones.
     * @since Implementación método obtenerListaVehiculos, encargado de obtener lista de vehiculos registrados por
     * medio de la comuncacion de ClienteconexionApi.
     */
    @Override
    public List<Vehiculo> obtenerListaVehiculos() throws Exception {
        Map<String, Object> respuesta = ClienteConexionApi.peticion("GET", "vehiculos/lista", null);
        if (respuesta != null && respuesta.get("cod") != null && (Integer) respuesta.get("cod") == 200) {
            if (respuesta.get("data") != null) {
                Vehiculo[] vehiculos;
                Gson gson = new Gson();
                vehiculos = gson.fromJson(respuesta.get("data").toString(), Vehiculo[].class);

                return List.of(vehiculos);
            }
        } else if (respuesta == null || respuesta.get("cod") == null || (Integer) respuesta.get("cod") != 200) {
            throw new Exception(respuesta.get("data") != null && !respuesta.get("data").toString().trim().isEmpty()
                    ? respuesta.get("cod").toString().concat(" " + respuesta.get("data").toString())
                    : respuesta.get("cod").toString());

        }
        return null;
    }
    /**
     * @return objeto tipo Vehiculo.
     * @param id parámetro tipo Integer, id a buscar.
     * @throws Exception control de excepciones.
     * @since Implementación método obtenerVehiculoPorId, encargado de obtener un vehiculo por id, por
     * medio de la comuncacion de ClienteconexionApi.
     */
    @Override
    public Vehiculo obtenerVehiculoPorId(Integer id) throws Exception {
        Map<String, Object> respuesta = ClienteConexionApi.peticion("GET", "vehiculos/lock/" + id, null);
        if (respuesta != null && respuesta.get("cod") != null && (Integer) respuesta.get("cod") == 200) {
            if (respuesta.get("data") != null) {
                Vehiculo vehiculo;
                Gson gson = new Gson();
                vehiculo = gson.fromJson(respuesta.get("data").toString(), Vehiculo.class);
                return vehiculo;
            }
        } else if (respuesta == null || respuesta.get("cod") == null || (Integer) respuesta.get("cod") != 200) {
            if(respuesta.get("cod") != null && (Integer)respuesta.get("cod") == 404){
                return null;
            }
            throw new Exception(respuesta.get("data") != null && !respuesta.get("data").toString().trim().isEmpty()
                    ? respuesta.get("cod").toString().concat(" " + respuesta.get("data").toString())
                    : respuesta.get("cod").toString());

        }
        return null;
    }
    /**
     * @param vehiculo parámetro tipo Vehiculo, objeto vehiculo a registrar.
     * @throws Exception control de excepciones.
     * @since Implementación método guardarVehiculo, encargado de registrar un vehiculo, por
     * medio de la comuncacion de ClienteconexionApi.
     */
    @Override
    public void guardarVehiculo(Vehiculo vehiculo) throws Exception {
        Map<String, Object> respuesta = ClienteConexionApi.peticion("POST", "vehiculos/lock/guardar",
                "{\"id\": " + vehiculo.getId()
                        + ",\"marca\": \"" + vehiculo.getMarca()
                        + "\",\"modelo\": " + vehiculo.getModelo()
                        + "\",\"color\": " + vehiculo.getColor()
                        + "\",\"transmision\": " + vehiculo.getTransmision()
                        + "\",\"anio\": " + vehiculo.getAnio()
                        + "}");
        if (respuesta == null || respuesta.get("cod") == null || (Integer) respuesta.get("cod") != 200) {
            throw new Exception(respuesta.get("data") != null && !respuesta.get("data").toString().trim().isEmpty()
                    ? respuesta.get("cod").toString().concat(" " + respuesta.get("data").toString())
                    : respuesta.get("cod").toString());
        }
    }
    /**
     * @param id parámetro tipo Integer, id vehiculo a eliminar.
     * @throws Exception control de excepciones.
     * @since Implementación método eliminarVehiculo, encargado de eliminar un vehiculo por id, por
     * medio de la comuncacion de ClienteconexionApi.
     */
    @Override
    public void eliminarVehiculo(Integer id) throws Exception {
        Map<String, Object> respuesta = ClienteConexionApi.peticion("DELETE", "vehiculos/lock/eliminar/" + id
                , null);
        if (respuesta == null || respuesta.get("cod") == null || (Integer) respuesta.get("cod") != 200) {
            throw new Exception(respuesta.get("data") != null && !respuesta.get("data").toString().trim().isEmpty()
                    ? respuesta.get("cod").toString().concat(" " + respuesta.get("data").toString())
                    : respuesta.get("cod").toString());
        }
    }
}
