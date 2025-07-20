package com.foro.foro.domain.usuarios;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarUsuario(
        @NotNull Long id,
        @NotBlank String nombre,
        @NotBlank String correo,
        @NotBlank String clave
) {
}
