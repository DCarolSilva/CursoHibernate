package com.daniela.prueba.modelo.mapper;

import com.daniela.prueba.modelo.VehiculoDanielaSilva;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VehiculoDanielaSilvaMapper implements RowMapper<VehiculoDanielaSilva> {


    @Override
    public VehiculoDanielaSilva mapRow(ResultSet rs, int rowNum) throws SQLException {
        VehiculoDanielaSilva vehiculoDanielaSilva = new VehiculoDanielaSilva();
        vehiculoDanielaSilva.setId(rs.getInt("id"));
        vehiculoDanielaSilva.setMarca(rs.getString("marca"));
        vehiculoDanielaSilva.setModelo(rs.getString("modelo"));
        vehiculoDanielaSilva.setColor(rs.getString("color"));
        vehiculoDanielaSilva.setTransmision(rs.getString("transmision"));
        vehiculoDanielaSilva.setAnio(rs.getInt("anio"));
        return vehiculoDanielaSilva;
    }
}
