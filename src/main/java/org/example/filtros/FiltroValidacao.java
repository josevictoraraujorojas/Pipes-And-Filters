package org.example.filtros;

import org.example.modelos.Oferta;

/**
 * FiltroValidacao — Primeiro estágio do pipeline de ofertas.
 *
 * Este filtro verifica se a oferta recebida contém informações
 * essenciais válidas antes que ela prossiga pelos demais filtros.
 *
 * Ele faz parte da arquitetura Pipe and Filters, garantindo que
 * apenas dados consistentes avancem no fluxo, prevenindo erros
 * nas etapas seguintes como análise de relevância, perfil e canal.
 */
public class FiltroValidacao implements Filtro<Oferta, Oferta> {

    /**
     * Método processar — valida os campos obrigatórios de uma oferta.
     *
     * Etapas:
     * 1. Verifica se os atributos essenciais estão presentes e corretos:
     *    - Nome da loja (não pode ser nulo)
     *    - Nome do produto (não pode ser nulo)
     *    - Preço (deve ser maior que zero)
     * 2. Caso algum dado seja inválido, a oferta é descartada e o fluxo é interrompido.
     * 3. Se tudo estiver correto, a oferta é marcada como válida e retornada
     *    para o próximo filtro no pipeline.
     *
     * @param entrada A oferta recebida do fluxo anterior
     * @return A oferta validada ou null se for inválida
     */
    @Override
    public Oferta processar(Oferta entrada) {
        // Verifica se há dados ausentes ou inconsistentes
        if (entrada.getLoja() == null || entrada.getProduto() == null || entrada.getPreco() <= 0) {
            System.out.println("Oferta inválida descartada.");
            return null; // Interrompe o fluxo — oferta não será processada adiante
        }

        // Marca a oferta como válida para controle interno
        entrada.setValida(true);

        // Retorna a oferta para o próximo filtro da tubulação
        return entrada;
    }
}
