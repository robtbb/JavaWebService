package br.edu.ifsc.fln.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsc.fln.domain.Marca;
import br.edu.ifsc.fln.services.MarcaService;

@RestController
@RequestMapping("/marcas")
public class MarcaController {
	
    @Autowired
    private MarcaService service;

    @GetMapping
    public List<Marca> listarTodas() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public Marca buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Marca novaMarca(@RequestBody Marca marca) {
        return service.salvar(marca);
    }

    @PutMapping("/{id}")
    public Marca atualizar(@PathVariable Integer id, @RequestBody Marca novaMarca) {
        return service.atualizar(id, novaMarca);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Integer id) {
        service.excluir(id);
    }
}

