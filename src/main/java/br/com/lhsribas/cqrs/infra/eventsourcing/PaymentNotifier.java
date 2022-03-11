package br.com.lhsribas.cqrs.infra.eventsourcing;

import br.com.lhsribas.cqrs.domain.entity.EPayment;

public interface PaymentNotifier {

    void notify(final EPayment ePayment, final String data);

}
