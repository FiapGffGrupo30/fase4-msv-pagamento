package br.fiap.gff.payments.domain.receipts;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.fiap.gff.payments.domain.payments.dto.PaymentRequest;
import br.fiap.gff.payments.domain.payments.enums.PaymentTypes;
import br.fiap.gff.payments.domain.receipts.enums.ReceiptStatus;

@ExtendWith(MockitoExtension.class)
public class ReceiptServiceTest {

    @Mock
    private ReceiptDAO dao;
    @InjectMocks
    private ReceiptService service;

    private static final Receipt RECEIPT = new Receipt("123", 1L, "456", 100d, ReceiptStatus.PAID);
    private static final PaymentRequest REQUEST = new PaymentRequest(1L, "456", 100.0, PaymentTypes.CREDIT_CARD);

    @Test
    void shouldCreateAReceipt() {
        // given
        when(dao.save(any(Receipt.class))).thenReturn(RECEIPT);
        // when
        Receipt act = service.create(REQUEST);
        // then
        assert act != null && act.id().equals(RECEIPT.id());
    }

    @Test
    void shouldGetByCustomerId() {
        when(dao.findByCustomerId(1L)).thenReturn(List.of(RECEIPT));
        // when
        List<Receipt> act = service.getByCustomerId(1L);
        // then
        assert act != null && act.size() == 1;
    }

    @Test
    void shouldGetById() {
        when(dao.findById("123")).thenReturn(java.util.Optional.of(RECEIPT));
        // when
        Receipt act = service.getById("123");
        // then
        assert act != null && act.id().equals(RECEIPT.id());
    }

    @Test
    void shouldSave() {
        // given
        when(dao.save(any(Receipt.class))).thenReturn(RECEIPT);
        // when
        Receipt act = service.save(RECEIPT);
        // then
        assert act != null && act.id().equals(RECEIPT.id());
    }
}
