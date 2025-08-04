package com.foro.foro.controller;

import com.foro.foro.domain.usuarios.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // agregar usuarios
    @Transactional
    @PostMapping
    public ResponseEntity<DatosListaUsuarios> registrarUsuario(@RequestBody @Valid DatosRegistroUsuario datos, UriComponentsBuilder uriComponentsBuilder) {
        //System.out.println("Datos del usuario: " + datos);
        Usuario usuario = usuarioRepository.save(new Usuario(datos));
        DatosListaUsuarios datosListaUsuarios = new DatosListaUsuarios(
                usuario.getId(),
                usuario.getNombre()
        );

        URI url = uriComponentsBuilder.path("usuarios/{id}").buildAndExpand(usuario.getId()).toUri();

        return ResponseEntity.created(url).body(datosListaUsuarios);
    }

    // listar usuarios
    @GetMapping
    public ResponseEntity<Page<DatosListaUsuarios>> listarUsuarios(@PageableDefault(size = 10) Pageable pageable) {
        Page<DatosListaUsuarios> listaUsuarios = usuarioRepository.findAll(pageable).map(DatosListaUsuarios::new);
        return ResponseEntity.ok(listaUsuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosListaUsuarios> mostrarUsuario(@PathVariable Long id) {
        Usuario usuario = usuarioRepository.getReferenceById(id);
        DatosListaUsuarios datosListaUsuario = new DatosListaUsuarios(
                usuario.getId(),
                usuario.getNombre()
        );

        return ResponseEntity.ok(datosListaUsuario);
    }

    // actualizar datos de usuarios
    @Transactional
    @PutMapping
    public void actualizar(@RequestBody @Valid DatosActualizarUsuario datos) {
        Usuario usuario = usuarioRepository.getReferenceById(datos.id());
        usuario.actualizarUsuario(datos);

        return;
    }

    // borrar usuario
    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> borrar(@PathVariable Long id) {
        usuarioRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }



}
