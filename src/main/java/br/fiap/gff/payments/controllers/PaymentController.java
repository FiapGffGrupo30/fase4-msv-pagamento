package br.fiap.gff.payments.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.fiap.gff.payments.domain.payments.PaymentUseCase;
import br.fiap.gff.payments.domain.payments.dto.PaymentRequest;
import br.fiap.gff.payments.domain.receipts.Receipt;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("v1/payment")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentUseCase useCase;

    @PostMapping()
    public ResponseEntity<Receipt> pay(@RequestBody PaymentRequest request) {
        return ResponseEntity.ok(useCase.pay(request));
    }
}
