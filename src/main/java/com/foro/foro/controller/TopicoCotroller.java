package com.foro.foro.controller;


import com.foro.foro.domain.topicos.DatosActualizarTopico;
import com.foro.foro.domain.topicos.DatosRegistroTopico;
import com.foro.foro.domain.topicos.Topico;
import com.foro.foro.domain.topicos.TopicoRepository;
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
@RequestMapping("/topicos")
public class TopicoCotroller {

    @Autowired
    private TopicoRepository topicoRepository;

    // agregar tópico
    @Transactional
    @PostMapping
    public void registrarTopico(@RequestBody @Valid DatosRegistroTopico datos) {
        topicoRepository.save(new Topico(datos));
    }

    // listar tópico
    @GetMapping
    public ResponseEntity<Page<DatosListaUsuario>> listarTopicos(@PageableDefault(size = 10) Pageable pageable) {
        Page<DatosListaUsuario> listaUsuarios = topicoRepository.findAll(pageable).map(DatosListaUsuario::new);
        return ResponseEntity.ok(listaUsuarios);
    }

    // actualizar tópico
    @Transactional
    @PutMapping
    public void actualizarTopico(@RequestBody DatosActualizarTopico datos) {
        Topico topico = topicoRepository.getReferenceById(datos.id());
        topico.actualizarTopico(datos);
    }

    // borrar tópico
    @Transactional
    @DeleteMapping("/{id}/respuestas")
    public void borrar(@PathVariable Long id) {
        topicoRepository.deleteById(id);
    }



}
