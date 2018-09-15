package br.edu.infnet.sistema.avaliacao.enuns;

public enum Categoria {

    AVALIACAO_GERAL_POS_GRADUACAO(0, "Avalição Geral da Pós-Graduação"), 
    AVALIACAO_PROFESSOR_MODULO(1, "Avaliação do Professor do Módulo"), 
    AVALIACAO_CONTEUDO_INFRA_ESTRUTUTA_MODULO(2, "Avaliação de Conteúdo e Infra-Estrutura no Módulo");
    
    public int id;
    public String value;

    Categoria(int id, String value) {
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return id;
    }
    
}
