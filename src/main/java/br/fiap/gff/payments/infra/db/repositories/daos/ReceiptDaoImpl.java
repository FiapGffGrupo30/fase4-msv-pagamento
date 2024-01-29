package br.fiap.gff.payments.infra.db.repositories.daos;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import br.fiap.gff.payments.domain.receipts.Receipt;
import br.fiap.gff.payments.domain.receipts.ReceiptDAO;
import br.fiap.gff.payments.infra.db.mappers.ReceiptMapper;
import br.fiap.gff.payments.infra.db.repositories.ReceiptRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ReceiptDaoImpl implements ReceiptDAO {
    private final ReceiptRepository repository;
    private final ReceiptMapper mapper;

    @Override
    public Receipt save(Receipt Receipt) {
        return mapper.fromModel(repository.save(mapper.toModel(Receipt)));
    }

    @Override
    public Optional<Receipt> findById(String id) {
        return repository.findById(id).map(mapper::fromModel);
    }

    @Override
    public List<Receipt> findByCustomerId(Long id) {
        return mapper.fromModel(repository.findByCustomerId(id));
    }

    @Override
    public List<Receipt> findAll(Long id) {
        return mapper.fromModel(repository.findAll());
    }
}
