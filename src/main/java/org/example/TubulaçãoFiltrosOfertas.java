package org.example;


import org.example.Arquitetura.Tubo;
import org.example.filtros.*;
import org.example.modelos.Categoria;
import org.example.modelos.Oferta;
import org.example.modelos.Usuario;

public class TubulaçãoFiltrosOfertas {
    public static void main(String[] args) {
        // Usuário configurado
        Usuario usuario = new Usuario();
        usuario.setNome("Ana");
        usuario.setCategoriaPreferida(Categoria.ELETRONICOS);
        usuario.setDeficienciaVisual(true);
        usuario.setCanalPreferido("voz");

        // Oferta recebida
        Oferta oferta = new Oferta();
        oferta.setLoja("TechStore");
        oferta.setProduto("Fone Bluetooth sem fio");
        oferta.setPreco(79.90);
        oferta.setDesconto(0.5);
        oferta.setCategoria(Categoria.ELETRONICOS);

        // Criação dos filtros
        Filtro<Oferta, Oferta> validacao = new FiltroValidacao();
        Filtro<Oferta, Oferta> relevancia = new FiltroRelevancia();
        Filtro<Oferta, Oferta> perfil = new FiltroPerfil(usuario);
        Filtro<Oferta, Oferta> acessibilidade = new FiltroAcessibilidade(usuario);
        Filtro<Oferta, Oferta> canal = new FiltroCanal(usuario);

        // Encadeamento com tubos
        Tubo<Oferta, Oferta, Oferta> t1 = new Tubo<>(validacao, relevancia);
        Tubo<Oferta, Oferta, Oferta> t2 = new Tubo<>(t1, perfil);
        Tubo<Oferta, Oferta, Oferta> t3 = new Tubo<>(t2, acessibilidade);
        Tubo<Oferta, Oferta, Oferta> t4 = new Tubo<>(t3, canal);

        // Execução do fluxo
        Oferta resultado = t4.processar(oferta);

        if (resultado != null) {
            System.out.println(resultado);
        } else {
            System.out.println("\nNenhuma oferta enviada.");
        }
    }
}


