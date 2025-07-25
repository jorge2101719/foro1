package com.foro.foro.controller;


import com.foro.foro.domain.respuestas.*;
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
//@SecurityRequirement(name = "baerer-key")
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

    @GetMapping("/{id}")
    public ResponseEntity<DatosListaRespuestas> mostrarRespuesta(@PathVariable Long id) {
        return ResponseEntity.ok(respuestaService.getRespuesta(id));
    }


    // actualizar datos de usuarios
    @Transactional
    @PutMapping
    public ResponseEntity<DatosListaRespuestas> actualizarRespuesta(@RequestBody @Valid DatosActualizarRespuesta datosActualizarRespuesta) {
        DatosListaRespuestas datosListaRespuestas = respuestaService.actualizaRespuesta(datosActualizarRespuesta);
        return ResponseEntity.ok(datosListaRespuestas);
    }

    // borrar usuario
    @Transactional
    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Long id) {
        respuestaService.deleteRespuesta(id);
    }

}
