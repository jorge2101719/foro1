package com.foro.foro.controller;


import com.foro.foro.domain.respuestas.DatosListaRespuestas;
import com.foro.foro.domain.respuestas.DatosRegistroRespuesta;
import com.foro.foro.domain.respuestas.Respuesta;
import com.foro.foro.domain.respuestas.RespuestaRepository;
import com.foro.foro.domain.usuarios.DatosActualizarUsuario;
import com.foro.foro.domain.usuarios.DatosListaUsuario;
import com.foro.foro.domain.usuarios.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/respuestas")
public class RespuestaController {

    @Autowired
    private RespuestaRepository respuestaRepository;

    @Transactional
    @PostMapping
    public void agregarRespuesta(@RequestBody @Valid DatosRegistroRespuesta datos) {
        respuestaRepository.save(new Respuesta(datos));
    }

    @GetMapping
    public ResponseEntity<Page<DatosListaRespuestas>> listarUsuarios(@PageableDefault(size = 10) Pageable pageable) {
        Page<DatosListaUsuario> listaUsuarios = respuestaRepository.findAll(pageable).map(DatosListaUsuario::new);
        return ResponseEntity.ok(listaUsuarios);
    }

    // actualizar datos de usuarios
    @Transactional
    @PutMapping
    public void actualizar(@RequestBody @Valid DatosActualizarUsuario datos) {
        Usuario usuario = respuestaRepository.getReferenceById(datos.id());
        usuario.actualizarUsuario(datos);
    }

    // borrar usuario
    @Transactional
    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Long id) {
        respuestaRepository.deleteById(id);
    }

}
