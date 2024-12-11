package br.edu.ifsc.fln.Controller;


import br.edu.ifsc.fln.domain.Modelo;
import br.edu.ifsc.fln.services.ModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/modelos")
public class ModeloController {

    @Autowired
    private ModeloService modeloService;

    // Listar todos os Modelos com a Marca
    @GetMapping
    public List<Modelo> listarTodos() {
        return modeloService.listarTodos();
    }

    // Listar um Modelo por ID
    @GetMapping("/{id}")
    public ResponseEntity<Modelo> listarPorId(@PathVariable Long id) {
        Modelo modelo = modeloService.buscarPorId(id);
        return ResponseEntity.ok(modelo);
    }

    // Criar um Novo Modelo
    @PostMapping
    public ResponseEntity<Modelo> criarModelo(@RequestBody Modelo modelo) {
        Modelo novoModelo = modeloService.salvar(modelo);
        return ResponseEntity.status(201).body(novoModelo);
    }

    // Atualizar um Modelo existente
    @PutMapping("/{id}")
    public ResponseEntity<Modelo> atualizarModelo(@PathVariable Long id, @RequestBody Modelo modelo) {
        Modelo modeloAtualizado = modeloService.atualizar(id, modelo);
        return ResponseEntity.ok(modeloAtualizado);
    }

    // Excluir um Modelo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirModelo(@PathVariable Long id) {
        modeloService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}

