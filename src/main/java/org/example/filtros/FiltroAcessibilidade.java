package org.example.filtros;

import org.example.modelos.Oferta;
import org.example.modelos.Usuario;

/**
 * FiltroAcessibilidade — Implementa o filtro responsável por adaptar
 * o conteúdo da oferta às necessidades de acessibilidade do usuário.
 *
 * Parte integrante da arquitetura Pipe and Filters, este filtro garante
 * que usuários com deficiência visual recebam as informações da oferta
 * em um formato mais adequado, como uma descrição voltada à leitura por voz.
 */
public class FiltroAcessibilidade implements Filtro<Oferta, Oferta> {

    // Referência ao usuário para verificar suas preferências e necessidades
    private Usuario usuario;

    /**
     * Construtor que recebe o usuário.
     * Isso permite que o filtro acesse informações sobre acessibilidade
     * (como deficiência visual ou auditiva).
     *
     * @param usuario Usuário que receberá a notificação personalizada
     */
    public FiltroAcessibilidade(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Método processar — aplica as transformações de acessibilidade à oferta.
     *
     * Etapas:
     * 1. Verifica se a entrada (oferta) é nula — caso seja, o fluxo é interrompido.
     * 2. Se o usuário tiver deficiência visual, o filtro gera uma versão
     *    descritiva em texto para ser lida por um sistema de voz.
     * 3. Caso contrário, cria uma descrição textual simples da oferta.
     * 4. Marca a oferta como "acessível" e retorna o resultado.
     *
     * @param entrada Oferta recebida do filtro anterior.
     * @return A oferta adaptada para acessibilidade, ou null se o fluxo for interrompido.
     */
    @Override
    public Oferta processar(Oferta entrada) {
        // Interrompe o fluxo se não houver oferta (proteção contra null)
        if (entrada == null) return null;

        // Caso o usuário possua deficiência visual,
        // cria uma descrição mais detalhada e apropriada para leitura por voz
        if (usuario.isDeficienciaVisual()) {
            entrada.setDescricao("[Versão descritiva de áudio] " + entrada.getProduto() +
                    " está em promoção por R$ " + entrada.getPrecoDesconto());
        }
        // Caso o usuário não possua deficiência visual, usa uma descrição padrão
        else {
            entrada.setDescricao("Oferta: " + entrada.getProduto() +
                    " por R$ " + entrada.getPreco());
        }

        // Marca que a oferta passou pelo filtro de acessibilidade
        entrada.setAcessivel(true);

        // Retorna a oferta processada para o próximo filtro do pipeline
        return entrada;
    }
}
