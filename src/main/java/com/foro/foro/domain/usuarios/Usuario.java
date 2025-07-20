package com.foro.foro.domain.usuarios;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "usuarios")
@Entity(name = "Usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String correo;
    private String clave;
    //private Boolean admin = false;

    public Usuario(DatosRegistroUsuario datos) {
        this.id = null;
        this.nombre = datos.nombre();
        this.correo = datos.correo();
        this.clave = datos.clave();
        //this.admin = datos.admin();
    }

    public void actualizarUsuario(DatosActualizarUsuario datos) {
        if (datos.nombre() != null) {
            this.nombre = datos.nombre();
        }

        if (datos.correo() != null) {
            this.correo = datos.correo();
        }

        if (datos.clave() != null) {
            this.clave = datos.clave();
        }
    }
}
