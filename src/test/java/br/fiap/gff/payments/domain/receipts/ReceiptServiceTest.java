package br.fiap.gff.payments.domain.receipts;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

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
    void testGetByCustomerId() {

    }

    @Test
    void testGetById() {

    }

    @Test
    void testSave() {

    }
}
