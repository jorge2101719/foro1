package com.foro.foro.domain.usuarios;

import org.springframework.beans.factory.annotation.Autowired;

public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario actualizarUsuario(Long id, Usuario usuarioDetalles) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(("Usuario no encontrado")));

        usuario.setNombre(usuarioDetalles.getNombre());
        usuario.setCorreo(usuarioDetalles.getCorreo());
        usuario.setPerfiles(usuarioDetalles.getPerfiles());

        return usuarioRepository.save(usuario);
    }
}
