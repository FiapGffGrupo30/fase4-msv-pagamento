package br.fiap.gff.payments.domain.payments.exceptions;

import br.fiap.gff.payments.shared.exceptions.BusinessException;

public class PaymentTypeNotSupportedException extends BusinessException {

    public PaymentTypeNotSupportedException(String errorMessage) {
        super(errorMessage);
    }

}
