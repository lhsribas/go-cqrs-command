package br.com.lhsribas.cqrs.app.mapper;

import br.com.lhsribas.cqrs.app.dto.PaymentRequest;
import br.com.lhsribas.cqrs.domain.entity.EPayment;

import java.time.LocalDateTime;
import java.util.Objects;


public class PaymentRequestMapper {

    public static EPayment toEntity(PaymentRequest request){
        Objects.nonNull(request);

        var ePayment = new EPayment();
        ePayment.setCustomer(request.getCustomer());
        ePayment.setDate(LocalDateTime.now());
        ePayment.setLatitude(request.getLatitude());
        ePayment.setLongitude(request.getLongitude());
        ePayment.setProduct(request.getProduct());
        ePayment.setValue(request.getValue());

       return ePayment;
    }
}
