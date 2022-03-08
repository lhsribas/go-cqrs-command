package br.com.lhsribas.cqrs.app.mapper;

import br.com.lhsribas.cqrs.app.dto.PaymentRequest;
import br.com.lhsribas.cqrs.app.dto.PaymentResponse;
import br.com.lhsribas.cqrs.domain.entity.EPayment;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;


public class EPaymentMapper {

    public static EPayment toEntity(PaymentRequest request){
        Objects.nonNull(request);

        var ePayment = new EPayment();
        ePayment.setDate(LocalDateTime.now());
        ePayment.setLatitude(request.getLatitude());
        ePayment.setLongitude(request.getLongitude());
        ePayment.setProduct(request.getProduct());
        ePayment.setValue(request.getValue());

       return ePayment;
    }

    public static PaymentResponse toResponse(EPayment ePayment){
        Objects.nonNull(ePayment);

        var response = new PaymentResponse();
        response.setId(ePayment.getId());
        response.setDate(ePayment.getDate());
        response.setLatitude(ePayment.getLatitude());
        response.setLongitude(ePayment.getLongitude());
        response.setProduct(ePayment.getProduct());
        response.setValue(ePayment.getValue());

        return response;
    }
}
