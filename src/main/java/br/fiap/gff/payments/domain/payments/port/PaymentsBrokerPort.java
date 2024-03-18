package br.fiap.gff.payments.domain.payments.port;

import br.fiap.gff.payments.domain.payments.dto.PaymentRequest;

public interface PaymentsBrokerPort {
    void sendMessage(PaymentRequest payment);
}
