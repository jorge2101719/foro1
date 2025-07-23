package com.foro.foro.domain.perfil_usuario;

import com.challenge.forohub.domain.perfiles.Perfil;
import com.challenge.forohub.domain.perfiles.PerfilRespository;
import com.challenge.forohub.domain.usuarios.Usuario;
import com.challenge.forohub.domain.usuarios.UsuarioRepository;
import com.challenge.forohub.utils.errores.ErrorDeConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PerfilRespository perfilRespository;

    @Autowired
    private PerfilUsuarioRepository usuarioPerfilRepository;

    public DatosListaPerfilUsuario agregarPefil(DatosRegistroPerfilUsuario datosRegistroUsuarioPerfil) {

        Usuario usuario;
        Perfil perfil;

        if (usuarioRepository.findById(datosRegistroUsuarioPerfil.usuario_id()).isEmpty()) {
            throw new ErrorDeConsulta("No se halló el usuario");
        }
        if (perfilRespository.findById(datosRegistroUsuarioPerfil.perfil_id()).isEmpty()) {
            throw new ErrorDeConsulta("No se halló el perfil");
        }

        usuario = usuarioRepository.getReferenceById(datosRegistroUsuarioPerfil.usuario_id());
        perfil = perfilRespository.getReferenceById(datosRegistroUsuarioPerfil.perfil_id());

        PerfilUsuario usuarioPerfil = new PerfilUsuario(null, usuario, perfil);

        PerfilUsuario usuarioPerfil1 = usuarioPerfilRepository.save(usuarioPerfil);

        return new DatosListaPerfilUsuario(usuarioPerfil1);
    }

    public List<DatosListaPerfilUsuario> mostrarUsuarioPerfil() {
        return usuarioPerfilRepository.findAll().stream().map(DatosListaPerfilUsuario::new).toList();
    }

    public void borrarUsuarioPerfil(Long id) {
        usuarioPerfilRepository.deleteById(id);
    }
}
