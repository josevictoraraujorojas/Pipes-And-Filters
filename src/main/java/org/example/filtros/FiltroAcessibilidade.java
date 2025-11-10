package org.example.filtros;

import org.example.modelos.Oferta;
import org.example.modelos.Usuario;

public class FiltroAcessibilidade implements Filtro<Oferta, Oferta> {
    private Usuario usuario;

    public FiltroAcessibilidade(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public Oferta processar(Oferta entrada) {
        if (entrada == null) return null;

        if (usuario.isDeficienciaVisual()) {
            entrada.setDescricao("[Versão descritiva de áudio] " + entrada.getProduto() +
                    " está em promoção por R$ " + entrada.getPrecoDesconto());
        } else {
            entrada.setDescricao("Oferta: " + entrada.getProduto() +
                    " por R$ " + entrada.getPreco());
        }

        entrada.setAcessivel(true);
        return entrada;
    }
}

