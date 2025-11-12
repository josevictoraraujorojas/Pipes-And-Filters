package org.example.modelos;

/**
 * Classe Oferta — Modelo de dados que representa uma promoção ou oferta.
 *
 * Essa classe é o "objeto em trânsito" (ou mensagem) que percorre os
 * diferentes filtros da arquitetura Pipe and Filters. Cada filtro
 * transforma ou valida a oferta, enriquecendo-a com novas informações
 * até que ela esteja pronta para ser enviada ao usuário.
 *
 * Filtros que interagem com esta classe:
 *  - FiltroValidacao: verifica dados obrigatórios (loja, produto, preço)
 *  - FiltroRelevancia: avalia o desconto e marca a oferta como relevante
 *  - FiltroPerfil: filtra conforme as preferências do usuário
 *  - FiltroAcessibilidade: adapta a descrição para acessibilidade
 *  - FiltroCanal: define o canal de envio (voz, texto, etc.)
 */
public class Oferta {
    /** Nome da loja que está oferecendo o produto */
    private String loja;

    /** Nome ou título do produto em promoção */
    private String produto;

    /** Preço original do produto antes do desconto */
    private double preco;

    /** Percentual de desconto (ex.: 0.5 = 50%) */
    private double desconto;

    /** Preço final com desconto aplicado */
    private double precoDesconto;

    /** Indica se a oferta passou pela validação inicial */
    private boolean valida;

    /** Indica se a oferta foi considerada relevante (alto desconto, etc.) */
    private boolean relevante;

    /** Categoria da oferta (ex.: ELETRONICOS, ROUPAS, SUPERMERCADO) */
    private Categoria categoria;

    /** Texto descritivo da oferta (pode ser adaptado para acessibilidade) */
    private String descricao;

    /** Canal de envio preferido (ex.: "voz", "texto", "notificação push") */
    private String canalEnvio;

    /** Indica se a oferta foi adaptada para acessibilidade */
    private boolean acessivel;

    // ================== Getters e Setters ==================

    public String getLoja() { return loja; }
    public void setLoja(String loja) { this.loja = loja; }

    public String getProduto() { return produto; }
    public void setProduto(String produto) { this.produto = produto; }

    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }

    public double getDesconto() { return desconto; }
    public void setDesconto(double desconto) { this.desconto = desconto; }

    public double getPrecoDesconto() { return precoDesconto; }
    public void setPrecoDesconto(double precoDesconto) { this.precoDesconto = precoDesconto; }

    public boolean isValida() { return valida; }
    public void setValida(boolean valida) { this.valida = valida; }

    public boolean isRelevante() { return relevante; }
    public void setRelevante(boolean relevante) { this.relevante = relevante; }

    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getCanalEnvio() { return canalEnvio; }
    public void setCanalEnvio(String canalEnvio) { this.canalEnvio = canalEnvio; }

    public boolean isAcessivel() { return acessivel; }
    public void setAcessivel(boolean acessivel) { this.acessivel = acessivel; }

    /**
     * Representação textual da oferta, exibida ao final do pipeline.
     * Mostra todos os campos processados e enriquecidos pelos filtros.
     */
    @Override
    public String toString() {
        return "Oferta{" +
                "\nloja: " + loja +
                ", \nproduto: " + produto +
                ", \npreco: " + preco +
                ", \ndesconto: " + desconto +
                ", \nprecoDesconto: " + precoDesconto +
                ", \nvalida: " + valida +
                ", \nrelevante: " + relevante +
                ", \ncategoria: " + categoria +
                ", \ndescricao: " + descricao +
                ", \ncanalEnvio: " + canalEnvio +
                ", \nacessivel: " + acessivel +
                "\n}";
    }
}
