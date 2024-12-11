package com.sistemawebcar.controller;


import com.sistemawebcar.domain.Modelo;
import com.sistemawebcar.repository.MarcaRepository;
import com.sistemawebcar.repository.ModeloRepository;
import com.sistemawebcar.service.ModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    // ****************************************************************
    // ***** Listar todos os modelos com suas marcas associadas *******
    //****************************************************************
    @GetMapping
    public List<Modelo> listarModelos() {
        return modeloService.listarModelos();
    }


    // ***************************************************************
    //  **** Listar um modelo específico pelo ID *****************
    // ************************************************************
    @GetMapping("/{id}")
    public Modelo obterModelo(@PathVariable Long id) {
        return modeloService.obterModelo(id);
    }

    //***********************************************
    // ******* Criar um novo modelo **********************
    // **********************************************
    @PostMapping
    public Modelo criarModelo(@RequestBody Modelo modelo) {
        return modeloService.criarModelo(modelo);
    }

    // *****************************************
    // ***** Atualizar um modelo existente *******
    // *****************************************
    @PutMapping("/{id}")
    public ResponseEntity<Modelo> atualizarModelo(@PathVariable Long id, @RequestBody Modelo modeloAtualizado) {
        Modelo modelo = modeloService.atualizarModelo(id, modeloAtualizado);
        if (modelo == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(modelo);
    }

    // ***********************************
    // ** Excluir um modelo pelo ID ***
    // *************************************
    @DeleteMapping("/{id}")
    public void excluirModelo(@PathVariable Long id) {
        modeloService.excluirModelo(id);
    }

}

/*

aqui instruções para requisições
para criar
url: localhost:8080/api/modelos
corpo do json:
{
  "descricao": "jegue",
  "marca": {
    "id": 1  // ID da marca que você criou
  },
  "ecategoria": "PADRAO",
  "motor": {
    "potencia": 2000  // Passando a potência do motor
  }
}


para listar:
url localhost:8080/api/modelos

para listar por id


************************************
**** para atualizar o modelo *******
************************************

url:
http://localhost:8080/api/modelos/2


copo json
{
  "descricao": "Novo modelo atualizado",
  "marca": {
    "id": 1
  }
}

 */

