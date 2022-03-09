package br.com.lhsribas.cqrs.infra.eventsourcing;

import br.com.lhsribas.cqrs.domain.entity.EPayment;
import br.com.lhsribas.cqrs.infra.db.model.Payment;

public interface PaymentNotifier {

    void notify(final EPayment ePayment);

}
