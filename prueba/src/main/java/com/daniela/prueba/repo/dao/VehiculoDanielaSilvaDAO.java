package com.daniela.prueba.repo.dao;

import com.daniela.prueba.modelo.VehiculoDanielaSilva;

import java.util.List;
import java.util.Optional;

public interface VehiculoDanielaSilvaDAO {
    List<VehiculoDanielaSilva> obtenerTodo();

    Optional<VehiculoDanielaSilva> obtenerPorId(Integer id);

    void guardar(VehiculoDanielaSilva vehiculoDanielaSilva);

    void eliminar(Integer id);
}
