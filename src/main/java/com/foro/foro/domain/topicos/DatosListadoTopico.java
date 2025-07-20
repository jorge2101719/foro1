package com.foro.foro.domain.topicos;

import java.time.LocalDateTime;

public record DatosListadoTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fecha
) {

    public DatosListadoTopico(Topico topico) {

        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje()
        );
    }


}
