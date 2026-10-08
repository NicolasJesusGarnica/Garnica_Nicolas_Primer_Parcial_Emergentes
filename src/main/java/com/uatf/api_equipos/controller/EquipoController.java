package com.uatf.api_equipos.controller;

import com.uatf.api_equipos.entity.Equipo;
import com.uatf.api_equipos.service.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/equipos")
public class EquipoController {

    @Autowired
    private EquipoService service;

    @GetMapping
    public List<Equipo> listarTodos() {
        return service.findAll();
    }

    @PostMapping
    public Equipo guardar(@RequestBody Equipo equipo) {
        return service.save(equipo);
    }

    @GetMapping("/{id}")
    public Equipo obtenerPorId(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public Equipo actualizar(@PathVariable Long id, @RequestBody Equipo equipo) {
        equipo.setId(id);
        return service.save(equipo);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.deleteById(id);
    }
}