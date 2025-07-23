package com.foro.foro.domain.perfil_usuario;

import jakarta.validation.constraints.NotNull;

public record DatosRegistroPerfilUsuario(
        @NotNull
        Long usuario_id,
        @NotNull
        Long perfil_id
) {
}
