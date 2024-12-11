package com.sistemawebcar.service;


import com.sistemawebcar.domain.Marca;
import com.sistemawebcar.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    // Listar todas as marcas
    public List<Marca> listarMarcas() {
        return marcaRepository.findAll();
    }

    // Obter uma marca específica pelo ID
    public Marca obterMarca(Long id) {
        return marcaRepository.findById(id).orElse(null); // Retorna null se não encontrar
    }

    // Criar uma nova marca
    public Marca criarMarca(Marca marca) {
        return marcaRepository.save(marca);
    }

    // Atualizar uma marca existente
    public Marca atualizarMarca(Long id, Marca marcaAtualizada) {
        Optional<Marca> marcaExistente = marcaRepository.findById(id);
        if (marcaExistente.isPresent()) {
            Marca marca = marcaExistente.get();
            marca.setNome(marcaAtualizada.getNome());
            return marcaRepository.save(marca); // Salva a marca atualizada
        }
        return null; // Se não encontrar a marca, retorna null
    }

    // Excluir uma marca pelo ID
    public void excluirMarca(Long id) {
        marcaRepository.deleteById(id);
    }
}
