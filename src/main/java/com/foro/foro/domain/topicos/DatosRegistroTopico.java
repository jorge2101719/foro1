package com.foro.foro.domain.topicos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopico(
        @NotNull Long id_usuario,
        @NotBlank String titulo,
        @NotBlank String mensaje,
        @NotBlank String nombreCurso
) {
}
