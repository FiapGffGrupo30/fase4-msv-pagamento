package br.fiap.gff.payments.domain.payments;

import br.fiap.gff.payments.domain.payments.port.PaymentsBrokerPort;
import org.springframework.stereotype.Service;

import br.fiap.gff.payments.domain.payments.dto.PaymentRequest;
import br.fiap.gff.payments.domain.receipts.Receipt;
import br.fiap.gff.payments.domain.receipts.ReceiptUseCase;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentService implements PaymentUseCase {
    private final ReceiptUseCase receiptUseCase;
    private final PaymentsBrokerPort paymentsBroker;

    @Override
    public Receipt pay(PaymentRequest request) {
        paymentsBroker.sendMessage(request);
        return receiptUseCase.create(request);
    }
}
