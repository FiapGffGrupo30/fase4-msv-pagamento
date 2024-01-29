package br.fiap.gff.payments.domain.payments;

import br.fiap.gff.payments.domain.payments.dto.PaymentRequest;
import br.fiap.gff.payments.domain.receipts.Receipt;

public interface PaymentUseCase {
    Receipt pay(PaymentRequest request);
}
