package com.foro.foro.controller;


import com.foro.foro.domain.cursos.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @Transactional
    @PostMapping
    public void agregarCurso(@RequestBody @Valid DatosRegistroCurso datos) {
        cursoRepository.save(new Curso(datos));
    }

    @GetMapping
    public ResponseEntity<Page<DatosListaCurso>> listarCursos(@PageableDefault(size = 10) Pageable pageable) {
        Page<DatosListaCurso> listaCursos = cursoRepository.findAll(pageable).map(DatosListaCurso::new);
        return ResponseEntity.ok(listaCursos);
    }

    @Transactional
    @PutMapping
    public void actualizarCurso(@RequestBody @Valid DatosActualizarCurso datos) {
        Curso curso = cursoRepository.getReferenceById(datos.id());
        curso.actualizarCurso(datos);
    }

    // borrar usuario
    @Transactional
    @DeleteMapping("/{id}")
    public void borrarCurso(@PathVariable Long id) {
        cursoRepository.deleteById(id);
    }


}
