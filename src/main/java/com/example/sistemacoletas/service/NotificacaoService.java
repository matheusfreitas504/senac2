package com.example.sistemacoletas.service;

import com.example.sistemacoletas.entities.Notificacao;
import com.example.sistemacoletas.repository.NotificacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class NotificacaoService {

    private final NotificacaoRepository notificacaoRepository;

    @Autowired
    public NotificacaoService(NotificacaoRepository notificacaoRepository) {
        this.notificacaoRepository = notificacaoRepository;
    }

    public List<Notificacao> findAll() {
        return notificacaoRepository.findAll();
    }

    public Optional<Notificacao> findById(Long id) {
        return notificacaoRepository.findById(id);
    }

    public Notificacao save(Notificacao notificacao) {
        return notificacaoRepository.save(notificacao);
    }

    public Notificacao update(Notificacao notificacao) {
        return notificacaoRepository.save(notificacao);
    }
}
