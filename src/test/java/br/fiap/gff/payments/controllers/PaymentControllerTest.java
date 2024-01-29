package br.fiap.gff.payments.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import br.fiap.gff.payments.domain.payments.PaymentUseCase;
import br.fiap.gff.payments.domain.payments.dto.PaymentRequest;
import br.fiap.gff.payments.domain.payments.enums.PaymentTypes;
import br.fiap.gff.payments.domain.receipts.Receipt;
import br.fiap.gff.payments.domain.receipts.enums.ReceiptStatus;

@ExtendWith(MockitoExtension.class)
public class PaymentControllerTest {

    @Mock
    private PaymentUseCase useCase;
    @InjectMocks
    private PaymentController controller;

    @Test
    void shouldProccessPayForRequest() {
        Receipt receipt = new Receipt("456", 1L, "123", 100.0, ReceiptStatus.PAID);
        when(useCase.pay(any(PaymentRequest.class))).thenReturn(receipt);
        // given
        PaymentRequest request = new PaymentRequest(1L, "123", 100.0, PaymentTypes.CREDIT_CARD);
        // when
        ResponseEntity<Receipt> act = controller.pay(request);
        // then
        assert act.getStatusCode() == HttpStatusCode.valueOf(200) && act.getBody() != null;
    }
}
