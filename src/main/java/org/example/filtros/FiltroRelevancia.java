package org.example.filtros;

import org.example.modelos.Oferta;

/**
 * FiltroRelevancia — Responsável por analisar se uma oferta
 * é suficientemente atrativa para o usuário, com base no desconto.
 *
 * Este filtro faz parte da arquitetura Pipe and Filters e atua
 * como um ponto de decisão: apenas ofertas consideradas relevantes
 * continuam no fluxo. As demais são descartadas, otimizando o sistema.
 */
public class FiltroRelevancia implements Filtro<Oferta, Oferta> {

    /**
     * Método processar — avalia a relevância da oferta.
     *
     * Etapas:
     * 1. Verifica se a entrada é nula. Caso seja, interrompe o fluxo.
     * 2. Analisa o percentual de desconto:
     *    - Se for igual ou superior a 50% (0.5), a oferta é marcada como relevante.
     *    - O preço com desconto é calculado e armazenado.
     * 3. Caso contrário, a oferta é considerada pouco relevante e descartada.
     * 4. Retorna a oferta apenas se for relevante; do contrário, retorna null.
     *
     * @param entrada A oferta recebida do filtro anterior (já validada)
     * @return A oferta marcada como relevante, ou null se não for interessante
     */
    @Override
    public Oferta processar(Oferta entrada) {
        // Se não há oferta, encerra o fluxo
        if (entrada == null) return null;

        // Verifica o percentual de desconto da oferta
        if (entrada.getDesconto() >= 0.5) {
            // Oferta considerada relevante
            entrada.setRelevante(true);

            // Calcula o preço com desconto aplicado
            entrada.setPrecoDesconto(entrada.getPreco() * entrada.getDesconto());
        } else {
            // Oferta tem desconto pequeno — não será enviada ao usuário
            System.out.println("Oferta considerada pouco relevante.");
            entrada.setRelevante(false);
        }

        // Só retorna a oferta se ela for relevante, senão o fluxo é interrompido
        return entrada.isRelevante() ? entrada : null;
    }
}
