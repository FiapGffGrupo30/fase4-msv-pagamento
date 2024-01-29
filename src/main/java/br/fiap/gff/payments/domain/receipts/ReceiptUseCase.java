package br.fiap.gff.payments.domain.receipts;

import java.util.List;

import br.fiap.gff.payments.domain.payments.dto.PaymentRequest;

public interface ReceiptUseCase {
    Receipt create(PaymentRequest request);

    Receipt save(Receipt receipt);

    Receipt getById(String id);

    List<Receipt> getByCustomerId(Long customerId);
}
