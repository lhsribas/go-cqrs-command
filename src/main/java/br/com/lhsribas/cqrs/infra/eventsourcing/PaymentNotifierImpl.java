package br.com.lhsribas.cqrs.infra.eventsourcing;

import br.com.lhsribas.cqrs.domain.entity.EPayment;
import org.eclipse.microprofile.faulttolerance.Retry;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
final class PaymentNotifierImpl implements PaymentNotifier{

   @Inject
    private PaymentIncremenService service;

    @Retry(maxRetries = 4, delay = 5L)
    @Override
    public void notify(EPayment ePayment, final String data) {
        try {
            var key = ePayment.getCustomer().concat("_").concat(ePayment.getId().toString());
            service.increment(key, data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
