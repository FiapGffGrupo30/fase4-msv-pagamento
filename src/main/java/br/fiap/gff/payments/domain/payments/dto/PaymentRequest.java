package br.fiap.gff.payments.domain.payments.dto;

import br.fiap.gff.payments.domain.payments.enums.PaymentTypes;

public record PaymentRequest(Long customerId, String orderId, Double valueToPay, PaymentTypes paymentType) {

}
