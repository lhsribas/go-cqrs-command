package br.com.lhsribas.cqrs.domain.gateway;

import br.com.lhsribas.cqrs.domain.entity.EPayment;

public interface PaymentGateway {

    EPayment savePayment(EPayment ePayment);

}
