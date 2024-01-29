package br.fiap.gff.payments.domain.payments;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.fiap.gff.payments.domain.payments.dto.PaymentRequest;
import br.fiap.gff.payments.domain.payments.enums.PaymentTypes;
import br.fiap.gff.payments.domain.receipts.Receipt;
import br.fiap.gff.payments.domain.receipts.ReceiptUseCase;
import br.fiap.gff.payments.domain.receipts.enums.ReceiptStatus;

@ExtendWith(MockitoExtension.class)
class PaymentServiceTest {

    @Mock
    private ReceiptUseCase receiptUseCase;
    @InjectMocks
    private PaymentService paymentService;

    @Test
    void shouldPayARequest() {
        Receipt receipt = new Receipt("456", 1L, "123", 100.0, ReceiptStatus.PAID);
        when(receiptUseCase.create(any(PaymentRequest.class))).thenReturn(receipt);
        // given
        PaymentRequest request = new PaymentRequest(1L, "123", 100.0, PaymentTypes.CREDIT_CARD);
        // when
        Receipt act = paymentService.pay(request);
        // then
        assert act != null && act.id().equals(receipt.id());
    }
}
