package com.foro.foro.domain.topicos;

import java.time.LocalDateTime;

public record DatosListaTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fecha
) {

    public DatosListaTopico(Topico topico) {

        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje()
        );
    }


}
