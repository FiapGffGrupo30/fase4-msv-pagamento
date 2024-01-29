package br.fiap.gff.payments.domain.receipts;

import java.util.List;

import org.springframework.stereotype.Service;

import br.fiap.gff.payments.domain.payments.dto.PaymentRequest;
import br.fiap.gff.payments.domain.receipts.enums.ReceiptStatus;
import br.fiap.gff.payments.domain.receipts.exceptions.ReceiptNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReceiptService implements ReceiptUseCase {

    private final ReceiptDAO dao;

    @Override
    public Receipt create(PaymentRequest request) {
        Receipt receipt = new Receipt(null, request.customerId(), request.orderId(), request.valueToPay(),
                ReceiptStatus.PAID);
        return save(receipt);
    }

    @Override
    public Receipt save(Receipt receipt) {
        return dao.save(receipt);
    }

    @Override
    public Receipt getById(String id) {
        return dao.findById(id).orElseThrow(() -> new ReceiptNotFoundException("Receipt not found!"));
    }

    @Override
    public List<Receipt> getByCustomerId(Long customerId) {
       return dao.findByCustomerId(customerId);
    }

}
