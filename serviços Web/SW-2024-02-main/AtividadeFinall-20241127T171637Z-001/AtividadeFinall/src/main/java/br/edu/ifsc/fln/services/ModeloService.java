package br.edu.ifsc.fln.services;

import br.edu.ifsc.fln.domain.Modelo;
import br.edu.ifsc.fln.Repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModeloService {

    @Autowired
    private ModeloRepository modeloRepository;

    public List<Modelo> listarTodos() {
        return modeloRepository.findAll();
    }

    public Modelo buscarPorId(Long id) {
        return modeloRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Modelo não encontrado"));
    }

    public Modelo salvar(Modelo modelo) {
        return modeloRepository.save(modelo);
    }

    public Modelo atualizar(Long id, Modelo modelo) {
        if (!modeloRepository.existsById(id)) {
            throw new RuntimeException("Modelo não encontrado");
        }
        modelo.setId(id);
        return modeloRepository.save(modelo);
    }

    public void excluir(Long id) {
        modeloRepository.deleteById(id);
    }
}

