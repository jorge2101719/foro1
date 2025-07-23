package com.foro.foro.domain.perfil_usuario;

import jakarta.validation.constraints.NotNull;

public record DatosRegistroPerfilUsuario(
        @NotNull
        Long id_usuario,
        @NotNull
        Long id_perfil
) {
}
