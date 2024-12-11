package com.sistemawebcar.controller;


import com.sistemawebcar.domain.Modelo;
import com.sistemawebcar.repository.MarcaRepository;
import com.sistemawebcar.repository.ModeloRepository;
import com.sistemawebcar.service.ModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/modelos")
public class ModeloController {

    @Autowired
    private ModeloService modeloService;
    @Autowired
    private ModeloRepository modeloRepository;
    @Autowired
    private MarcaRepository marcaRepository;

    // Listar todos os modelos com suas marcas associadas
    @GetMapping
    public List<Modelo> listarModelos() {
        return modeloService.listarModelos();
    }

    // Listar um modelo específico pelo ID
    @GetMapping("/{id}")
    public Modelo obterModelo(@PathVariable Long id) {
        return modeloService.obterModelo(id);
    }

    // Criar um novo modelo
    @PostMapping
    public Modelo criarModelo(@RequestBody Modelo modelo) {
        return modeloService.criarModelo(modelo);
    }

    // Atualizar um modelo existente
    @PutMapping("/{id}")
    public Modelo atualizarModelo(@PathVariable Long id, @RequestBody Modelo modeloAtualizado) {
        return modeloService.atualizarModelo(id, modeloAtualizado);
    }

    // Excluir um modelo pelo ID
    @DeleteMapping("/{id}")
    public void excluirModelo(@PathVariable Long id) {
        modeloService.excluirModelo(id);
    }



    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Modelo inserir(@RequestBody Modelo modelo) {
        //return produtoRepository.save(produto); //essa instrução grava o produto e retorno o novo objeto, porém sem os detalhes da categoria
        modelo = modeloRepository.save(modelo);
        Optional<Modelo> categoria = modeloRepository.findById(modelo.getMarca().getId());
        modelo.setMarca(marca.get());
        return modelo;
    }


}

