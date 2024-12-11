package br.edu.ifsc.fln.Controller;


import br.edu.ifsc.fln.domain.Modelo;
import br.edu.ifsc.fln.services.ModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/modelos")
public class ModeloController {

    @Autowired
    private ModeloService modeloService;

    @GetMapping
    public List<Modelo> listarTodos() {
        return modeloService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Modelo> listarPorId(@PathVariable Long id) {
        Modelo modelo = modeloService.buscarPorId(id);
        return ResponseEntity.ok(modelo);
    }

    @PostMapping
    public ResponseEntity<Modelo> criarModelo(@RequestBody Modelo modelo) {
        Modelo novoModelo = modeloService.salvar(modelo);
        return ResponseEntity.status(201).body(novoModelo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Modelo> atualizarModelo(@PathVariable Long id, @RequestBody Modelo modelo) {
        Modelo modeloAtualizado = modeloService.atualizar(id, modelo);
        return ResponseEntity.ok(modeloAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirModelo(@PathVariable Long id) {
        modeloService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}

