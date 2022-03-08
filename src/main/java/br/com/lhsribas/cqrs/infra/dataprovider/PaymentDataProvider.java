package br.com.lhsribas.cqrs.infra.dataprovider;

import br.com.lhsribas.cqrs.domain.entity.EPayment;
import br.com.lhsribas.cqrs.domain.gateway.PaymentGateway;
import br.com.lhsribas.cqrs.infra.db.repository.PaymentRepository;
import br.com.lhsribas.cqrs.infra.eventsourcing.PaymentNotifier;
import br.com.lhsribas.cqrs.infra.mapper.PaymentMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class PaymentDataProvider implements PaymentGateway {

    @Inject
    private PaymentRepository repository;

    //@Inject
    //private PaymentNotifier notifier;

    @Override
    public void savePayment(EPayment ePayment) {
        var payment = PaymentMapper.toModel(ePayment);

        System.out.println("testetete");
        // Save the information in the database
        //repository.persist(payment);

        //Event to Notify the persistence
       //notifier.notify(payment);
    }
}
