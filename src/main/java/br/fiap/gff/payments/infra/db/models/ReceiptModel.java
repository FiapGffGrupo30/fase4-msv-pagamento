package br.fiap.gff.payments.infra.db.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.fiap.gff.payments.domain.receipts.enums.ReceiptStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "receipts")
public class ReceiptModel {
    @Id
    private String id;
    private Long customerId;
    private String orderId;
    private Double amountPaid;
    private ReceiptStatus status;
}
