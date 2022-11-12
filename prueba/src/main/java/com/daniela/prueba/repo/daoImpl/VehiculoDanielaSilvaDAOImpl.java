package com.daniela.prueba.repo.daoImpl;

import com.daniela.prueba.modelo.VehiculoDanielaSilva;
import com.daniela.prueba.modelo.mapper.VehiculoDanielaSilvaMapper;
import com.daniela.prueba.repo.dao.VehiculoDanielaSilvaDAO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class VehiculoDanielaSilvaDAOImpl implements VehiculoDanielaSilvaDAO {
    JdbcTemplate jdbcTemplate;

    @Override
    public List<VehiculoDanielaSilva> obtenerTodo() {
        return jdbcTemplate.query("select * from Vehiculo_Daniela_Silva", new VehiculoDanielaSilvaMapper());
    }

    @Override
    public Optional<VehiculoDanielaSilva> obtenerPorId(Integer id) {
        return jdbcTemplate.query("select * from Vehiculo_Daniela_Silva where id = ?" + id, new VehiculoDanielaSilvaMapper()).stream().findFirst();
    }

    @Override
    public void guardar(VehiculoDanielaSilva vehiculoDanielaSilva) {
        jdbcTemplate.update("INSERT INTO Vehiculo_Daniela_Silva " +
                "(marca,modelo,color,transmision,anio) values (?,?,?,?,?)",vehiculoDanielaSilva.getMarca(),
                vehiculoDanielaSilva.getModelo(),
                vehiculoDanielaSilva.getColor(),
                vehiculoDanielaSilva.getTransmision(),
                vehiculoDanielaSilva.getAnio());
    }

    @Override
    public void eliminar(Integer id) {
        jdbcTemplate.update("Delete from Vehiculo_Daniela_Silva where id = ?", id);
    }
}
