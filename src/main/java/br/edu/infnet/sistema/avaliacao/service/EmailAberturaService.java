package br.edu.infnet.sistema.avaliacao.service;

import br.edu.infnet.sistema.avaliacao.model.EmailAbertura;
import br.edu.infnet.sistema.avaliacao.repository.EmailAberturaRepository;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailAberturaService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private EmailAberturaRepository emailAberturaRepository;

    public Optional<EmailAbertura> findById(Long id) {

        return emailAberturaRepository.findById(id);

    }

    public List<EmailAbertura> findAll() {

        return emailAberturaRepository.findAll();

    }

    public void save(EmailAbertura emailAbertura) {
        emailAberturaRepository.save(emailAbertura);

    }

    public void remove(Long id) {
        emailAberturaRepository.deleteById(id);
    }
    
}
