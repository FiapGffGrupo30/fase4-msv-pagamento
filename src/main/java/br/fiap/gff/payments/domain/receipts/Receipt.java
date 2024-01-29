package br.fiap.gff.payments.domain.receipts;

import br.fiap.gff.payments.domain.receipts.enums.ReceiptStatus;

public record Receipt(String id, Long customerId, String orderId, Double amountPaid, ReceiptStatus status) {
    
}
