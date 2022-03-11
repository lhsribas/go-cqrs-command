package br.com.lhsribas.cqrs.infra.eventsourcing;

import br.com.lhsribas.cqrs.domain.entity.EPayment;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PaymentJsonWritter {

    public static String write(final EPayment ePayment) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        var json = objectMapper.writeValueAsString(ePayment);
        return json.replaceAll("\"", "'");
    }
}
