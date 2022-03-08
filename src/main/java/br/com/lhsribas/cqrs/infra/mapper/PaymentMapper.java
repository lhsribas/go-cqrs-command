package br.com.lhsribas.cqrs.infra.mapper;

import br.com.lhsribas.cqrs.domain.entity.EPayment;
import br.com.lhsribas.cqrs.infra.db.model.Payment;

import java.util.Objects;

public class PaymentMapper {

    public static Payment toModel(EPayment ePayment){
        Objects.nonNull(ePayment);

        var payment = new Payment();
        payment.setProduct(ePayment.getProduct());
        payment.setDate(ePayment.getDate());
        payment.setLatitude(ePayment.getLatitude());
        payment.setLongitude(ePayment.getLongitude());
        payment.setValue(ePayment.getValue());

        return payment;
    }
}
