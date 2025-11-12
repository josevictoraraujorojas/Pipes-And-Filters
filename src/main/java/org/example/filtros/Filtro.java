package org.example.filtros;

/**
 * Interface Filtro — Define o contrato básico para todos os filtros
 * da arquitetura Pipe and Filters.
 *
 * O padrão Pipe and Filters é baseado na ideia de dividir o processamento
 * em etapas independentes (filtros), conectadas por tubos (pipes).
 *
 * Cada filtro:
 *  - Recebe uma entrada de um tipo genérico (I)
 *  - Processa essa entrada de forma isolada
 *  - Retorna uma saída (O), que pode ser passada para o próximo filtro no fluxo
 *
 * @param <I> Tipo de dado recebido como entrada
 * @param <O> Tipo de dado retornado após o processamento
 */
public interface Filtro<I, O> {

    /**
     * Método processar — executa a lógica principal do filtro.
     *
     * Cada implementação define sua própria transformação sobre o dado.
     * O método pode retornar null se o filtro decidir interromper o fluxo
     * (por exemplo, quando a entrada não é válida ou não atende aos critérios).
     *
     * @param entrada Dado de entrada recebido pelo filtro
     * @return Resultado do processamento (ou null se o fluxo for interrompido)
     */
    O processar(I entrada);
}
