package com.funcionario.controller;

import com.funcionario.domain.Modelo;
import com.funcionario.service.ModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/modelos")
public class ModeloController {

    @Autowired
    private ModeloService modeloService;

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
}