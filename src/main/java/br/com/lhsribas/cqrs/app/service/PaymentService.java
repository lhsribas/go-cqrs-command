package br.com.lhsribas.cqrs.app.service;

import br.com.lhsribas.cqrs.app.dto.PaymentRequest;
import br.com.lhsribas.cqrs.app.mapper.EPaymentMapper;
import br.com.lhsribas.cqrs.domain.usecase.SavePaymentUseCase;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Objects;

@ApplicationScoped
public class PaymentService {

    @Inject
    private SavePaymentUseCase savePaymentUseCase;

    public void Save(final PaymentRequest request){
        Objects.nonNull(request);
        savePaymentUseCase.save(EPaymentMapper.toEntity(request));
    }

}
