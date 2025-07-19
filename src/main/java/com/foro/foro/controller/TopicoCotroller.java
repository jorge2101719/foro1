package com.foro.foro.controller;


import com.foro.foro.domain.topicos.DatosRegistroTopico;
import com.foro.foro.domain.topicos.Topico;
import com.foro.foro.domain.topicos.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topicos")
public class TopicoCotroller {

    @Autowired
    private TopicoRepository repository;

    @Transactional
    @PostMapping
    public void registrarTopico(@RequestBody @Valid DatosRegistroTopico datos) {
        repository.save(new Topico(datos));
    }
}
