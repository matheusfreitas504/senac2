
package com.example.sistemacoletas.controller;

import com.example.sistemacoletas.entities.Notificacao;
import com.example.sistemacoletas.service.NotificacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notificacoes")
public class NotificacaoController {

    private final NotificacaoService notificacaoService;

    @Autowired
    public NotificacaoController(NotificacaoService notificacaoService) {
        this.notificacaoService = notificacaoService;
    }

    @GetMapping
    public ResponseEntity<List<Notificacao>> getAllNotificacoes() {
        List<Notificacao> notificacoes = notificacaoService.findAll();
        return ResponseEntity.ok(notificacoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notificacao> getNotificacaoById(@PathVariable Long id) {
        return notificacaoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Notificacao> createNotificacao(@RequestBody Notificacao notificacao) {
        Notificacao novaNotificacao = notificacaoService.save(notificacao);
        return ResponseEntity.ok(novaNotificacao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Notificacao> updateNotificacao(@PathVariable Long id, @RequestBody Notificacao notificacaoDetails) {
        return notificacaoService.findById(id).map(notificacao -> {
            notificacao.setTexto(notificacaoDetails.getTexto());
            notificacao.setData(notificacaoDetails.getData());
            notificacao.setStatus(notificacaoDetails.getStatus());
            notificacao.setUsuarioReceptor(notificacaoDetails.getUsuarioReceptor());
            notificacao.setUsuarioNotificador(notificacaoDetails.getUsuarioNotificador());
            Notificacao updatedNotificacao = notificacaoService.update(notificacao);
            return ResponseEntity.ok(updatedNotificacao);
        }).orElse(ResponseEntity.notFound().build());
    }
}

