package com.sistemawebcar.service;


import com.sistemawebcar.domain.Modelo;
import com.sistemawebcar.repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModeloService {

    @Autowired
    private ModeloRepository modeloRepository;

    // Listar todos os modelos com suas marcas associadas
    public List<Modelo> listarModelos() {
        return modeloRepository.findAll();
    }

    // Obter um modelo específico pelo ID
    public Modelo obterModelo(Long id) {
        return modeloRepository.findById(id).orElse(null);  // Retorna null se não encontrar
    }

    // Criar um novo modelo
    public Modelo criarModelo(Modelo modelo) {
        return modeloRepository.save(modelo);
    }

    // Atualizar um modelo existente
    public Modelo atualizarModelo(Long id, Modelo modeloAtualizado) {
        Optional<Modelo> modeloExistente = modeloRepository.findById(id);
        if (modeloExistente.isPresent()) {
            Modelo modelo = modeloExistente.get();

            // Atualiza a descrição do modelo
            modelo.setDescricao(modeloAtualizado.getDescricao());

            // Atualiza a marca do modelo, se fornecida
            if (modeloAtualizado.getMarca() != null) {
                modelo.setMarca(modeloAtualizado.getMarca());
            }

            return modeloRepository.save(modelo);  // Salva o modelo atualizado
        }
        return null;  // Se não encontrar o modelo, retorna null
    }

    // Excluir um modelo pelo ID
    public void excluirModelo(Long id) {
        modeloRepository.deleteById(id);
    }
}
