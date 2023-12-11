package com.example.sistemacoletas.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.sistemacoletas.entities.UsuarioAvaliacao;
import com.example.sistemacoletas.repository.UsuarioAvaliacaoRepository;
import java.util.List;
import java.util.Optional;


@Service
public class UsuarioAvaliacaoService {

    private final UsuarioAvaliacaoRepository repository;

    @Autowired
    public UsuarioAvaliacaoService(UsuarioAvaliacaoRepository repository) {
        this.repository = repository;
    }

    public List<UsuarioAvaliacao> findAll() {
        return repository.findAll();
    }

    public Optional<UsuarioAvaliacao> findById(Long id) {
        return repository.findById(id);
    }

    public UsuarioAvaliacao save(UsuarioAvaliacao usuarioAvaliacao) {
        return repository.save(usuarioAvaliacao);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}