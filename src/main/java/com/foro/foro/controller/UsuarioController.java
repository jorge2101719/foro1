package com.foro.foro.controller;

import com.foro.foro.domain.DatosRegistroUsuario;
import com.foro.foro.domain.Usuario;
import com.foro.foro.domain.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/usuarios")
@RestController
public class UsuarioController {

    @Autowired
    private UsuarioRepository autorRepository;

    @Transactional
    @PostMapping()
    public void registrarAutor(@RequestBody @Valid DatosRegistroUsuario datos) {
        //System.out.println("Datos del usuario: " + datos);
        autorRepository.save(new Usuario(datos));
    }

}
