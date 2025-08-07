package com.foro.foro.domain.topicos;


import com.foro.foro.domain.cursos.Curso;
import com.foro.foro.domain.respuestas.Respuesta;
import com.foro.foro.domain.usuarios.Usuario;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String titulo;
    private String mensaje;

    @Column(name = "fecha")
    private LocalDateTime fecha;
    private Boolean status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario autor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_curso")
    private Curso curso;

    @OneToMany(mappedBy = "topico", fetch = FetchType.LAZY)
    private List<Respuesta> respuestaList;

    public Topico(@Valid DatosRegistroTopico datosRegistroTopico) {
        this.id = null;
        this.titulo = datosRegistroTopico.titulo();
        this.mensaje = datosRegistroTopico.mensaje();
    }


    public void actualizarTopico(@Valid DatosActualizarTopico datos) {
        boolean check = false;

        if (datos.titulo() != null) {
            this.titulo = datos.titulo();
            check = true;
        }

        if (datos.mensaje() != null) {
            this.mensaje = datos.mensaje();
            check = true;
        }

        if (check) {
            this.fecha = LocalDateTime.now();
        }
    }

    public void desactivaTopico() {
        this.status = false;
    }

    public void agregarRespuesta(Respuesta respuesta) {
        respuestaList.add(respuesta);
    }



}
