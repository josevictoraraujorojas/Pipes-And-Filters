package org.example.filtros;

import org.example.modelos.Oferta;
import org.example.modelos.Usuario;

/**
 * FiltroCanal — Define o canal de envio da oferta personalizada.
 *
 * Este filtro faz parte da arquitetura Pipe and Filters, sendo responsável
 * por ajustar a forma como a notificação será entregue ao usuário,
 * de acordo com suas preferências (por exemplo: voz, texto, vibração, etc.).
 *
 * Ele normalmente é o último filtro do pipeline, finalizando a preparação
 * da oferta antes do envio ao usuário.
 */
public class FiltroCanal implements Filtro<Oferta, Oferta> {

    // Armazena as preferências e dados do usuário
    private Usuario usuario;

    /**
     * Construtor do filtro, que recebe o usuário.
     * O filtro precisa saber qual canal o usuário prefere para adaptar a entrega.
     *
     * @param usuario Usuário que receberá a notificação personalizada
     */
    public FiltroCanal(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Método processar — define o canal de envio da oferta.
     *
     * Etapas:
     * 1. Verifica se a oferta recebida é nula. Caso seja, interrompe o fluxo.
     * 2. Atribui o canal de envio conforme a preferência configurada pelo usuário.
     * 3. Retorna a oferta atualizada para o próximo filtro (ou resultado final).
     *
     * Exemplo:
     *  - Se o usuário preferir "voz", a oferta será preparada para ser narrada.
     *  - Se o usuário preferir "texto", será enviada como mensagem visual.
     *
     * @param entrada Oferta recebida do filtro anterior (já adaptada para acessibilidade, por exemplo)
     * @return A mesma oferta com o canal de envio definido, ou null se o fluxo for interrompido
     */
    @Override
    public Oferta processar(Oferta entrada) {
        // Se a entrada for nula, o processamento é encerrado
        if (entrada == null) return null;

        // Define o canal de envio da oferta com base na preferência do usuário
        entrada.setCanalEnvio(usuario.getCanalPreferido());

        // Retorna a oferta ajustada para o canal escolhido
        return entrada;
    }
}
