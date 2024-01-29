package br.fiap.gff.payments.domain.receipts.exceptions;

import br.fiap.gff.payments.shared.exceptions.BusinessException;

public class ReceiptNotFoundException extends BusinessException {

    public ReceiptNotFoundException(String errorMessage) {
        super(errorMessage);
    }

}
