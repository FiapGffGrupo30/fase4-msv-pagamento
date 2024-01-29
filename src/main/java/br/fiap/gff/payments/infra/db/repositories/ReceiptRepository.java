package br.fiap.gff.payments.infra.db.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.fiap.gff.payments.infra.db.models.ReceiptModel;

@Repository
public interface ReceiptRepository extends MongoRepository<ReceiptModel, String> {
    List<ReceiptModel> findByCustomerId(Long id);
}
