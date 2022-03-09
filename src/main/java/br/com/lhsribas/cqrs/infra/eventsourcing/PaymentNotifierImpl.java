package br.com.lhsribas.cqrs.infra.eventsourcing;

import br.com.lhsribas.cqrs.domain.entity.EPayment;
import br.com.lhsribas.cqrs.infra.db.model.Payment;
import com.fasterxml.jackson.core.JsonProcessingException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
final class PaymentNotifierImpl implements PaymentNotifier{

   @Inject
    private PaymentIncremenService service;

    @Override
    public void notify(EPayment ePayment) {
        try {
            var jsonPayment = PaymentJsonWritter.write(ePayment);
            service.increment(ePayment.getId().toString(), jsonPayment);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
