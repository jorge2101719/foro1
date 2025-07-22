package com.foro.foro.controller;


import com.foro.foro.domain.respuestas.*;
import com.foro.foro.domain.topicos.Topico;
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
@ResponseBody
@RequestMapping("/respuestas")
public class RespuestaController {

    @Autowired
    private RespuestaService respuestaService;

    @Transactional
    @PostMapping
    public ResponseEntity<DatosListaRespuestas> agregarRespuesta(@RequestBody @Valid DatosRegistroRespuesta datosRegistroRespuesta) {

        DatosListaRespuestas datosListaRespuestas = respuestaService.agregarRespuesta(datosRegistroRespuesta);
        return ResponseEntity.ok(datosListaRespuestas);

    }

    @GetMapping
    public ResponseEntity<Page<DatosListaRespuestas>> listarUsuarios(@PageableDefault(size = 10) Pageable pageable) {
        //Page<DatosListaUsuario> listaUsuarios = respuestaRepository.findAll(pageable).map(DatosListaUsuario::new);
        return ResponseEntity.ok(respuestaService.getRespuestas(pageable));
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
