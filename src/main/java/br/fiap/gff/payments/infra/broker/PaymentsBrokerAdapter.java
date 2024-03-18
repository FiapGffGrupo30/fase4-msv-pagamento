package br.fiap.gff.payments.infra.broker;

import br.fiap.gff.payments.domain.payments.dto.PaymentRequest;
import br.fiap.gff.payments.domain.payments.port.PaymentsBrokerPort;
import br.fiap.gff.payments.infra.util.Jsonfy;
import io.awspring.cloud.sqs.annotation.SqsListener;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.services.sqs.model.Message;

@Component
@RequiredArgsConstructor
public class PaymentsBrokerAdapter implements PaymentsBrokerPort {

    private final SqsTemplate sqs;


    @Override
    public void sendMessage(PaymentRequest payment) {
        sqs.send(options -> options.queue("gff-payments").payload(Jsonfy.parse(payment)));
    }

    @SqsListener(queueNames = "gff-payments")
    public void onMessage(Message message) {
        // Processar a mensagem
        System.out.println("Mensagem recebida: " + message.body());
    }


}
