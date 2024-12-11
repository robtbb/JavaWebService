package br.edu.ifsc.fln.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.ifsc.fln.domain.Marca;
import br.edu.ifsc.fln.Repository.MarcaRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class MarcaService {
    @Autowired
    private MarcaRepository repository;

    public List<Marca> listarTodas() {
        return repository.findAll();
    }

    public Marca buscarPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Marca não encontrada!"));
    }

    public Marca salvar(Marca marca) {
        return repository.save(marca);
    }

    public Marca atualizar(Integer id, Marca novaMarca) {
        Marca marca = buscarPorId(id);
        marca.setNome(novaMarca.getNome());
        return repository.save(marca);
    }

    public void excluir(Integer id) {
        repository.deleteById(id);
    }
}

