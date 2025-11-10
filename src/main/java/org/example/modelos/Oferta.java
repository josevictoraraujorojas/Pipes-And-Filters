package org.example.modelos;

public class Oferta {
    private String loja;
    private String produto;
    private double preco;
    private double desconto;
    private double precoDesconto;
    private boolean valida;
    private boolean relevante;
    private Categoria categoria;
    private String descricao;
    private String canalEnvio;
    private boolean acessivel;

    // Getters e Setters
    public String getLoja() { return loja; }
    public void setLoja(String loja) { this.loja = loja; }

    public String getProduto() { return produto; }
    public void setProduto(String produto) { this.produto = produto; }

    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }

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

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public double getPrecoDesconto() {
        return precoDesconto;
    }

    public void setPrecoDesconto(double precoDesconto) {
        this.precoDesconto = precoDesconto;
    }

    @Override
    public String toString() {
        return "Oferta{ loja:" + loja  +
                ", \nproduto: " + produto  +
                ", \npreco: " + preco +
                ", \ndesconto: " + desconto +
                ", \nprecoDesconto: " + precoDesconto +
                ", \nvalida: " + valida +
                ", \nrelevante: " + relevante +
                ", \ncategoria: " + categoria +
                ", \ndescricao: " + descricao  +
                ", \ncanalEnvio: " + canalEnvio  +
                ", \nacessivel: " + acessivel + "} ";
    }
}

