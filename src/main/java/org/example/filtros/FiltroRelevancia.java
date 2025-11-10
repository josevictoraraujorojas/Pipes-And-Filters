package org.example.filtros;

import org.example.modelos.Oferta;

public class FiltroRelevancia implements Filtro<Oferta, Oferta> {
    @Override
    public Oferta processar(Oferta entrada) {
        if (entrada == null) return null;

        if (entrada.getDesconto() >= 0.5) {
            entrada.setRelevante(true);
            entrada.setPrecoDesconto(entrada.getPreco()*entrada.getDesconto());
        } else {
            System.out.println("Oferta considerada pouco relevante.");
            entrada.setRelevante(false);
        }
        return entrada.isRelevante() ? entrada : null;
    }
}
