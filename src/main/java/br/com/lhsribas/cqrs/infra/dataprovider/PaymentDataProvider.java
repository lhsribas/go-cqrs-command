package br.com.lhsribas.cqrs.infra.dataprovider;

import br.com.lhsribas.cqrs.domain.entity.EPayment;
import br.com.lhsribas.cqrs.domain.gateway.PaymentGateway;
import br.com.lhsribas.cqrs.infra.db.repository.PaymentRepository;
import br.com.lhsribas.cqrs.infra.eventsourcing.PaymentJsonWritter;
import br.com.lhsribas.cqrs.infra.eventsourcing.PaymentNotifier;
import br.com.lhsribas.cqrs.infra.mapper.PaymentMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class PaymentDataProvider implements PaymentGateway {

    @Inject
    private PaymentRepository repository;

    @Inject
    private PaymentNotifier notifier;

    @Override
    public EPayment savePayment(EPayment ePayment) {
        var payment = PaymentMapper.toModel(ePayment);

        //Save the information in the database
        var response = PaymentMapper.toEntity(repository.save(payment));

        // sends the notification
        this.notify(response);

        return  response;
    }

    public void notify(final EPayment ePayment){
        //Event to Notify the persistence
        try{
            notifier.notify(ePayment, PaymentJsonWritter.write(ePayment));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
