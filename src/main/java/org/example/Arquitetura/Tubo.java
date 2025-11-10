package org.example.Arquitetura;

import org.example.filtros.Filtro;

public class Tubo<I, O, P> implements Filtro<I, P> {

    private Filtro<I, O> atual;
    private Filtro<O, P> proximo;

    public Tubo(Filtro<I, O> atual, Filtro<O, P> proximo) {
        this.atual = atual;
        this.proximo = proximo;
    }

    @Override
    public P processar(I entrada) {
        O resultadoIntermediario = atual.processar(entrada);
        return (resultadoIntermediario != null)
                ? proximo.processar(resultadoIntermediario)
                : null;
    }
}
