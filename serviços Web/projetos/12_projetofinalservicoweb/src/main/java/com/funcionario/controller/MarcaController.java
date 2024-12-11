package com.funcionario.controller;

import com.funcionario.domain.Marca;
import com.funcionario.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marcas")
public class MarcaController {

    @Autowired
    private MarcaService marcaService;

    // Listar todas as marcas
    @GetMapping
    public List<Marca> listarMarcas() {
        return marcaService.listarMarcas();
    }

    // Listar uma marca específica pelo ID
    @GetMapping("/{id}")
    public Marca obterMarca(@PathVariable Long id) {
        return marcaService.obterMarca(id);
    }

    // Criar uma nova marca
    @PostMapping
    public Marca criarMarca(@RequestBody Marca marca) {
        return marcaService.criarMarca(marca);
    }

    // Atualizar uma marca existente
    @PutMapping("/{id}")
    public Marca atualizarMarca(@PathVariable Long id, @RequestBody Marca marcaAtualizada) {
        return marcaService.atualizarMarca(id, marcaAtualizada);
    }

    // Excluir uma marca pelo ID
    @DeleteMapping("/{id}")
    public void excluirMarca(@PathVariable Long id) {
        marcaService.excluirMarca(id);
    }
}
