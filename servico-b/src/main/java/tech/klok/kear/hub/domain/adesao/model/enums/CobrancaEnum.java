package tech.klok.kear.hub.domain.adesao.model.enums;

public enum CobrancaEnum {
    PENDENTE(0), PAGA(1);
    int id;

    private CobrancaEnum(int id) {
            this.id = id;
    }

    public int getId() {
        return id;
    }
}
