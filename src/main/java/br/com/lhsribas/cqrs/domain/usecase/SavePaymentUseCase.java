package br.com.lhsribas.cqrs.domain.usecase;

import br.com.lhsribas.cqrs.domain.entity.EPayment;

public interface SavePaymentUseCase {

    EPayment save(final EPayment payment);
}
