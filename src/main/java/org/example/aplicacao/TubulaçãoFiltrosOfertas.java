package org.example.aplicacao;

import org.example.Arquitetura.Tubo;
import org.example.filtros.*;
import org.example.modelos.Categoria;
import org.example.modelos.Oferta;
import org.example.modelos.Usuario;

public class TubulaçãoFiltrosOfertas {
    public static void main(String[] args) {

        // ==========================
        // Configuração do Usuário
        // ==========================
        // Cria um objeto Usuario que representa a pessoa que receberá as notificações
        Usuario usuario = new Usuario();
        usuario.setNome("Ana"); // Define o nome do usuário
        usuario.setCategoriaPreferida(Categoria.ELETRONICOS); // Define categoria de interesse
        usuario.setDeficienciaVisual(true); // Indica que o usuário tem deficiência visual
        usuario.setCanalPreferido("voz"); // Define o canal preferido de notificação (voz)

        // ==========================
        // Criação da Oferta
        // ==========================
        // Cria uma nova oferta recebida do sistema
        Oferta oferta = new Oferta();
        oferta.setLoja("TechStore"); // Nome da loja que enviou a oferta
        oferta.setProduto("Fone Bluetooth sem fio"); // Produto ofertado
        oferta.setPreco(79.90); // Preço atual da oferta
        oferta.setDesconto(0.5); // Percentual de desconto (50%)
        oferta.setCategoria(Categoria.ELETRONICOS); // Categoria do produto

        // ==========================
        // Definição dos Filtros
        // ==========================
        // Cada filtro representa uma etapa independente do processamento
        // seguindo o padrão Pipe and Filters.
        // O tipo genérico Filtro<Entrada, Saída> é usado para encadear o fluxo.
        Filtro<Oferta, Oferta> validacao = new FiltroValidacao(); // Verifica se a oferta é válida (campos preenchidos, preço positivo etc.)
        Filtro<Oferta, Oferta> relevancia = new FiltroRelevancia(); // Avalia se a oferta tem relevância (ex: bom desconto)
        Filtro<Oferta, Oferta> perfil = new FiltroPerfil(usuario); // Verifica se a oferta combina com o perfil do usuário
        Filtro<Oferta, Oferta> acessibilidade = new FiltroAcessibilidade(usuario); // Adapta o conteúdo conforme necessidades de acessibilidade (voz, texto, etc.)
        Filtro<Oferta, Oferta> canal = new FiltroCanal(usuario); // Define o canal final de entrega (voz, texto, notificação visual, etc.)

        // ==========================
        // Encadeamento dos Filtros com Tubos
        // ==========================
        // Aqui é feita a montagem da "tubulação" (pipeline).
        // Cada Tubo conecta a saída de um filtro à entrada do próximo.
        // Assim, a saída de 'validacao' vai para 'relevancia', depois 'perfil', e assim por diante.
        Tubo<Oferta, Oferta, Oferta> t1 = new Tubo<>(validacao, relevancia);
        Tubo<Oferta, Oferta, Oferta> t2 = new Tubo<>(t1, perfil);
        Tubo<Oferta, Oferta, Oferta> t3 = new Tubo<>(t2, acessibilidade);
        Tubo<Oferta, Oferta, Oferta> t4 = new Tubo<>(t3, canal);

        // ==========================
        // Execução do Fluxo (Pipeline)
        // ==========================
        // O método processar(oferta) percorre toda a tubulação,
        // passando a oferta por cada filtro em sequência.
        Oferta resultado = t4.processar(oferta);

        // ==========================
        // Saída Final
        // ==========================
        // Se a oferta passou por todos os filtros, ela é exibida.
        // Caso contrário, significa que algum filtro bloqueou o envio.
        if (resultado != null) {
            System.out.println(resultado); // Exibe a oferta final processada
        } else {
            System.out.println("\nNenhuma oferta enviada."); // Indica que a oferta foi descartada no fluxo
        }
    }
}
