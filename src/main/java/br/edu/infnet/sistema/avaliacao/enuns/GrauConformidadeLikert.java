package br.edu.infnet.sistema.avaliacao.enuns;

import java.util.Arrays;
import java.util.Optional;


public enum GrauConformidadeLikert {
    
    CONCORDO_TOTALMENTE(0),
    CONCORDO_PARCIALMENTE(1),
    NAO_CONCORDO_NEM_DISCORDO(2),
    DISCORDO_PARCIALMENTE(3),
    DISCORDO_TOTALMENTE(4),
    SEM_RESPOSTA(5);
    
    public int id;
    
    GrauConformidadeLikert(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
    public static Optional<GrauConformidadeLikert> valueOf(int value) {
        return Arrays.stream(values())
            .filter(grauConformidadeLikert -> grauConformidadeLikert.id == value)
            .findFirst();
    }
}