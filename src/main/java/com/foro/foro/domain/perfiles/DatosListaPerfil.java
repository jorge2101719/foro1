package com.foro.foro.domain.perfiles;

public record DatosListaPerfil(
        Long id,
        String nombre
) {

    public DatosListaPerfil(Perfil perfil) {
        this(
                perfil.getId(),
                perfil.getNombre()
        );
    }
}