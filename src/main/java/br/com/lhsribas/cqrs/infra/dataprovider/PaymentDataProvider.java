package br.com.lhsribas.cqrs.infra.dataprovider;

import br.com.lhsribas.cqrs.domain.entity.EPayment;
import br.com.lhsribas.cqrs.domain.gateway.PaymentGateway;
import br.com.lhsribas.cqrs.infra.db.model.Payment;
import br.com.lhsribas.cqrs.infra.db.repository.PaymentRepository;
import br.com.lhsribas.cqrs.infra.eventsourcing.PaymentNotifier;
import br.com.lhsribas.cqrs.infra.mapper.PaymentMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class PaymentDataProvider implements PaymentGateway {

    @Inject
    private PaymentRepository repository;


    @Override
    public EPayment savePayment(EPayment ePayment) {
        var payment = PaymentMapper.toModel(ePayment);

        //Save the information in the database
        return PaymentMapper.toEntity(repository.save(payment));
    }

    public void notify(final Payment payment){
        //Event to Notify the persistence
    }
}
