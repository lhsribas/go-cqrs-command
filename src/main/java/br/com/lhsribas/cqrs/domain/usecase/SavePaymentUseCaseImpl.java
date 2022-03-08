package br.com.lhsribas.cqrs.domain.usecase;

import br.com.lhsribas.cqrs.domain.entity.EPayment;
import br.com.lhsribas.cqrs.domain.gateway.PaymentGateway;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class SavePaymentUseCaseImpl implements SavePaymentUseCase {

    @Inject
    private PaymentGateway gateway;

    @Override
    public EPayment save(EPayment payment) {
        return gateway.savePayment(payment);
    }
}
