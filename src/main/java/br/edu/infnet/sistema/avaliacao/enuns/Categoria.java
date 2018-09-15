package br.edu.infnet.sistema.avaliacao.enuns;

public enum Categoria {

    AVALIACAO_GERAL_POS_GRADUACAO(0), AVALIACAO_PROFESSOR_MODULO(1), AVALIACAO_CONTEUDO_INFRA_ESTRUTUTA_MODULO(2);
    
     public int id;

    Categoria(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
}
