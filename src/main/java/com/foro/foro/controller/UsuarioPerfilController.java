package com.foro.foro.controller;


import com.foro.foro.domain.perfil_usuario.DatosListaPerfilUsuario;
import com.foro.foro.domain.perfil_usuario.DatosRegistroPerfilUsuario;
import com.foro.foro.domain.perfil_usuario.PerfilUsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping("/usuarioperfil")
public class UsuarioPerfilController {

    @Autowired
    private PerfilUsuarioService perfilUsuarioService;

    @PostMapping
    public ResponseEntity<DatosListaPerfilUsuario> agregarUsuariosPerfiles(@RequestBody @Valid DatosRegistroPerfilUsuario datosRegistroPerfilUsuario) {
        return ResponseEntity.ok(perfilUsuarioService.agregarPerfil(datosRegistroPerfilUsuario));
    }

    @GetMapping
    public ResponseEntity<List<DatosListaPerfilUsuario>> mostrarPerfilesUsuarios() {
        return ResponseEntity.ok(perfilUsuarioService.mostrarPerfilUsuario());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity borrarUsuarioPerfil(@PathVariable Long id) {
        perfilUsuarioService.borrarUsuarioPerfil(id);
        return ResponseEntity.noContent().build();
    }


}
