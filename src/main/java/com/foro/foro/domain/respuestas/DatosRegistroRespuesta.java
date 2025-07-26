package com.foro.foro.domain.respuestas;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroRespuesta(
        @NotNull Long topico_id,
        @NotBlank String mensaje,
        @NotNull Long id_usuario

        ) {

}
