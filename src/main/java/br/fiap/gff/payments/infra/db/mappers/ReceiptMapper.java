package br.fiap.gff.payments.infra.db.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import br.fiap.gff.payments.domain.receipts.Receipt;
import br.fiap.gff.payments.infra.db.models.ReceiptModel;

@Mapper(componentModel = "spring")
public interface ReceiptMapper {
    Receipt fromModel(ReceiptModel model);

    List<Receipt> fromModel(List<ReceiptModel> models);

    ReceiptModel toModel(Receipt receipt);

    List<ReceiptModel> toModel(List<Receipt> receipts);
}
