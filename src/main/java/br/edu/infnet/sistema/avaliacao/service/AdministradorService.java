package br.edu.infnet.sistema.avaliacao.service;

import br.edu.infnet.sistema.avaliacao.model.Administrador;
import br.edu.infnet.sistema.avaliacao.repository.AdministradorRepository;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministradorService implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Autowired
    private AdministradorRepository administradorRepository;

    public Optional<Administrador> findById(Long id) {

        return administradorRepository.findById(id);

    }

    public List<Administrador> findAll() {

        return administradorRepository.findAll();

    }

    public void save(Administrador administrador) {
        administradorRepository.save(administrador);

    }

    public void remove(Long id) {
        administradorRepository.deleteById(id);
    }

}
