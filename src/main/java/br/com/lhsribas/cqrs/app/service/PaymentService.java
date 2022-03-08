package br.com.lhsribas.cqrs.app.service;

import br.com.lhsribas.cqrs.app.dto.PaymentRequest;
import br.com.lhsribas.cqrs.app.dto.PaymentResponse;
import br.com.lhsribas.cqrs.app.mapper.EPaymentMapper;
import br.com.lhsribas.cqrs.domain.usecase.SavePaymentUseCase;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Objects;
import java.util.function.Supplier;

@ApplicationScoped
public class PaymentService {

    @Inject
    private SavePaymentUseCase savePaymentUseCase;

    public PaymentResponse save(final PaymentRequest request){
        return EPaymentMapper.toResponse(savePaymentUseCase.save(EPaymentMapper.toEntity(request)));
    }
}
