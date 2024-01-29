package br.fiap.gff.payments.domain.receipts;

import java.util.List;
import java.util.Optional;

public interface ReceiptDAO {
    Receipt save(Receipt Receipt);

    Optional<Receipt> findById(String id);

    List<Receipt> findByCustomerId(Long id);

    List<Receipt> findAll(Long id);
}
