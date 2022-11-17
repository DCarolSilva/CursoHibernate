package com.daniela.prueba.web;

import com.daniela.prueba.modelo.VehiculoDanielaSilva;
import com.daniela.prueba.servicio.VehiculoDanielaSilvaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoDanielaControlador {
    private VehiculoDanielaSilvaServicio vehiculoDanielaSilvaServicio;

    @Autowired
    public VehiculoDanielaControlador(VehiculoDanielaSilvaServicio vehiculoDanielaSilvaServicio) {
        this.vehiculoDanielaSilvaServicio = vehiculoDanielaSilvaServicio;
    }

    @GetMapping("/lista")
    public ResponseEntity<List<VehiculoDanielaSilva>> obtenerTodo() {
        return new ResponseEntity<>(vehiculoDanielaSilvaServicio.obtenerTodo(), HttpStatus.OK);
    }

    @GetMapping("/lock/{id}")
    public ResponseEntity<VehiculoDanielaSilva> obtenerPorId(@PathVariable Integer id) {
        return vehiculoDanielaSilvaServicio.obtenerPorId(id).map(vehiculo -> new ResponseEntity<>(vehiculo, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/lock/guardar")
    public ResponseEntity guardar(@RequestBody VehiculoDanielaSilva vehiculoDanielaSilva) {
        vehiculoDanielaSilvaServicio.guardar(vehiculoDanielaSilva);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/lock/eliminar/{id}")
    public ResponseEntity eliminar(@PathVariable Integer id) {
        vehiculoDanielaSilvaServicio.eliminar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
