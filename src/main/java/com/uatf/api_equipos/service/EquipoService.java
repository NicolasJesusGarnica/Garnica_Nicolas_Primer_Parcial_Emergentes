package com.uatf.api_equipos.service;

import com.uatf.api_equipos.entity.Equipo;
import com.uatf.api_equipos.repository.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EquipoService {

    @Autowired
    private EquipoRepository repository;

    public List<Equipo> findAll() {
        return repository.findAll();
    }

    public Equipo save(Equipo equipo) {
        return repository.save(equipo);
    }

    public Equipo findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}