package com.foro.foro.domain.usuarios;

public record DatosListaUsuario(
        Long id,
        String nombre
) {
    public DatosListaUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getNombre());
    }
}
