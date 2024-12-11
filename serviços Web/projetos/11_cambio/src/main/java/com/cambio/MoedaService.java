package com.cambio;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MoedaService {

    // Mapas para armazenar as cotações de compra e venda de diferentes moedas.
    private final Map<String, Double> cotacoesCompra = new HashMap<>();
    private final Map<String, Double> cotacoesVenda = new HashMap<>();

    // Construtor da classe MoedaService, responsável por inicializar as cotações
    public MoedaService() {
        // Inicializa as cotações de compra com valores específicos para cada tipo de moeda
        cotacoesCompra.put("DC", 5.6061); // Dólar Comercial
        cotacoesCompra.put("DP", 5.69);   // Dólar Ptax
        cotacoesCompra.put("DX", 5.6058); // Dólar Turismo
        cotacoesCompra.put("DT", 5.5430); // Dólar Turismo Ptax
        cotacoesCompra.put("EU", 6.5630); // Euro
        cotacoesCompra.put("OU", 346.70); // Ouro

        // Inicializa as cotações de venda, incluindo um ajuste de 1.88% na cotação de ouro
        cotacoesVenda.put("DC", 5.6066);
        cotacoesVenda.put("DP", 5.79);
        cotacoesVenda.put("DX", 5.6064);
        cotacoesVenda.put("DT", 5.7530);
        cotacoesVenda.put("EU", 6.8070);
        cotacoesVenda.put("OU", 346.70 * 1.0188); // Inclui um aumento de 1,88%
    }

    // Método para converter uma quantia para o valor de compra ou venda de uma moeda específica
    public double converter(double quantia, String tipoMoeda, String tipoOperacao) {
        // Se a operação for "compra", converte dividindo a quantia pelo valor de compra
        if ("compra".equalsIgnoreCase(tipoOperacao)) {
            return quantia / cotacoesCompra.get(tipoMoeda);
        } else {
            // Caso contrário, multiplica a quantia pelo valor de venda
            return quantia * cotacoesVenda.get(tipoMoeda);
        }
    }

    // Método para converter uma quantia para todas as moedas, baseando-se no tipo de operação (compra ou venda)
    public List<MoedaDTO> converterParaTodasMoedas(double quantia, String tipoOperacao) {
        List<MoedaDTO> resultados = new ArrayList<>();

        // Para cada moeda, realiza a conversão e armazena o resultado em uma lista de MoedaDTO
        for (String moeda : cotacoesCompra.keySet()) {
            double valorConvertido = converter(quantia, moeda, tipoOperacao);
            resultados.add(new MoedaDTO(
                    moeda,
                    "compra".equalsIgnoreCase(tipoOperacao) ? valorConvertido : quantia,
                    "venda".equalsIgnoreCase(tipoOperacao) ? valorConvertido : quantia
            ));
        }

        return resultados;
    }

    // Método para obter todas as cotações de compra e venda em uma lista de MoedaDTO
    public List<MoedaDTO> getCotacoes() {
        List<MoedaDTO> cotacoes = new ArrayList<>();

        // Para cada moeda, cria um MoedaDTO com as cotações de compra e venda e adiciona à lista
        for (String moeda : cotacoesCompra.keySet()) {
            MoedaDTO cotacao = new MoedaDTO(moeda, cotacoesCompra.get(moeda), cotacoesVenda.get(moeda));
            cotacoes.add(cotacao);
        }
        return cotacoes;
    }
}





/*
*************************************************
*****                 Map                   *****
*************************************************
   O `Map` é uma estrutura de dados em Java que armazena
   pares de chave-valor. Em vez de armazenar elementos
   em uma sequência ordenada, como uma lista, ele associa
   cada "chave" a um "valor" correspondente.

    ### Características do `Map`
    1. **Chaves Únicas**: Cada chave em um `Map` deve ser
    única, ou seja, não é possível ter duas chaves iguais.
    Se tentar adicionar um novo par com uma chave já
    existente, o valor anterior será substituído pelo
    novo valor.

    2. **Acesso por Chave**: No `Map`, cada valor é
    acessado por meio de sua chave, tornando-o eficiente
    para buscas quando se conhece a chave. Por exemplo,
    `cotacoesCompra.get("DC")` acessa o valor associado à
    chave `"DC"`.

    3. **Par de Chave-Valor**: Em cada entrada, temos uma
    "chave" que referencia um "valor". No caso do seu código,
    a chave é uma sigla da moeda (ex: `"DC"` para Dólar
    Comercial), e o valor é o valor da cotação (ex: `5.6061`).

    ### Diferença entre `Map` e `List`
    - **`Map`**: Associa cada chave a um valor único e
    permite acesso direto ao valor usando a chave.
    - **`List`**: Armazena elementos em uma ordem sequencial
    e permite acesso pelo índice (posição).

    ### Exemplos do Código
    *
    No seu código, dois `Map` são usados:
    - **`cotacoesCompra`**: Um `Map<String, Double>` onde
    cada chave (como `"DC"`) é associada a um valor de cotação
    de compra (como `5.6061`).
    - **`cotacoesVenda`**: Similarmente, um `Map<String, Double>`
    que armazena as cotações de venda.

    Esses `Map`s permitem buscar rapidamente a cotação de
    compra ou venda de uma moeda específica usando a sua
    chave, o que facilita o processo de conversão de valores.

 * */
