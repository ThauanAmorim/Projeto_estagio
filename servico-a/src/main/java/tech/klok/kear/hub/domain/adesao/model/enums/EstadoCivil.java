package tech.klok.kear.hub.domain.adesao.model.enums;

public enum EstadoCivil {
    SOLTEIRO(0), CASADO(1), SEPARADO(2), DIVORCIADO(3), VIUVO(4);
    
    int id;

    private EstadoCivil(int id) {
            this.id = id;
    }

    public int getId() {
        return id;
    }
}
