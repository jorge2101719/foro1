package com.foro.foro.domain.perfil_usuario;

public record DatosListaPerfilUsuario(
        String nomrbreUsuario,
        String nombrePerfil
) {
    public DatosListaPerfilUsuario(PerfilUsuario perfilUsuario) {
        this(
                //perfilUsuario.getId(),
                perfilUsuario.getUsuario().getNombre(),
                perfilUsuario.getPerfil().getNombre()
        );
    }
}
