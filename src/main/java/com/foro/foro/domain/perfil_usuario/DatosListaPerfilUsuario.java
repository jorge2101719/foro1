package com.foro.foro.domain.perfil_usuario;

public record DatosListaPerfilUsuario(
        String nomrbreUsuario,
        String nombrePerfil
) {
    public DatosListaPerfilUsuario(PerfilUsuario usuarioPerfil) {
        this(usuarioPerfil.getUsuario().getNombre(), usuarioPerfil.getPerfil().getNombre());
    }
}
