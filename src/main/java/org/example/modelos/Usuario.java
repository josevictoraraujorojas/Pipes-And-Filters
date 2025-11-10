package org.example.modelos;

public class Usuario {
    private String nome;
    private int idade;
    private Categoria categoriaPreferida;
    private boolean deficienciaVisual;
    private String canalPreferido;  // "voz", "email", "push"

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }

    public Categoria getCategoriaPreferida() { return categoriaPreferida; }
    public void setCategoriaPreferida(Categoria categoriaPreferida) {
        this.categoriaPreferida = categoriaPreferida;
    }

    public boolean isDeficienciaVisual() { return deficienciaVisual; }
    public void setDeficienciaVisual(boolean deficienciaVisual) {
        this.deficienciaVisual = deficienciaVisual;
    }

    public String getCanalPreferido() { return canalPreferido; }
    public void setCanalPreferido(String canalPreferido) {
        this.canalPreferido = canalPreferido;
    }
}


