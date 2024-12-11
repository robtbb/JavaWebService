package com.sistemawebcar.controller;

import com.sistemawebcar.domain.Marca;
import com.sistemawebcar.repository.MarcaRepository;
import com.sistemawebcar.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marcas")
public class MarcaController {

    @Autowired
    private MarcaService marcaService;
    @Autowired
    private MarcaRepository marcaRepository;


    // **********************************************
    //  ******* Listar todos as marcas **************
    //*********************************************
    @GetMapping
    public List<Marca> listarMarcas() {
        return marcaService.listarMarcas();
    }



    // **************************************************************
    // *********** Listar uma marca específica pelo ID ******************
    // **************************************************************
    @GetMapping("/{id}")
    public Marca obterMarca(@PathVariable Long id) {
        return marcaService.obterMarca(id);
    }



    // ************************************
    // ***** Criar uma nova marca *********
    // ************************************
    @PostMapping(
            value = "/nova_marca",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Marca criarMarca(@RequestBody Marca marca) {
        // Salva a marca no banco de dados usando marcaRepository
        return marcaRepository.save(marca);
    }


    // ************************************************************
    //  ***** Atualizar uma marca existente  *************
    //  **************************************************
    @PutMapping("/{id}")
    public Marca atualizarMarca(@PathVariable Long id, @RequestBody Marca marcaAtualizada) {
        return marcaService.atualizarMarca(id, marcaAtualizada);
    }


    // ****************************************
    // **** Excluir uma marca pelo ID ****************
    // *****************************************
    @DeleteMapping("/{id}")
    public void excluirMarca(@PathVariable Long id) {
        marcaService.excluirMarca(id);
    }
}

/* requisições
  ** para criar um modelo
  * http://localhost:8080/api/marcas/nova_marca
  * {
  *   "nome" : "nova Marca"
  * }
  *
  *
  * para listar todas ir no navegador e por
  * localhost:8080/api/marcas
  *
  *
  * para buscar uma marca pelo is
  * http://localhost:8080/api/marcas/1
  *
  * para atualizar a marca
  * http://localhost:8080/api/marcas/1
  *
  * corpo do json
  *
  * {
    "nome": "Nova Marca Atualizada"
}
* vale lembrara que o metodo é PUT
*
*
*
*
 */
