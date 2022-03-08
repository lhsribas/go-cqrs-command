package br.com.lhsribas.cqrs.infra.db.repository;

import br.com.lhsribas.cqrs.infra.db.model.Payment;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PaymentRepository implements PanacheRepository<Payment> {
}
