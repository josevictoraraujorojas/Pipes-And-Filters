package org.example.filtros;

import org.example.modelos.Oferta;

public class FiltroValidacao implements Filtro<Oferta, Oferta> {
    @Override
    public Oferta processar(Oferta entrada) {
        if (entrada.getLoja() == null || entrada.getProduto() == null || entrada.getPreco() <= 0) {
            System.out.println("Oferta inválida descartada.");
            return null;
        }
        entrada.setValida(true);
        return entrada;
    }
}

