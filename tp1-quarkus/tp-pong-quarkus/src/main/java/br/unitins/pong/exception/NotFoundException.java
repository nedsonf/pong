package br.unitins.pong.exception;

/**
 * Exceção personalizada para quando um recurso não é encontrado (HTTP 404).
 */
public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }
}
