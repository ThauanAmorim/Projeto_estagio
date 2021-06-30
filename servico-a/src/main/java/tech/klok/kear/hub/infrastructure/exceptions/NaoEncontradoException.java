package tech.klok.kear.hub.infrastructure.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NaoEncontradoException extends Exception {
    public NaoEncontradoException(String msg) {
        super(msg);
    }
}
