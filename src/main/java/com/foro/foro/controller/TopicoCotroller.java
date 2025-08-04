package com.foro.foro.controller;


import com.foro.foro.domain.topicos.*;
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
    public void registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico) {
        topicoRepository.save(new Topico(datosRegistroTopico));
    }

    // listar tópico
    @GetMapping
    public ResponseEntity<Page<DatosListaTopico>> listarTopicos(@PageableDefault(size = 10) Pageable pageable) {
        Page<DatosListaTopico> listaTopico = topicoRepository.findAll(pageable).map(DatosListaTopico::new);
        return ResponseEntity.ok(listaTopico);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<DatosListaUsuario> mostrarTopico(@PathVariable Long id) {
//        return ResponseEntity.ok(topicoService.getTopioc(id));
//    }

    // actualizar tópico
    @Transactional
    @PutMapping
    public void actualizarTopico(@RequestBody DatosActualizarTopico datos) {
        Topico topico = topicoRepository.getReferenceById(datos.id());
        topico.actualizarTopico(datos);
    }

    // borrar tópico
    @Transactional
    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Long id) {
        topicoRepository.deleteById(id);
    }



}
