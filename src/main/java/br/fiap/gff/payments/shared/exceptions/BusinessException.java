package br.fiap.gff.payments.shared.exceptions;

public class BusinessException extends RuntimeException {
    public BusinessException(String errorMessage) {
        super(errorMessage);
    }
}
