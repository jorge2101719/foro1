package com.foro.foro.domain.topicos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    @Query("SELECT t.status FROM Topico t WHERE t.id =:id")
    Boolean findByStatusById(Long id);

    @Query("SELECT t FROM Topico t WHERE t.status = TRUE")
    Page<Topico> findAllByStatusTrue(Pageable pageable);

    @Query("SELECT r.respuestaList FROM Topico r WHERE r.id =: id_topico")
    Page<Respuesta> findAllByRespuestas(Long id_topico, Pageable pageable);

    @Query("SELECT r.respuestaList FROM Topico r WHERE r.id =: id_topico")
    Page<Respuesta> findAllByRespuestas(Long id_topico, Pageable pageable);

}
