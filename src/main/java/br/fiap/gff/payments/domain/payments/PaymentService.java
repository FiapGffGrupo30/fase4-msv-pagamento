package br.fiap.gff.payments.domain.payments;

import org.springframework.stereotype.Service;

import br.fiap.gff.payments.domain.payments.dto.PaymentRequest;
import br.fiap.gff.payments.domain.receipts.Receipt;
import br.fiap.gff.payments.domain.receipts.ReceiptUseCase;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentService implements PaymentUseCase {
    private final ReceiptUseCase receiptUseCase;

    @Override
    public Receipt pay(PaymentRequest request) {
        return receiptUseCase.create(request);
    }
}
