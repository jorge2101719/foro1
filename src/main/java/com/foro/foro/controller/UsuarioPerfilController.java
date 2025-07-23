package com.foro.foro.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseBody
@RequestMapping("/usuarioperfil")
@SecurityRequirement(name = "bearer-key")
public class UsuarioPerfilController {

    @Autowired
    private UsuarioPerfilService usuarioPerfilService;

    @PostMapping
    public ResponseEntity<DatosListado_Usuario_perfil> agregarUsuariosPerfiles(@RequestBody @Valid DatosRegistro_Usuario_Perfil datosRegistroUsuarioPerfil) {
        return ResponseEntity.ok(usuarioPerfilService.agregarPefil(datosRegistroUsuarioPerfil));
    }

    @GetMapping
    public ResponseEntity<List<DatosListado_Usuario_perfil>> mostrarPerfilesUsuarios() {
        return ResponseEntity.ok(usuarioPerfilService.mostrarUsuarioPerfil());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity borrarUsuarioPerfil(@PathVariable Long id) {
        usuarioPerfilService.borrarUsuarioPerfil(id);
        return ResponseEntity.noContent().build();
    }


}
