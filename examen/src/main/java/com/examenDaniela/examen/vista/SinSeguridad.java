package com.examenDaniela.examen.vista;

import com.examenDaniela.examen.modelo.Vehiculo;
import com.examenDaniela.examen.servicio.VehiculoServicio;
import lombok.Data;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Daniela Carolina Silva Laguna.
 */
@Scope(value = "session")
@Component
@Data
public class SinSeguridad implements Serializable {
    private String hola = "probando si llega...";
    /**
     * Lista de Vehiculos.
     */
    List<Vehiculo> lstVehiculo;
    /**
     * Variable vehiculoSeleccionado: registro seleccionado en la tabla.
     */
    Vehiculo vehiculoSeleccionado;
    /**
     * Variable idBuscar: almacena el id a buscar.
     */
    private Integer idBuscar;
    /**
     * Variable marca: almacena el atributo marca.
     */
    private String marca;
    /**
     * Variable modelo: almacena el atributo modelo.
     */
    private String modelo;
    /**
     * Variable color: almacena el atributo color.
     */
    private String color;
    /**
     * Variable transmision: almacena el atributo transmision.
     */
    private String transmision;
    /**
     * Variable anio: almacena el atributo anio.
     */
    private Integer anio;

    /**
     * dependencia vehiculoServicio.
     */
    private VehiculoServicio vehiculoServicio;

    /**
     * Constructor de dependencias.
     *
     * @param vehiculoServicio acceso a VehiculoServicio.
     */
    @Autowired
    public SinSeguridad(VehiculoServicio vehiculoServicio) {
        this.vehiculoServicio = vehiculoServicio;
    }

    /**
     * postConstructor.
     */
    @PostConstruct
    public void init() {
        System.out.println("holis...");
        cargarDatos();
    }

    /**
     * Método cargarDatos: carga la lista de vehiculos.
     */
    public void cargarDatos() {
        try {
            this.lstVehiculo = vehiculoServicio.obtenerListaVehiculos();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Info", "Ocurrió un error en la búsqueda de vehiculos, " + e));
        }
    }

    /**
     * Método buscar, encargado de invocar el metodo de busqueda correspondiente: (si no hay filtro por Id invoca
     * buscarDatos, de lo contrario invoca buscarDatosPorId.
     */
    public void buscar() {
        if (idBuscar == null) {
            cargarDatos();
        } else {
            cargarDatosPorId();
        }
    }

    /**
     * Método cargarDatosPorId: busca datos por id.
     */
    public void cargarDatosPorId() {
        try {
            if (idBuscar == null) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Info", "Debe ingresar un id para buscar"));
                return;
            }
            lstVehiculo = new ArrayList<>();
            Vehiculo vehiculo = vehiculoServicio.obtenerVehiculoPorId(idBuscar);
            if (vehiculo != null) {
                lstVehiculo.add(vehiculo);
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Info", "Ocurrió un error en la búsqueda de vehiculo por id, " + e));
        }
    }

    /**
     * Método abrirModalSave: ejecuta las instrucciones necesarias para abrir la modal encargada de registrar vehiculos.
     */
    public void abrirModalSave() {
        limpiar();
        PrimeFaces.current().executeScript("PF('mSave').show()");
    }

    /**
     * Método guardar: ejecuta las instrucciones necesarias para registrar un vehiculo.
     */
    public void guardar() {
        try {
            Vehiculo vehiculo = new Vehiculo();
            vehiculo.setMarca(marca != null ? marca.toUpperCase() : marca);
            vehiculo.setModelo(modelo != null ? modelo.toUpperCase() : modelo);
            vehiculo.setColor(color != null ? color.toUpperCase() : color);
            vehiculo.setTransmision(transmision != null ? transmision.toUpperCase() : transmision);
            vehiculo.setAnio(anio);
            vehiculoServicio.guardar(vehiculo);
            PrimeFaces.current().executeScript("PF('mSave').hide()");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Info", "Vehiculo registrado correctamente"));
            cargarDatos();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Info", "Ocurrió un error al registrar el vehiculo, " + e));
        }
    }

    /**
     * Método eliminar: ejecuta las instrucciones necesarias para eliminar un registro de vehiculo.
     */
    public void eliminar() {
        try {
            if (vehiculoSeleccionado == null) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Info", "Debe seleccionar un registro"));
                return;
            }
            vehiculoServicio.eliminarVehiculo(vehiculoSeleccionado.getId());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Info", "Vehiculo eliminado correctamente"));
            cargarDatos();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Info", "Ocurrió un error al elimanar el vehiculo, " + e));
        }
    }

    /**
     * Método cerrarModalSave: ejecuta las instrucciones necesarias para cerrar la modal encargada de registrar
     * vehiculos.
     */
    public void cerrarModalSave() {
        limpiar();
        PrimeFaces.current().executeScript("PF('mSave').hide()");
    }

    /**
     * Método limpiar: limpia las propiedades de un vehiculo.
     */
    private void limpiar() {
        marca = null;
        modelo = null;
        color = null;
        transmision = null;
        anio = null;
    }
}
