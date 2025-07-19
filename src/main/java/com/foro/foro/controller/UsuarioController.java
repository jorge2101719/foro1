package com.foro.foro.controller;

import com.foro.foro.domain.usuarios.DatosListaUsuario;
import com.foro.foro.domain.usuarios.DatosRegistroUsuario;
import com.foro.foro.domain.usuarios.Usuario;
import com.foro.foro.domain.usuarios.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    @PostMapping
    public void registrarUsuario(@RequestBody @Valid DatosRegistroUsuario datos) {
        //System.out.println("Datos del usuario: " + datos);
        usuarioRepository.save(new Usuario(datos));
    }

    @GetMapping
    public ResponseEntity<Page<DatosListaUsuario>> listarUsuarios(@PageableDefault(size = 10) Pageable pageable) {
        Page<DatosListaUsuario> listaUsuarios = usuarioRepository.findAll(pageable).map(DatosListaUsuario::new);
        return ResponseEntity.ok(listaUsuarios);
    }
}
