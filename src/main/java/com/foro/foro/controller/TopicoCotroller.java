package com.foro.foro.controller;


import com.foro.foro.domain.topicos.DatosRegistroTopico;
import com.foro.foro.domain.topicos.Topico;
import com.foro.foro.domain.topicos.TopicoRepository;
import com.foro.foro.domain.usuarios.DatosActualizarUsuario;
import com.foro.foro.domain.usuarios.DatosListaUsuario;
import com.foro.foro.domain.usuarios.Usuario;
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
    public void actualizar(@RequestBody @Valid DatosActualizarUsuario datos) {
        Usuario usuario = topicoRepository.getReferenceById(datos.id());
        usuario.actualizarTopico(datos);
    }

    // borrar tópico
    @Transactional
    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Long id) {
        topicoRepository.deleteById(id);
    }



}
