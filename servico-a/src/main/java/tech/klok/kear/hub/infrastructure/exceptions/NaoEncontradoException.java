package tech.klok.kear.hub.infrastructure.exceptions;

public class NaoEncontradoException extends Exception {
    public NaoEncontradoException(String msg) {
        super(msg);
    }
    public NaoEncontradoException() {
        super();
    }
}
