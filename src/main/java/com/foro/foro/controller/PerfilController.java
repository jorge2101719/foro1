package com.foro.foro.controller;

import com.foro.foro.domain.perfiles.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/perfiles")
public class PerfilController {

    @Autowired
    private PerfilRepository perfilRepository;

    @Transactional
    @PostMapping
    public void agregarPerfil(@RequestBody @Valid DatosRegistroPerfil datosRegistroPerfil) {
        perfilRepository.save(new Perfil(datosRegistroPerfil));
    }

    @Transactional
    @PutMapping
    public ResponseEntity<DatosListaPerfil> actualizarPerfil(@RequestBody @Valid DatosActualizarPerfil datosActualizarPerfil) {
        Perfil perfil = perfilRepository.getReferenceById(datosActualizarPerfil.id());
        perfil.actualizarPerfil(datosActualizarPerfil);
        return ResponseEntity.ok(new DatosListaPerfil(perfil));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public void borrarPerfil(@PathVariable Long id) {
        perfilRepository.deleteById(id);
    }

}
