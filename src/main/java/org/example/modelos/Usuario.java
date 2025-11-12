package org.example.modelos;

/**
 * Classe Usuario — Representa o perfil de um usuário do sistema.
 *
 * Este modelo é essencial para o funcionamento do pipeline de ofertas,
 * pois suas preferências e características pessoais determinam como
 * as notificações serão filtradas, personalizadas e entregues.
 *
 * Os filtros do pipeline consultam atributos do usuário para decidir:
 *  - Se a oferta é relevante (FiltroPerfil)
 *  - Se precisa de adaptação para acessibilidade (FiltroAcessibilidade)
 *  - Por qual canal deve ser enviada (FiltroCanal)
 */
public class Usuario {

    /** Nome do usuário */
    private String nome;

    /** Idade do usuário — pode ser usada futuramente para segmentação */
    private int idade;

    /** Categoria preferida do usuário  */
    private Categoria categoriaPreferida;

    /** Indica se o usuário possui deficiência visual — ativa recursos de acessibilidade */
    private boolean deficienciaVisual;

    /**
     * Canal preferido para receber notificações:
     *  - "voz"  → saída em formato de áudio ou leitura automatizada
     *  - "email" → envio textual via e-mail
     *  - "push" → notificação instantânea no aplicativo
     */
    private String canalPreferido;

    // ================== Getters e Setters ==================

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
