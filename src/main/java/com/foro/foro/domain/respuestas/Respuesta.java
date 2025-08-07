package com.foro.foro.domain.respuestas;


import com.foro.foro.domain.topicos.Topico;
import com.foro.foro.domain.usuarios.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "respuestas")
@Entity(name = "Respuesta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mensaje;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topico_id")
    private Topico topico;

    private LocalDateTime fecha = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario autor;

    private Boolean solucion = false;

    public void actualizarRespuesta(DatosActualizarRespuesta datos) {
        boolean check = false;

        if(datos.mensaje() != null) {
            this.mensaje = datos.mensaje();
            check = true;
        }

        if (datos.solucion() != null) {
            this.solucion = datos.solucion();
            check = true;
        }

        if (check) {
            this.fecha = LocalDateTime.now();
        }
    }



}
