package com.foro.foro.controller;


import com.foro.foro.domain.cursos.*;
import com.foro.foro.domain.usuarios.DatosListaUsuario;
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

    @PostMapping
    public ResponseEntity<DatosListaCurso> agregarCurso(@RequestBody @Valid DatosRegistroCurso datosRegistroCurso) {
        Curso curso = cursoRepository.save(new Curso(datosRegistroCurso));
    }

    @GetMapping
    public ResponseEntity<Page<DatosListaCurso>> listarCursos(@PageableDefault(size = 10) Pageable pageable) {
        Page<DatosListaUsuario> listaUsuarios = cursoRepository.findAll(pageable).map(DatosListaUsuario::new);
        return ResponseEntity.ok(listaUsuarios);
    }

    @Transactional
    @PutMapping
    public void actualizar(@RequestBody @Valid DatosActualizarCurso datos) {
        Curso curso = cursoRepository.getReferenceById(datos.id());
        curso.actualizarCurso(datos);
    }

    // borrar usuario
    @Transactional
    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Long id) {
        cursoRepository.deleteById(id);
    }


}
