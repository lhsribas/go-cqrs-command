package br.com.lhsribas.cqrs.infra.eventsourcing;

import br.com.lhsribas.cqrs.infra.db.model.Payment;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PaymentJsonWritter {

    public static String write(final Payment payment) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(payment);
    }
}
