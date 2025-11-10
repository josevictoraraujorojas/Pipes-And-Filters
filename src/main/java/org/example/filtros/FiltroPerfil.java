package org.example.filtros;

import org.example.modelos.Oferta;
import org.example.modelos.Usuario;

public class FiltroPerfil implements Filtro<Oferta, Oferta> {
    private Usuario usuario;

    public FiltroPerfil(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public Oferta processar(Oferta entrada) {
        if (entrada == null) return null;

        if (entrada.getCategoria() != usuario.getCategoriaPreferida()) {
            System.out.println("Oferta não corresponde ao interesse do usuário.");
            return null;
        }
        return entrada;
    }
}

