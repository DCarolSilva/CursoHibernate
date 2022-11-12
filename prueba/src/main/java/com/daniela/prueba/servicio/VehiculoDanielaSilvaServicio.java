package com.daniela.prueba.servicio;

import com.daniela.prueba.modelo.VehiculoDanielaSilva;
import com.daniela.prueba.repo.dao.VehiculoDanielaSilvaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehiculoDanielaSilvaServicio {
    VehiculoDanielaSilvaDAO vehiculoDanielaSilvaDAO;

    @Autowired
    public VehiculoDanielaSilvaServicio(VehiculoDanielaSilvaDAO vehiculoDanielaSilvaDAO) {
        this.vehiculoDanielaSilvaDAO = vehiculoDanielaSilvaDAO;
    }


    public List<VehiculoDanielaSilva> obtenerTodo() {
        return vehiculoDanielaSilvaDAO.obtenerTodo();
    }

    public Optional<VehiculoDanielaSilva> obtenerPorId(Integer id) {
        return vehiculoDanielaSilvaDAO.obtenerPorId(id);
    }

    public void guardar(VehiculoDanielaSilva vehiculoDanielaSilva) {
        vehiculoDanielaSilvaDAO.guardar(vehiculoDanielaSilva);
    }

    public void eliminar(Integer id) {
        vehiculoDanielaSilvaDAO.eliminar(id);
    }
}
