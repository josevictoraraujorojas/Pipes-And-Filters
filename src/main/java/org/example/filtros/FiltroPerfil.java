package org.example.filtros;

import org.example.modelos.Oferta;
import org.example.modelos.Usuario;

/**
 * FiltroPerfil — Responsável por verificar se a oferta
 * é relevante para o perfil e os interesses do usuário.
 *
 * Este filtro atua como uma etapa de "personalização" dentro
 * do fluxo Pipe and Filters, garantindo que apenas ofertas
 * que combinem com as preferências do usuário sejam encaminhadas
 * para as próximas etapas (como acessibilidade e canal de envio).
 */
public class FiltroPerfil implements Filtro<Oferta, Oferta> {

    // Armazena os dados e preferências do usuário
    private Usuario usuario;

    /**
     * Construtor do filtro.
     * Recebe o usuário que está sendo considerado para personalização.
     *
     * @param usuario Usuário com informações de interesse e perfil
     */
    public FiltroPerfil(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Método processar — avalia se a oferta é compatível com o perfil do usuário.
     *
     * Etapas:
     * 1. Verifica se a entrada (oferta) é nula — caso seja, o fluxo é interrompido.
     * 2. Compara a categoria da oferta com a categoria preferida do usuário.
     * 3. Se não corresponder, exibe uma mensagem e interrompe o fluxo (retorna null).
     * 4. Caso corresponda, a oferta segue adiante no pipeline.
     *
     * @param entrada Oferta recebida do filtro anterior (já validada e relevante)
     * @return A mesma oferta se for compatível com o perfil, ou null se for descartada
     */
    @Override
    public Oferta processar(Oferta entrada) {
        // Interrompe o fluxo caso a oferta seja nula
        if (entrada == null) return null;

        // Verifica se a categoria da oferta é igual à preferência do usuário
        if (entrada.getCategoria() != usuario.getCategoriaPreferida()) {
            System.out.println("Oferta não corresponde ao interesse do usuário.");
            // Retorna null para interromper o fluxo — ou seja,
            // esta oferta não será encaminhada para os próximos filtros
            return null;
        }

        // Caso a categoria corresponda ao perfil, a oferta segue adiante
        return entrada;
    }
}
