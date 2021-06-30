package tech.klok.kear.hub.domain.adesao.model.enums;

public enum Genero {
        MASCULINO(0), FEMININO(1);

        int id;

        private Genero(int id) {
                this.id = id;
        }

        public int getId() {
                return id;
        }
}
