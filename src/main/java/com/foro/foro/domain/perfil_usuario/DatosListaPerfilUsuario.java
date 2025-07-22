package com.foro.foro.domain.perfil_usuario;

public record DatosListado_Usuario_perfil(
        String nomrbreUsuario,
        String nombrePerfil
) {
    public DatosListado_Usuario_perfil(Usuario_Perfil usuarioPerfil) {
        this(usuarioPerfil.getUsuario().getNombre(), usuarioPerfil.getPerfil().getNombre());
    }
}
