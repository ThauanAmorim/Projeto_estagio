package tech.klok.kear.hub.domain.adesao.model.enums;

public enum AdesaoEnum {
    ATIVO(0), FINALIZADA(1);
    int id;

    private AdesaoEnum(int id) {
            this.id = id;
    }

    public int getId() {
        return id;
    }
}
