package com.cambio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/moeda")
public class MoedaController {

    @Autowired
    private MoedaService moedaService;

    // a) API de conversão de moeda
    @GetMapping("/converter_moeda/{quantia}/{tipoMoeda}/{tipoOperacao}")
    public double converterMoeda(@PathVariable double quantia,
                                 @PathVariable String tipoMoeda,
                                 @PathVariable String tipoOperacao) {
        return moedaService.converter(quantia, tipoMoeda, tipoOperacao);
    }

    // b) API para conversão em todas as moedas
    @GetMapping("/converter_moeda/{quantia}/{tipoOperacao}")
    public List<MoedaDTO> converterParaTodasAsMoedas(@PathVariable double quantia,
                                                     @PathVariable String tipoOperacao) {
        return moedaService.converterParaTodasMoedas(quantia, tipoOperacao);
    }

    // c) API para retornar as cotações de moedas
    @GetMapping("/cotacao_moeda")
    public List<MoedaDTO> cotacaoMoeda() {
        return moedaService.getCotacoes();
    }
}
