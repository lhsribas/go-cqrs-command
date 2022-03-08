package br.com.lhsribas.cqrs.infra.db.repository;

import br.com.lhsribas.cqrs.infra.db.model.Payment;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class PaymentRepository implements PanacheRepository<Payment> {

    @Transactional
    public Payment save(final Payment payment){
        EntityManager em = this.getEntityManager();
        return em.merge(payment);
    }
}
