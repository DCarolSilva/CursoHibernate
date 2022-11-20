package com.examenDaniela.examen.repo.crud;

import com.examenDaniela.examen.modelo.Vehiculo;
import com.examenDaniela.examen.repo.dao.VehiculoDAO;
import org.springframework.data.repository.CrudRepository;
/**
 * @author Daniela Carolina Silva Laguna.
 */
public interface VehiculoCrud extends CrudRepository<Vehiculo, Integer>, VehiculoDAO {
}
