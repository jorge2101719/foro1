package com.foro.foro.domain.usuarios;

public record DatosListaUsuarios(
        Long id,
        String nombre
) {
    public DatosListaUsuarios(Usuario usuario) {
        this(usuario.getId(), usuario.getNombre());
    }
}
