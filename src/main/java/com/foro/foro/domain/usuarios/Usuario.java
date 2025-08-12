package com.foro.foro.domain.usuarios;

import com.foro.foro.domain.perfiles.Perfil;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Table(name = "usuarios")
@Entity(name = "Usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(unique=true, nullable= false)
    private String correo;

    @Column(nullable = false)
    private String clave;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "perfil_usuario",
        joinColumns = @JoinColumn(name = "id_usuario"),
        inverseJoinColumns = @JoinColumn(name = "id_perfil")
    )
    private Set<Perfil> perfiles = new HashSet<>();



    public Usuario(DatosRegistroUsuario datos) {
        this.id = null;
        this.nombre = datos.nombre();
        this.correo = datos.correo();
        this.clave = datos.clave();
    }


    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    //public void setNombre(String nombre) { this.nombre = nombre; }
    public String getCorreo() { return correo; }
    //public void setCorreo(String correo) { this.correo = correo; }
    public String getClave() { return clave; }
    //public void setClave(String clave) { this.clave = clave; }
    public Set<Perfil> getPerfiles() { return perfiles; }
    //public void setPerfiles(Set<Perfil> perfiles) { this.perfiles = perfiles; }

    // --- Métodos de UserDetails ---
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return perfiles;
    }

    @Override
    public String getPassword() {
        return clave;
    }

    @Override
    public String getUsername() {
        return correo;
    }

    @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() { return true; }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @Override
    public boolean isEnabled() { return true; }
}
