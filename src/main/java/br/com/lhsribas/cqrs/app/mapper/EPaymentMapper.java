package br.com.lhsribas.cqrs.app.mapper;

import br.com.lhsribas.cqrs.app.dto.PaymentRequest;
import br.com.lhsribas.cqrs.domain.entity.EPayment;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;


public class EPaymentMapper {

    public static EPayment toEntity(PaymentRequest request){
        Objects.nonNull(request);

        var ePayment = new EPayment();
        ePayment.setDate(LocalDateTime.now());
        ePayment.setLatitude(324234.4);
        ePayment.setLongitude(423423434.0);
        ePayment.setProduct("Nike SB Jordan 45");
        ePayment.setValue(new BigDecimal(650));


       return ePayment;
    }
}
