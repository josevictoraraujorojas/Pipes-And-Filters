package org.example.filtros;

import org.example.modelos.Oferta;
import org.example.modelos.Usuario;

public class FiltroCanal implements Filtro<Oferta, Oferta> {
    private Usuario usuario;

    public FiltroCanal(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public Oferta processar(Oferta entrada) {
        if (entrada == null) return null;

        entrada.setCanalEnvio(usuario.getCanalPreferido());
        return entrada;
    }
}

