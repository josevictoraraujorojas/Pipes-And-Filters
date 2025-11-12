package org.example.Arquitetura;

import org.example.filtros.Filtro;

/**
 * Classe Tubo — Representa a conexão (pipe) entre dois filtros.
 *
 * Esta classe implementa o padrão de arquitetura Pipe and Filters.
 * Um "Tubo" é responsável por conectar a saída de um filtro à entrada do próximo,
 * permitindo o encadeamento de operações independentes sobre um mesmo fluxo de dados.
 *
 * Generics:
 *  - I: Tipo de entrada do primeiro filtro
 *  - O: Tipo de saída do primeiro filtro (e entrada do segundo)
 *  - P: Tipo de saída final do segundo filtro
 */
public class Tubo<I, O, P> implements Filtro<I, P> {

    // Filtro que será executado primeiro no fluxo (etapa atual)
    private Filtro<I, O> atual;

    // Filtro que será executado logo após o primeiro (etapa seguinte)
    private Filtro<O, P> proximo;

    /**
     * Construtor do Tubo.
     * Recebe dois filtros — o filtro atual e o próximo — e cria a conexão entre eles.
     *
     * @param atual   Filtro que processa primeiro
     * @param proximo Filtro que processa em seguida
     */
    public Tubo(Filtro<I, O> atual, Filtro<O, P> proximo) {
        this.atual = atual;
        this.proximo = proximo;
    }

    /**
     * Método processar — executa o fluxo entre os dois filtros conectados.
     *
     * Passos:
     * 1. O dado de entrada é enviado ao filtro atual.
     * 2. O resultado intermediário é verificado.
     * 3. Se o resultado for válido (não nulo), ele é passado ao próximo filtro.
     * 4. Caso contrário, o fluxo é interrompido (retorna null).
     *
     * @param entrada Dados de entrada que serão processados.
     * @return Resultado final após passar pelos dois filtros, ou null se algum filtro barrar o fluxo.
     */
    @Override
    public P processar(I entrada) {
        // Primeiro filtro processa a entrada e produz um resultado intermediário.
        O resultadoIntermediario = atual.processar(entrada);

        // Se o resultado não for nulo, passa adiante para o próximo filtro.
        // Caso seja nulo, o fluxo é interrompido (por exemplo, uma oferta inválida é descartada).
        return (resultadoIntermediario != null)
                ? proximo.processar(resultadoIntermediario)
                : null;
    }
}
